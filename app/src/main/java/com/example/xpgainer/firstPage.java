package com.example.xpgainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class firstPage extends AppCompatActivity {

    private EditText edtTxtPassword, edtTxtEmail;
    private TextView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        edtTxtPassword = findViewById(R.id.edtTxtEmail1);
        edtTxtEmail = findViewById(R.id.edtTxtPassword1);

        banner = findViewById(R.id.banner1);
    }
}