package com.ayush.messagingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login_Screen extends AppCompatActivity {
    TextView mSignupTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__screen);
        mSignupTextView = findViewById(R.id.textView_signUp);

        mSignupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Screen.this,SignUp.class));
            }
        });
    }
}
