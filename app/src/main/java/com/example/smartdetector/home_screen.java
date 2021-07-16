package com.example.smartdetector;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class home_screen extends AppCompatActivity {

    private Button button_notifications;
    private Button buttonp;
    private Button buttonf;
    private Button buttonl;
    private Button buttonld;
    private Button buttonh;
    private Button buttonru;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        /*findViewById(R.id.button_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(home_screen.this, log_in.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);
            }
        });*/

        button_notifications = (Button) findViewById(R.id.button_n);
        button_notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_notifications();
            }
        });

        buttonp = (Button) findViewById(R.id.button_pm);
        buttonp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_pipe_map();
            }
        });

        buttonf = (Button) findViewById(R.id.button_f);
        buttonf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_feedback();
            }
        });

        buttonl = (Button) findViewById(R.id.button_ll);
        buttonl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_leakage_location();
            }
        });

        buttonld = (Button) findViewById(R.id.button_ld);
        buttonld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_contact_details();
            }
        });

        buttonh = (Button) findViewById(R.id.button_h);
        buttonh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_help_rmc();
            }
        });

        buttonru = (Button) findViewById(R.id.button_rate_us);
        buttonru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_rate_us();
            }
        });


    }
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2500 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            onDestroy();
        }
        else {
            backToast = Toast.makeText(getApplicationContext(), "Press back again to exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
    public void activity_notifications()
    {
        Intent intent_n = new Intent(this,notifications.class);
        startActivity(intent_n);
    }
    public void activity_pipe_map()
    {
        Intent intent_p = new Intent(this, pipe_map.class);
        startActivity(intent_p);
    }
    public void activity_feedback()
    {
        Intent intent_f = new Intent(this,feedback.class);
        startActivity(intent_f);
    }
    public void activity_leakage_location()
    {
        Intent intent_l = new Intent(this, leakage_location.class);
        startActivity(intent_l);
    }
    public void activity_contact_details()
    {
        Intent intent_ld = new Intent(this, contact_details.class);
        startActivity(intent_ld);
    }
    public void activity_help_rmc()
    {
        Intent intent_h = new Intent(this, help_rmc.class);
        startActivity(intent_h);
    }
    public void activity_rate_us()
    {
        Intent intent_ru = new Intent(this,rate_us.class);
        startActivity(intent_ru);
    }
}
