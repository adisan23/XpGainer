package com.example.xpgainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class XpGainer extends AppCompatActivity {
    private Button taskbutton;
    private Button profilebutton;
    private Button activitybutton;
    private ListView actTasks;
    private Button register;
    //Text views
    private TextView level;
    private TextView xp;
    private TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xp_gainer);
        taskbutton = (Button) findViewById(R.id.taskbttn);

        taskbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTasks();

            }
        });

        profilebutton = (Button) findViewById(R.id.profilebttn);
        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();

            }
        });
        activitybutton = (Button) findViewById(R.id.activitybttn);
        activitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivites();

            }
        });
        actTasks = findViewById(R.id.actTasks);
        ArrayList aTasks = new ArrayList<>();
        aTasks.add("Run 3 miles");
        aTasks.add("Read a book");
        aTasks.add("Find a hobby");
        ArrayAdapter<String> atasksList = new ArrayAdapter<>(
                this,
                R.layout.list_tasks2,
                aTasks
        );

        actTasks.setAdapter(atasksList);


        //Display User, Level, XP

        username = (TextView) findViewById(R.id.Username1);
        level = (TextView) findViewById(R.id.level);
        xp = (TextView) findViewById(R.id.XpScore);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://xpgainer-4d2dd-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                User user = dataSnapshot.getValue(User.class);

                level.setText(Integer.toString(user.getLevel()));
                username.setText(user.getName());
                xp.setText(Integer.toString(user.getExperience()));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });


    }

    public void openTasks() {
        Intent intent = new Intent(this, Tasks.class);
        startActivity(intent);


    }
    public void openProfile() {
        Intent intent2 = new Intent(this, Profile.class);
        startActivity(intent2);


    }
    public void openActivites() {
        Intent activitiesintent = new Intent(this, Community.class);
        startActivity(activitiesintent);

    }

}
