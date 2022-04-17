package com.example.xpgainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Profile extends AppCompatActivity {

    private ImageView profileImage;

    private TextView txtLevel, txtUsername, txtTasks;

    private ProgressBar progressBar;

    private ListView tasksCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tasksCompleted = findViewById(R.id.tasksCompleted);

        ArrayList Tasks = new ArrayList<>();

        Tasks.add("Run 3 miles");
        Tasks.add("Read a book");
        Tasks.add("Find a hobby");
        Tasks.add("Run 3 miles");
        Tasks.add("Run 3 miles");
        Tasks.add("Run 3 miles");
        Tasks.add("Run 3 miles");
        Tasks.add("Run 3 miles");
        Tasks.add("Run 3 miles");
        Tasks.add("Run 3 miles");
        Tasks.add("Run 3 miles");
        Tasks.add("Run 3 miles");
        Tasks.add("Run 3 miles");

        ArrayAdapter<String> tasksList = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Tasks
        );

        tasksCompleted.setAdapter(tasksList);

    }
}