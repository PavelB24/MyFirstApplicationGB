package com.gb.my1application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SecondaryActivity extends AppCompatActivity {
    SharedPreferences profile;
    EditText phoneEditText;
    EditText mailEditText;
    EditText passwordEditText;
    SharedPreferences.Editor prefEditor;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        toInitialize();
        button.setOnClickListener(view -> {
            prefEditor.putString("Phone", phoneEditText.toString());
            prefEditor.putString("Mail", mailEditText.toString());
            prefEditor.putString("Password", passwordEditText.toString());
            prefEditor.apply();
        });
    }

    private void toInitialize() {
        phoneEditText = findViewById(R.id.phone_num);
        mailEditText = findViewById(R.id.e_mail);
        passwordEditText = findViewById(R.id.password);
        profile = getSharedPreferences("Profile", MODE_PRIVATE);
        prefEditor = profile.edit();
        button = findViewById(R.id.final_button);
    }
}