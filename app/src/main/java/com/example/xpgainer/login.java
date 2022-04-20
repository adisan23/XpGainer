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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    private EditText edtTxtPassword, edtTxtEmail;
    private TextView banner;
    private Button loginBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtTxtPassword = findViewById(R.id.edtTxtPassword1);
        edtTxtEmail = findViewById(R.id.edtTxtEmail1);

        banner = findViewById(R.id.banner);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = edtTxtEmail.getText().toString();
                final String passwordTxt = edtTxtPassword.getText().toString();

                if (email.isEmpty() || passwordTxt.isEmpty()) {
                    Toast.makeText(login.this, "Please enter your email and password", Toast.LENGTH_SHORT).show();
                } else {

                    db.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(email)) {

                                final String getPassword = snapshot.child("tQ1nz4YdOdO2kXhiMpnJJrPRMz42").child("password").getValue(String.class);

                                if (getPassword.equals(passwordTxt)) {
                                    Toast.makeText(login.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(login.this, XpGainer.class));
                                    finish();
                                } else {
                                    Toast.makeText(login.this, "Wrong password", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(login.this, "Wrong email", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }


            }


        });

        /*mAuth.signInWithEmailAndPassword(edtTxtEmail.getText().toString(), edtTxtPassword.getText().toString()).
                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseDatabase.getInstance("https://xpgainer-4d2dd-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue("").addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                }
                            });

                        }else{
                            Toast.makeText(login.this, "Failed to login", Toast.LENGTH_SHORT).show();
                        }
                }

        });*/
    }
}