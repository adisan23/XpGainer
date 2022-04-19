package com.example.xpgainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class Tasks extends AppCompatActivity {

    private ListView availTasks;
    private Switch activeSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        availTasks = findViewById(R.id.availablelist);
        ArrayList avTasks = new ArrayList<>();
        avTasks.add("Run 3 miles");
        avTasks.add("Read a book");
        avTasks.add("Find a hobby");
        ArrayAdapter<String> avtaskList = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                avTasks
        );


        availTasks.setAdapter(avtaskList);

        activeSwitch = (Switch) findViewById(R.id.switch2);


        availTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Click List Number" + position, Toast.LENGTH_LONG).show();
                activeSwitch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Boolean switchState = activeSwitch.isChecked();

                        if (activeSwitch.isChecked()) {
                            activeSwitch.setChecked(true);
                        } else {
                            activeSwitch.setChecked(false);
                        }

                    }
                });
            }
        });
    }
}