package com.example.instagram18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instagram18.api.ApiServer;
import com.example.instagram18.api.RetrofitClient;
import com.example.instagram18.fragment.HomeFragment;
import com.example.instagram18.models.Post;
import com.example.instagram18.models.User;

import java.text.DateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity {
    EditText content;
    TextView createdate, username;
    Button btn_create, btn_cancel1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Calendar calendar = Calendar.getInstance();
        String  currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        createdate = findViewById(R.id.tvCurrentDate);
        createdate.setText(currentDate);
        
        content = findViewById(R.id.edittextContent);
        //username = findViewById(R.id.tvUsername);
        btn_create = findViewById(R.id.btn_create);
        btn_cancel1 = findViewById(R.id.btn_cancel1);

        //pass data from mainactivity to addactivity
        Intent intent2 = getIntent();
        String name2 = intent2.getStringExtra("username1");
        username = findViewById(R.id.tvUsername);
        username.setText(name2);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_username = username.getText().toString();
                String str_createdate = createdate.getText().toString();
                String str_content = content.getText().toString();

                Post newPost = new Post(str_username,str_createdate, str_content);
                RetrofitClient.getRetrofitClient().add(newPost).enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(AddActivity.this, "Add post Successfull!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AddActivity.this, HomeFragment.class);
                            startActivity(intent);
                            //finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        Toast.makeText(AddActivity.this, "Add fail!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn_cancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddActivity.this, HomeFragment.class);
                startActivity(intent);
                finish();
            }
        });
    }
}