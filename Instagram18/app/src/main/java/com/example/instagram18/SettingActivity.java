package com.example.instagram18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.instagram18.fragment.HomeFragment;
import com.example.instagram18.fragment.ProfileFragment;

public class SettingActivity extends AppCompatActivity {
    TextView tvEmail, tvFullname, tvUsername, tvPassword;
    Button btn_change, btn_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        tvEmail = findViewById(R.id.textviewEmail);
        tvFullname = findViewById(R.id.textviewFullname);
        tvUsername = findViewById(R.id.textviewUsername);
        tvPassword = findViewById(R.id.textviewPassword);
        btn_change = findViewById(R.id.btn_change);
        btn_cancel = findViewById(R.id.btn_cancel);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, ProfileFragment.class);
                startActivity(intent);
                finish();
            }
        });
    }
}