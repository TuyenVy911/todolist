package com.example.instagram18;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instagram18.api.ApiServer;
import com.example.instagram18.api.RetrofitClient;
import com.example.instagram18.fragment.HomeFragment;
import com.example.instagram18.models.User;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText eUsername, ePassword;
    Button btn_login;
    TextView txt_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUsername = findViewById(R.id.username);
        ePassword = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        txt_signup = findViewById(R.id.txt_signup);

        txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str_username = eUsername.getText().toString();
                String str_password = ePassword.getText().toString();

                RetrofitClient.getRetrofitClient().login(str_username,str_password).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.isSuccessful()){
                            User user = response.body();
                            Log.e("ZZZ", "onResponse: "+user.getUsername() );
                            Toast.makeText(LoginActivity.this, "Login Successfull!", Toast.LENGTH_SHORT).show();
                            if(user != null){
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("username", str_username);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(LoginActivity.this, "Wrong username or password!", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.e("ZZZ", "onResponse: "+t );
                    }
                });
            }
        });
    }
}