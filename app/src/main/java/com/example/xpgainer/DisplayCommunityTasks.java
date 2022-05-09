package com.example.xpgainer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DisplayCommunityTasks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_community_tasks);

        ListView mListView = (ListView) findViewById(R.id.listcommunitytasks);

        ArrayList<String> list = new ArrayList<>();

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_tasks, list);
        mListView.setAdapter(adapter);



        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("CommunityTasks");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                for(DataSnapshot snapshot : datasnapshot.getChildren()){

                    String msg = snapshot.child("taskDescription").getValue(String.class);

                    list.add(msg);

                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}