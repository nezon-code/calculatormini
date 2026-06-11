package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingsb);

        Button b = findViewById(R.id.button5);

        TextView user = findViewById(R.id.user);

        b.setOnClickListener(v ->
        {
            finish();
        });
    }
}
