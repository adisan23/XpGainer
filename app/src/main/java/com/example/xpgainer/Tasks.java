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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        listAvailable = findViewById(R.id.listAvailable);

        activeSwitch = (Switch) findViewById(R.id.switch2);

        this.listAvailable.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        this.listAvailable.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckedTextView v = (CheckedTextView) view;
                boolean currentCheck = v.isChecked();
                TasksHelper avTasks = (TasksHelper) listAvailable.getItemAtPosition(position);
                avTasks.setActive(!currentCheck);

            }
        });

        this.initListViewData();
    }

    private void initListViewData()  {

        TasksHelper task1 = new TasksHelper("Run 3 miles");
        TasksHelper task2 = new TasksHelper("Read a book");
        TasksHelper task3 = new TasksHelper("Find a hobby");

        TasksHelper[] tasks = new TasksHelper[]{task1,task2, task3};

        // android.R.layout.simple_list_item_checked:
        // ListItem is very simple (Only one CheckedTextView).
        ArrayAdapter<TasksHelper> arrayAdapter
                = new ArrayAdapter<TasksHelper>(this, android.R.layout.simple_list_item_checked , tasks);

        this.listAvailable.setAdapter(arrayAdapter);

        for(int i=0;i< tasks.length; i++ )  {
            this.listAvailable.setItemChecked(i,tasks[i].isActive());
        }

        }
}

