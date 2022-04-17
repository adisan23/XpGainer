package com.example.xpgainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class XpGainer extends AppCompatActivity {
    private Button taskbutton;
    private Button profilebutton;
    private Button activitybutton;
    private ListView actTasks;
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
        activitybutton = (Button) findViewById(R.id.activities);
        activitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivites();

            }
        });
        actTasks = findViewById(R.id.actTasks);
        ArrayList aTasks = new ArrayList<>();
        aTasks.add("Run 3 miles");
        aTasks.add("Read a book");
        aTasks.add("Find a hobby");
        ArrayAdapter<String> atasksList = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                aTasks
        );

        actTasks.setAdapter(atasksList);

    }

    public void openTasks() {
        Intent intent = new Intent(this, Tasks.class);
        startActivity(intent);


    }
    public void openProfile() {
        Intent intent2 = new Intent(this, Profile.class);
        startActivity(intent2);


    }
    public void openActivites() {
        Intent activitiesintent = new Intent(this, Activities.class);
        startActivity(activitiesintent);


    }
}
