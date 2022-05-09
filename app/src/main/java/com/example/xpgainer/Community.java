package com.example.xpgainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Community extends AppCompatActivity {

    private Button leaderboard;
    private Button ctask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        leaderboard = (Button) findViewById(R.id.leaderboard);

        leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLeaderboard();

            }
        });

        ctask = (Button) findViewById(R.id.ctasks);

        ctask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCommunityTasks();

            }
        });



    }

    public void openLeaderboard() {
        Intent intent = new Intent(this, Leaderboard.class);
        startActivity(intent);
    }

    public void openCommunityTasks() {
        Intent intent = new Intent(this, CommunityTasks.class);
        startActivity(intent);
    }

}