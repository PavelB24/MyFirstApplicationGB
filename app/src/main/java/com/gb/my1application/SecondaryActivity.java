package com.gb.my1application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SecondaryActivity extends AppCompatActivity {
    SharedPreferences profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        Button button = findViewById(R.id.final_button);
        button.setOnClickListener(view -> {
            EditText phoneEditText = findViewById(R.id.phone_num);
            EditText mailEditText = findViewById(R.id.e_mail);
            EditText passwordEditText = findViewById(R.id.password);
            profile = getSharedPreferences("Profile", MODE_PRIVATE);
            SharedPreferences.Editor prefEditor = profile.edit();
            prefEditor.putString("Phone", phoneEditText.toString());
            prefEditor.putString("Mail", mailEditText.toString());
            prefEditor.putString("Password", passwordEditText.toString());
        });

    }
}