package com.example.xpgainer;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class XpGainer extends AppCompatActivity {
    private Button taskbutton;
    private Button profilebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xp_gainer);
        taskbutton = (Button) findViewById(R.id.tasks);

        taskbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTasks();

            }
        });
        profilebutton = (Button) findViewById(R.id.profile);
        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();

            }
        });
    }

    public void openTasks() {
        Intent intent = new Intent(this, Tasks.class);
        startActivity(intent);


    }
    public void openProfile() {
        Intent intent2 = new Intent(this, Profile.class);
        startActivity(intent2);


    }
}