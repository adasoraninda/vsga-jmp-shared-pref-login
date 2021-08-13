package com.vsgajmpa.loginsharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputUsername = findViewById(R.id.input_username);
        Button buttonLogin = findViewById(R.id.button_login);

        if (Preferences.getUser(this) != null) {
            startActivity(new Intent(this, HomeActivity.class));
            return;
        }

        buttonLogin.setOnClickListener(v -> {
            String username = inputUsername.getText().toString().trim();
            Preferences.registerUser(this, username);

            startActivity(new Intent(this, HomeActivity.class));
        });

    }
}