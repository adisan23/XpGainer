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
import java.util.List;

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

        UserLeaderboard user = new UserLeaderboard(username,xp,level);

        LayoutInflater inflater = LayoutInflater.from(mContext);

        convertView = inflater.inflate(mResource, parent, false);

        TextView tvUsername = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvxp = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvLevel = (TextView) convertView.findViewById(R.id.textView3);

        tvUsername.setText(username);
        tvxp.setText(String.valueOf(xp));
        tvLevel.setText(String.valueOf(level));

        return convertView;


    }
}
