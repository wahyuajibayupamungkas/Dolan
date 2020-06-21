package com.haphap.sosialmediaapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.haphap.sosialmediaapp.MainActivity;
import com.haphap.sosialmediaapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvRegister;
    String name, username, password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        tvRegister = findViewById(R.id.tv_register);

        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);

        name = getIntent().getStringExtra("NAME");
        username = getIntent().getStringExtra("USERNAME");
        password = getIntent().getStringExtra("PASSWORD");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login :
                String textUsername = etUsername.getText().toString();
                String textPassword = etPassword.getText().toString();
                if (textUsername.trim().isEmpty() || textPassword.trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Username atau Password kosong !",Toast.LENGTH_SHORT).show();
                } else if (textUsername.equals(username) && textPassword.equals(password)){
                    Intent intentData = new Intent(LoginActivity.this, MainActivity.class);
                    intentData.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intentData.putExtra("NAME", name);
                    intentData.putExtra("USERNAME", username);
                    startActivity(intentData);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Username atau Password salah !",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tv_register :
                Intent intentTanpaData = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intentTanpaData);
                break;
        }
    }
}
