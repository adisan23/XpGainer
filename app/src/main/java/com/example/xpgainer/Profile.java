package com.example.xpgainer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Profile extends AppCompatActivity {

    private ImageView profileImage;

    private TextView txtLevel, txtUsername, txtTasks;

    private ProgressBar progressBar;

    private ListView tasksCompleted;

    private static final String TAG = "Profile";

    private DatabaseReference mDatabase;

    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tasksCompleted = findViewById(R.id.tasksCompleted);

        txtLevel = findViewById(R.id.txtLevel);

        txtUsername = findViewById(R.id.txtUsername);

        progressBar = findViewById(R.id.progressBar);

        ArrayList Tasks = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://xpgainer-4d2dd-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                User user = dataSnapshot.getValue(User.class);
                Log.d(TAG, "Value is: " + user.toString());

                txtLevel.setText("Level " + user.getLevel());
                txtUsername.setText(user.getName());
                progressBar.setProgress(user.getExperience());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        Tasks.add("Run 3 miles");
        Tasks.add("");


        ArrayAdapter<String> tasksList = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Tasks
        );

        tasksCompleted.setAdapter(tasksList);

    }
}