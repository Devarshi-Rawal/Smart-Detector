package com.example.smartdetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class feedback extends AppCompatActivity {

    private EditText editTextFeedback;
    private Button button_feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        editTextFeedback = (EditText) findViewById(R.id.feedback);
        button_feedback = (Button) findViewById(R.id.button_send);

        editTextFeedback.addTextChangedListener(feedbackTextWatcher);
        button_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_home_screen();
                Toast.makeText(feedback.this, "Feedback sent successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private TextWatcher feedbackTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String feedbackInput = editTextFeedback.getText().toString().trim();

            button_feedback.setEnabled(!feedbackInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    public void activity_home_screen()
    {
        Intent intent_feedback = new Intent(this, home_screen.class);
        startActivity(intent_feedback);
    }
}
