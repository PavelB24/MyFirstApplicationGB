package com.gb.my1application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.submit_button);
        button.setOnClickListener(view -> {
            EditText name = findViewById(R.id.name);
            EditText surname = findViewById(R.id.surname);
            EditText age = findViewById(R.id.age);
            settings = getSharedPreferences("Profile", MODE_PRIVATE);
            SharedPreferences.Editor prefEditor = settings.edit();
            prefEditor.putString()=
                    collectData(name, surname, age);

            Intent switcher= new Intent(MainActivity.this, SecondaryActivity.class);
            MainActivity.this.startActivity(switcher);
        });
    }

    private void collectData(EditText name, EditText surname, EditText age) {
    }
}