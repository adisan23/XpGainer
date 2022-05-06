package com.example.xpgainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LaunchPage extends AppCompatActivity {
    private Button regibutton;
    private Button logibutton;
    private TextView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_page);
        regibutton = (Button) findViewById(R.id.bttnreg);

        regibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();

            }
        });

        logibutton = findViewById(R.id.bttnlogin);
        logibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openLogin();
            }
        });

        banner = findViewById(R.id.banner);
        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAppTestSkip();
            }
        });

    }

    public void openRegister() {
        Intent intent = new Intent(this, RegisterUser.class);
        startActivity(intent);


    }
    public void openLogin() {
        Intent intent2 = new Intent(this, login.class);
        startActivity(intent2);
    }

    public void openAppTestSkip() {
        Intent intent3 = new Intent(this, XpGainer.class);
        startActivity(intent3);
    }
}