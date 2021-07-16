package com.example.smartdetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class help_rmc extends AppCompatActivity {

    private EditText editTextLocation;
    private EditText editTextDoo;
    private Button buttonrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_rmc);

        editTextLocation = (EditText) findViewById(R.id.location);
        editTextDoo = (EditText) findViewById(R.id.doo);
        buttonrc = (Button) findViewById(R.id.button_rc);

        editTextLocation.addTextChangedListener(registerComplainTextWatcher);
        editTextDoo.addTextChangedListener(registerComplainTextWatcher);

        buttonrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_upload_pic();
            }
        });
    }
    private TextWatcher registerComplainTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String locationInput = editTextLocation.getText().toString().trim();
            String dooInput = editTextDoo.getText().toString().trim();

            buttonrc.setEnabled(!locationInput.isEmpty() && !dooInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    public void activity_upload_pic()
    {
        Intent intent_rc = new Intent(this,upload_pic.class);
        startActivity(intent_rc);
    }
}
