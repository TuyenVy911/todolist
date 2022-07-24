package com.example.instagram18;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instagram18.api.ApiServer;
import com.example.instagram18.api.RetrofitClient;
import com.example.instagram18.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity {

    EditText username, fullname, email, password;
    Button btn_register;
    TextView txt_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        fullname = findViewById(R.id.fullname);
        password = findViewById(R.id.password);
        btn_register = findViewById(R.id.btn_register);
        txt_login = findViewById(R.id.txt_login);

        //auth = FirebaseAuth.getInstance();

        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String str_username = username.getText().toString();
                String str_fullname = fullname.getText().toString();
                String str_email = email.getText().toString();
                String str_password = password.getText().toString();

                User newUser = new User(str_username, str_fullname, str_email, str_password);
                RetrofitClient.getRetrofitClient().register(newUser).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Register Successfull!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "Register fail!", Toast.LENGTH_SHORT).show();
                    }
                });
//                ApiServer.apiServer.register(newUser).enqueue(new Callback<User>() {
//                    @Override
//                    public void onResponse(Call<User> call, Response<User> response) {
//                        if(response.isSuccessful()){
//                            Toast.makeText(RegisterActivity.this, "Register Successfull!", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                            startActivity(intent);
//                            finish();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<User> call, Throwable t) {
//
//                    }
//                });
            }
        });
    }

}