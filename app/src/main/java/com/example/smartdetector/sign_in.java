package com.example.smartdetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class sign_in extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextAddress;
    private EditText editTextNumber;
    private EditText editTextAnumber;
    private Button buttonCheck;
    private Button buttonSignIn;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editTextUsername = findViewById(R.id.username);
        editTextAddress = findViewById(R.id.address);
        editTextNumber = findViewById(R.id.number);
        editTextAnumber = findViewById(R.id.a_number);

        editTextUsername.addTextChangedListener(signInTextWatcher);
        editTextAddress.addTextChangedListener(signInTextWatcher);
        editTextNumber.addTextChangedListener(signInTextWatcher);
        editTextAnumber.addTextChangedListener(signInTextWatcher);

        buttonCheck = (Button) findViewById(R.id.button_validate);
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String AnumberInput = editTextAnumber.getText().toString();

                boolean result = Verhoeff.validateVerhoeff(AnumberInput);

                String message = String.valueOf(result);

                if (message == "true")
                {
                    Toast.makeText(getApplicationContext(),"Adhaar number is valid", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Adhaar number is invalid", Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonSignIn = (Button) findViewById(R.id.button_sign_in);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_activity();
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

    public void home_activity()
        {
            Intent intent = new Intent(this,home_screen.class);
            startActivity(intent);
        }
        private TextWatcher signInTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String usernameInput = editTextUsername.getText().toString().trim();
                String addressInput = editTextAddress.getText().toString().trim();
                String numberInput = editTextNumber.getText().toString().trim();
                String AnumberInput = editTextAnumber.getText().toString().trim();

                buttonSignIn.setEnabled(!usernameInput.isEmpty() && !addressInput.isEmpty() && !numberInput.isEmpty() && AnumberInput.length()==12);
                buttonCheck.setEnabled(AnumberInput.length() == 12);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
}
