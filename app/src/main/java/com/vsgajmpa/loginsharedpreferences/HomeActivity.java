package com.vsgajmpa.loginsharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textUsername = findViewById(R.id.text_username);
        Button buttonLogout = findViewById(R.id.button_logout);

        textUsername.setText(Preferences.getUser(this));

        buttonLogout.setOnClickListener(v -> {
            Preferences.unregisterUser(this);
            startActivity(new Intent(this, MainActivity.class));
            finishAffinity();
        });
    }
}
