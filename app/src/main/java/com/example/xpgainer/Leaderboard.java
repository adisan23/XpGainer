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

public class Leaderboard extends AppCompatActivity {

    public void sort(ArrayList<UserLeaderboard> array){

        int ok;
        UserLeaderboard aux;

        do {

            ok = 0;

            for(int i = 0; i < array.size()-1; i++){

                UserLeaderboard user1 = array.get(i);
                UserLeaderboard user2 = array.get(i+1);

                if(user1.getXp() < user2.getXp()){
                    aux = user1;
                    array.set(i+1,user1);
                    array.set(i,user2);
                    ok = 1;
                }


            }


        }while(ok==1);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        ListView mListView = (ListView) findViewById(R.id.leaderlist);

        ArrayList<UserLeaderboard> usersList = new ArrayList<>();

        UserListAdapter adapter = new UserListAdapter(this, R.layout.adapter_view_layout, usersList);
        mListView.setAdapter(adapter);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                    String username = snapshot.child("name").getValue(String.class);
                    Integer xp = snapshot.child("experience").getValue(Integer.class);
                    Integer level = snapshot.child("level").getValue(Integer.class);

                    System.out.println(username+ " " + xp + " " + level);

                    UserLeaderboard user = new UserLeaderboard(username,xp,level);

                    usersList.add(user);

                    sort(usersList);

                    System.out.println("user:" +user.getUsername() + " " + user.getXp() + " " + user.getLevel());
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Hardcoded values for test and understanding purposes
        /*
        UserLeaderboard user1 = new UserLeaderboard("john",10,2);
        UserLeaderboard user2 = new UserLeaderboard("jimmy",20,2);
        UserLeaderboard user3 = new UserLeaderboard("ron",60,6);

        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
        */







    }
}