package com.example.xpgainer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegisterUser extends AppCompatActivity {

    private EditText edtTxtName, edtTxtEmail, edtTxtPassword, edtTxtAge;
    private TextView banner;
    private Button btnRegister;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        banner = findViewById(R.id.banner);
        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterUser.this, XpGainer.class));
            }
        });

        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtEmail = findViewById(R.id.edtTxtEmail);
        edtTxtPassword = findViewById(R.id.edtTxtPassword);
        edtTxtAge = findViewById(R.id.edtTxtAge);

        btnRegister = findViewById(R.id.btnRegister);

        banner = findViewById(R.id.banner);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

        private void registerUser () {
            String email = edtTxtEmail.getText().toString().trim();
            String password = edtTxtPassword.getText().toString().trim();
            String password1 = edtTxtPassword.getText().toString().trim();
            String name = edtTxtName.getText().toString().trim();
            String age = edtTxtAge.getText().toString().trim();

            if (name.isEmpty()) {
                edtTxtName.setError("Name is required");
                edtTxtName.requestFocus();
                return;
            }

            if (age.isEmpty()) {
                edtTxtAge.setError("Age is required");
                edtTxtAge.requestFocus();
                return;
            }

            if (email.isEmpty()) {
                edtTxtEmail.setError("Email is required");
                edtTxtEmail.requestFocus();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                edtTxtEmail.setError("Please provide valid email!");
                edtTxtEmail.requestFocus();
                return;
            }

            if (password.isEmpty()) {
                edtTxtPassword.setError("Password is required");
                edtTxtPassword.requestFocus();
                return;
            }

            if (password.length() < 6) {
                edtTxtPassword.setError("Min password length should be 6 characters");
                edtTxtPassword.requestFocus();
                return;
            }

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                User user = new User(name, age, email, 1, 0);

                                FirebaseDatabase.getInstance("https://xpgainer-4d2dd-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {

                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            startActivity(new Intent(RegisterUser.this, LaunchPage.class));
                                            Toast.makeText(RegisterUser.this, "User has been registered", Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(RegisterUser.this, "Failed to register! Try again!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(RegisterUser.this, "Failed to register! Try again!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }

}