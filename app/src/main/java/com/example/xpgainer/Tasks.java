package com.example.xpgainer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tasks extends AppCompatActivity {

    private ListView listAvailable;
    private Switch activeSwitch;
    private int positionEliminate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        listAvailable = findViewById(R.id.listAvailable);

        activeSwitch = (Switch) findViewById(R.id.switch2);

        ArrayList<String> tasks = new ArrayList<>();

        tasks.add("Run 3 miles");
        tasks.add("Read a book");
        tasks.add("Find a hobby");

        ArrayList<String> tasks_completed = new ArrayList<>();

        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked , tasks);

        listAvailable.setAdapter(arrayAdapter);

        listAvailable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listAvailable.setItemChecked(position, true);
                if(listAvailable.isItemChecked(position)){
                    positionEliminate = position;
                    tasks.remove(position);
                    listAvailable.setAdapter(arrayAdapter);
                }
            }
        });

    }


}

