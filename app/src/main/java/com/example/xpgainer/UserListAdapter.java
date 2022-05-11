package com.example.xpgainer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UserListAdapter extends ArrayAdapter<UserLeaderboard> {

    private Context mContext;
    int mResource;

    public UserListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<UserLeaderboard> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String username = getItem(position).getUsername();
        int xp = getItem(position).getXp();
        int level = getItem(position).getLevel();

        String txtUser = username;
        String txtXp = "XP: " + xp;
        String txtLevel = "Level: " + level;

        UserLeaderboard user = new UserLeaderboard(username,xp,level);

        LayoutInflater inflater = LayoutInflater.from(mContext);

        convertView = inflater.inflate(mResource, parent, false);

        TextView tvUsername = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvLevel = (TextView) convertView.findViewById(R.id.level);
        TextView tvxp = (TextView) convertView.findViewById(R.id.textView3);


        tvUsername.setText(txtUser);
        tvLevel.setText(txtLevel);
        tvxp.setText(txtXp);


        return convertView;


    }
}
