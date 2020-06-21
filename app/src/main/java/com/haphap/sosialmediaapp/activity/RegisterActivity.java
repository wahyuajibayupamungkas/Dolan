package com.haphap.sosialmediaapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.haphap.sosialmediaapp.MainActivity;
import com.haphap.sosialmediaapp.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etUsername, etPassword;
    TextView tvLogin;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.et_name);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnRegister = findViewById(R.id.btn_register);
        tvLogin = findViewById(R.id.tv_login);

        btnRegister.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register :
                String name = etName.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (name.trim().isEmpty() || username.trim().isEmpty() || password.trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Harus mengisi semua kolom !",Toast.LENGTH_SHORT).show();
                } else {
                    Intent intentData = new Intent(RegisterActivity.this, LoginActivity.class);
                    intentData.putExtra("NAME", name);
                    intentData.putExtra("USERNAME", username);
                    intentData.putExtra("PASSWORD", password);
                    startActivity(intentData);
                    finish();
                }
                break;
            case R.id.tv_login :
                Intent intentTanpaData = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intentTanpaData);
                break;
        }
    }
}
