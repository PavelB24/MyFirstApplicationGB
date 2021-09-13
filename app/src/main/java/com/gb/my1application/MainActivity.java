package com.gb.my1application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    SharedPreferences profile;
    EditText nameEditText;
    EditText surnameEditText;
    EditText ageEditText;
    ToggleButton tb1ToggleButton;
    ToggleButton tb2ToggleButton;
    CheckBox checkBox;
    CalendarView calendarView;
    Button button;
    SharedPreferences.Editor prefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toInitialize();
        button.setOnClickListener(view -> {
            collectData();
            Intent switcher = new Intent(MainActivity.this, SecondaryActivity.class);
            MainActivity.this.startActivity(switcher);
        });
    }

    private void toInitialize() {
        profile = getSharedPreferences("Profile", MODE_PRIVATE);
        nameEditText = findViewById(R.id.name);
        surnameEditText = findViewById(R.id.surname);
        ageEditText = findViewById(R.id.age);
        tb1ToggleButton = findViewById(R.id.tb1);
        tb2ToggleButton = findViewById(R.id.tb2);
        checkBox = findViewById(R.id.checkbox1);
        calendarView = findViewById(R.id.calendar);
        button = findViewById(R.id.submit_button);
        prefEditor = profile.edit();
    }

    private void collectData() {
        SharedPreferences.Editor prefEditor = profile.edit();
        prefEditor.putString("Name", nameEditText.toString());
        prefEditor.putString("Surname", surnameEditText.toString());
        prefEditor.putInt("Birthday", calendarView.getDateTextAppearance());
        prefEditor.putString("Age", ageEditText.toString());
        prefEditor.putBoolean("Subscribed", tb1ToggleButton.isChecked());
        prefEditor.putBoolean("Insured", tb2ToggleButton.isChecked());
        prefEditor.putBoolean("Permission", checkBox.isChecked());
        prefEditor.apply();
    }
}