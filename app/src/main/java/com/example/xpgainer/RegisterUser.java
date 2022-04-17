package com.example.xpgainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterUser extends AppCompatActivity {

    private EditText edtTxtName, edtTxtEmail, edtTxtPassword, edtTxtRePass;

    private TextView txtWarnName, txtWarnEmail, txtWarnPass, txtWarnRePass;

    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        initView();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRegister();
            }
        });
    }

    private void initRegister() {
        if(validateData() ){
            txtWarnName.setVisibility(View.GONE);
            txtWarnEmail.setVisibility(View.GONE);
            txtWarnPass.setVisibility(View.GONE);
            txtWarnRePass.setVisibility(View.GONE);
        }
    }

    private boolean validateData(){
        if(edtTxtName.getText().toString().equals("")){
            txtWarnName.setVisibility(View.VISIBLE);
            txtWarnName.setText("Enter your Name");
            return false;
        }

        if(edtTxtEmail.getText().toString().equals("")){
            txtWarnEmail.setVisibility(View.VISIBLE);
            txtWarnEmail.setText("Enter your Email");
            return false;
        }

        if(edtTxtPassword.getText().toString().equals("")){
            txtWarnPass.setVisibility(View.VISIBLE);
            txtWarnPass.setText("Enter your Password");
            return false;
        }

        if(edtTxtRePass.getText().toString().equals("")){
            txtWarnRePass.setVisibility(View.VISIBLE);
            txtWarnRePass.setText("Re Enter your Password");
            return false;
        }

        if(!edtTxtPassword.getText().toString().equals(edtTxtRePass.getText().toString())){
            txtWarnRePass.setVisibility(View.VISIBLE);
            txtWarnRePass.setText("Password doesn't match");
        }

        return true;
    }

    private void initView(){
        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtEmail = findViewById(R.id.edtTxtEmail);
        edtTxtPassword = findViewById(R.id.edtTxtPassword);
        edtTxtRePass = findViewById(R.id.edtTxtRePass);

        txtWarnName = findViewById(R.id.txtWarnName);
        txtWarnEmail = findViewById(R.id.txtWarnEmail);
        txtWarnPass = findViewById(R.id.txtWarnPass);
        txtWarnRePass = findViewById(R.id.txtWarnRePass);

        btnRegister = findViewById(R.id.btnRegister);
    }


}