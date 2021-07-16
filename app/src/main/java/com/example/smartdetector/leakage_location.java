package com.example.smartdetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class leakage_location extends AppCompatActivity {

    private Button buttonic;
    private Button buttonmc;
    private Button buttonnmc;
    private Button buttonrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leakage_location);

        buttonic = (Button) findViewById(R.id.button_ic);
        buttonmc = (Button) findViewById(R.id.button_mc);
        buttonnmc = (Button) findViewById(R.id.button_nmc);
        buttonrc = (Button) findViewById(R.id.button_rc);

        buttonic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acttivity_ic();
            }
        });

        buttonmc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_mc();
            }
        });

        buttonnmc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_nmc();
            }
        });

        buttonrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_rc();
            }
        });
    }
    public void acttivity_ic()
    {
        Intent intent_ic = new Intent(this, indira_chowk.class);
        startActivity(intent_ic);
    }
    public void activity_mc()
    {
        Intent intent_mc = new Intent(this, madhapar_chowk.class);
        startActivity(intent_mc);
    }
    public void activity_nmc()
    {
        Intent intent_nmc = new Intent(this, nana_mauva_chowk.class);
        startActivity(intent_nmc);
    }
    public void activity_rc()
    {
        Intent intent_rc = new Intent(this, ramdevpir_chowk.class);
        startActivity(intent_rc);
    }
}
