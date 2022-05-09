package com.example.xpgainer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CommunityTasks extends AppCompatActivity {

    private Button displayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_tasks);

        displayList = (Button) findViewById(R.id.displayctasks);

        displayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openList();

            }
        });


    }

    public void openList() {
        Intent intent = new Intent(this, DisplayCommunityTasks.class);
        startActivity(intent);
    }


    public void buttonClicked(View view){



        EditText editText = (EditText) findViewById(R.id.taskmessage);

        String message = editText.getText().toString();

        if(!message.isEmpty()){
            CTask task = new CTask(message);

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference().child("CommunityTasks");

            myRef.push().setValue(task);
            //myRef.child(task.getId().toString()).setValue(task);
            Toast.makeText(CommunityTasks.this, "Task submitted successfully",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(CommunityTasks.this, "Task name can't be empty",Toast.LENGTH_LONG).show();
        }







    }
}