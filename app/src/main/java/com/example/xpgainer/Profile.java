package com.example.xpgainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private ImageView profileImage;

    private TextView txtLevel, txtUsername, txtTasks;

    private ProgressBar progressBar;

    private ListView tasksCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

    }
}