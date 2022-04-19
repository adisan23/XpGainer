package com.example.xpgainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {

    private EditText edtTxtPassword, edtTxtEmail;
    private TextView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtTxtPassword = findViewById(R.id.edtTxtEmail1);
        edtTxtEmail = findViewById(R.id.edtTxtPassword1);

        banner = findViewById(R.id.banner1);

        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}