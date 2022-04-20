package com.example.xpgainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LaunchPage extends AppCompatActivity {
    private Button registering;
    private Button lounging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_page);

        registering = findViewById(R.id.register);
        registering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();

            }
        });

        lounging = findViewById(R.id.login);
        lounging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });

    }

    public void openRegister() {
        Intent intent = new Intent(this, RegisterUser.class);
        startActivity(intent);


    }
    public void openLogin() {
        Intent intent2 = new Intent(this, login.class);
        startActivity(intent2);


    }
}