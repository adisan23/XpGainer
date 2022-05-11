package com.example.xpgainer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tasks extends AppCompatActivity {

    private ListView listAvailable;
    private Switch activeSwitch;
    private int positionEliminate;
    private int xp;
    public int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        listAvailable = findViewById(R.id.listAvailable);

        ArrayList<String> tasks = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://xpgainer-4d2dd-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("experience");
        DatabaseReference myRef1 = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("level");

        tasks.add("Run 3 miles");
        tasks.add("Read a book");
        tasks.add("Find a hobby");
        tasks.add("Run 3 miles");
        tasks.add("Read a book");
        tasks.add("Find a hobby");
        tasks.add("Run 3 miles");
        tasks.add("Read a book");
        tasks.add("Find a hobby");
        tasks.add("Run 3 miles");
        tasks.add("Read a book");
        tasks.add("Find a hobby");
        tasks.add("Run 3 miles");
        tasks.add("Read a book");
        tasks.add("Find a hobby");
        tasks.add("Run 3 miles");
        tasks.add("Read a book");
        tasks.add("Find a hobby");

        ArrayList<String> tasks_completed = new ArrayList<>();

        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(this, R.layout.task_check , tasks);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                xp = dataSnapshot.getValue(int.class);

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        listAvailable.setAdapter(arrayAdapter);

        listAvailable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listAvailable.setItemChecked(position, true);
                if(listAvailable.isItemChecked(position)){
                    xp += 10;
                    myRef.setValue(xp);

                    myRef1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // This method is called once with the initial value and again
                            // whenever data at this location is updated.
                            level = dataSnapshot.getValue(int.class);
                            if(xp == 100){
                                level += 1;
                                myRef1.setValue(level);
                                xp = 0;
                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError error) {

                        }
                    });
                    positionEliminate = position;
                    tasks.remove(position);
                    listAvailable.setAdapter(arrayAdapter);
                }
            }
        });


    }


}

