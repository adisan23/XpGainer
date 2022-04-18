package com.example.xpgainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener{

    private EditText edtTxtName, edtTxtEmail, edtTxtPassword, edtTxtAge;
    private TextView banner, btnRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        initView();

        mAuth = FirebaseAuth.getInstance();

        banner = findViewById(R.id.banner);
        banner.setOnClickListener(this);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);


    }

    private void initView(){
        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtEmail = findViewById(R.id.edtTxtEmail);
        edtTxtPassword = findViewById(R.id.edtTxtPassword);
        edtTxtAge = findViewById(R.id.edtTxtAge);

        btnRegister = findViewById(R.id.btnRegister);

        banner = findViewById(R.id.banner);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.banner:
                startActivity(new Intent(this, XpGainer.class));
                break;
                case R.id.btnRegister:
                    registerUser();
                    break;
        }
    }

    private void registerUser() {
        String email = edtTxtEmail.getText().toString().trim();
        String password = edtTxtPassword.getText().toString().trim();
        String name = edtTxtName.getText().toString().trim();
        String age = edtTxtAge.getText().toString().trim();

        if(name.isEmpty()){
            edtTxtName.setError("Name is required");
            edtTxtName.requestFocus();
            return;
        }

       if(age.isEmpty()){
           edtTxtAge.setError("Age is required");
           edtTxtAge.requestFocus();
           return;
       }

       if(email.isEmpty()){
           edtTxtEmail.setError("Email is required");
           edtTxtEmail.requestFocus();
           return;
       }

       if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
           edtTxtEmail.setError("Please provide valid email!");
           edtTxtEmail.requestFocus();
           return;
       }

       if(password.isEmpty()){
           edtTxtPassword.setError("Password is required");
           edtTxtPassword.requestFocus();
           return;
       }

       if(password.length() < 6){
           edtTxtPassword.setError("Password is required");
           edtTxtPassword.requestFocus();
           return;
       }


    }

}