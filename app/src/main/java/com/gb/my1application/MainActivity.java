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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.submit_button);
        button.setOnClickListener(view -> {
            profile = getSharedPreferences("Profile", MODE_PRIVATE);
            EditText nameEditText = findViewById(R.id.name);
            EditText surnameEditText = findViewById(R.id.surname);
            EditText ageEditText = findViewById(R.id.age);
            ToggleButton tb1ToggleButton = findViewById(R.id.tb1);
            ToggleButton tb2ToggleButton = findViewById(R.id.tb2);
            CheckBox checkBox = findViewById(R.id.checkbox1);
            CalendarView calendarView = findViewById(R.id.calendar);
            collectData(nameEditText, surnameEditText, ageEditText, tb1ToggleButton,
                    tb2ToggleButton, checkBox, calendarView);
            Intent switcher = new Intent(MainActivity.this, SecondaryActivity.class);
            MainActivity.this.startActivity(switcher);
        });
    }

    private void collectData(EditText name, EditText surname, EditText age, ToggleButton tb1,
                             ToggleButton tb2, CheckBox checkBox, CalendarView calendarView) {
        SharedPreferences.Editor prefEditor = profile.edit();
        prefEditor.putString("Name", name.toString());
        prefEditor.putString("Surname", surname.toString());
        prefEditor.putInt("Birthday", calendarView.getDateTextAppearance());
        prefEditor.putString("Age", age.toString());
        prefEditor.putBoolean("Subscribed", tb1.isChecked());
        prefEditor.putBoolean("Insured", tb2.isChecked());
        prefEditor.putBoolean("Permission", checkBox.isChecked());
    }
}