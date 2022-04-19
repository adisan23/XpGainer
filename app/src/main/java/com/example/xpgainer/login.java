package com.example.xpgainer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    private EditText edtTxtPassword, edtTxtEmail;
    private TextView banner;
    private Button loginBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtTxtPassword = findViewById(R.id.edtTxtEmail1);
        edtTxtEmail = findViewById(R.id.edtTxtPassword1);

        banner = findViewById(R.id.banner1);
        loginBtn = findViewById(R.id.loginBtn);

        mAuth = FirebaseAuth.getInstance();

    }


    public void onClick(View view) {
        switch(view.getId()){
            case R.id.banner:
                startActivity(new Intent(this, LaunchPage.class));
                break;
            case R.id.btnRegister:
                loginUser();
                break;
        }
    }

    private void loginUser(){
        String email = edtTxtEmail.getText().toString().trim();
        String password = edtTxtPassword.getText().toString().trim();

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
            edtTxtPassword.setError("Min password length should be 6 characters");
            edtTxtPassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(login.this, "Successfully Logged In", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(login.this, XpGainer.class));
                }else{
                    Toast.makeText(login.this, "Account doesn't exist! Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}