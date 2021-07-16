package com.example.smartdetector;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.net.URL;
import java.util.Random;

public class log_in extends AppCompatActivity {

    Button btnLogin;
    //Button btnOTP, btnVerOtp;
    EditText editTextNumber, editTextPassword;
    TextView textViewSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        editTextNumber=(EditText)findViewById(R.id.regnumber);
        editTextPassword=(EditText)findViewById(R.id.password);

        editTextNumber.addTextChangedListener(loginTextWatcher);
        editTextPassword.addTextChangedListener(loginTextWatcher);

        //btnOTP=(Button)findViewById(R.id.button_otp);
        //StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        //StrictMode.setThreadPolicy(policy);
        //btnOTP.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
                /*try {
                    // Construct data
                    String apiKey = "apikey=" + "026xRLqDMmkENYiy8dOgv47foASleWwTzb5CuUIGBXPnh3tQVFJ7PhCtpAQ9HmKVDnUkbuET8LZ6is4F";
                    Random random = new Random();
                    randomNumber=random.nextInt(999999);
                    String message = "&message=" + "Dear user of " + editTextNumber.getText().toString()+ "your OTP is " + randomNumber;
                    String sender = "&sender=" + "OTP SENDER";
                    String numbers = "&numbers=" + editTextNumber.getText().toString();

                    // Send data
                    HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
                    String data = apiKey + numbers + message + sender;
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                    conn.getOutputStream().write(data.getBytes("UTF-8"));
                    final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    final StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = rd.readLine()) != null) {
                        stringBuffer.append(line);
                    }
                    rd.close();
                    Toast.makeText(getApplicationContext(), "OTP sent successfully", Toast.LENGTH_LONG).show();

                    //return stringBuffer.toString();
                } catch (Exception e) {
                    //System.out.println("Error SMS "+e);
                    //return "Error "+e;
                    Toast.makeText(getApplicationContext(),"Error SMS: "+e, Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(),"Error: "+e, Toast.LENGTH_LONG).show();
                }*/
            //}
        //});
        /*btnVerOtp=(Button)findViewById(R.id.button_verotp);
        btnVerOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (randomNumber==Integer.valueOf(editTextotp.getText().toString())){
                    Toast.makeText(getApplicationContext(),"OTP verified successfully", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"OTP is incorrect", Toast.LENGTH_LONG).show();
                }
            }
        });*/

        btnLogin=(Button)findViewById(R.id.button_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_activity();
            }
        });

        textViewSignIn = (TextView) findViewById(R.id.sign_in);
        textViewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign_in_activity();

                Toast.makeText(log_in.this, "Register now!", Toast.LENGTH_LONG).show();
            }
        });
    }
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String numberInput = editTextNumber.getText().toString().trim();
            String passwordInput = editTextPassword.getText().toString().trim();

            btnLogin.setEnabled(!numberInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    public void home_activity(){
        Intent intent_h = new Intent(log_in.this,home_screen.class);
        startActivity(intent_h);
    }
    public void sign_in_activity() {
        Intent intent1 = new Intent(log_in.this, sign_in.class);
        startActivity(intent1);
    }

}
