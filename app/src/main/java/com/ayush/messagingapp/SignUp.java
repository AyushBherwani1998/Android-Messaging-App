package com.ayush.messagingapp;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.preference.PreferenceGroup;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignUp extends AppCompatActivity {
    private EditText mUserEmail;
    private EditText mUserName;
    private EditText mUserPassword;
    private EditText mUserConfirmPassword;
    private Button mSignUpButton;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mUserEmail = findViewById(R.id.editText_email);
        mUserName = findViewById(R.id.editText_userName);
        mUserPassword = findViewById(R.id.editText_password);
        mUserConfirmPassword =  findViewById(R.id.editText_confirmPassword);
        mSignUpButton = findViewById(R.id.button_singup);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
        firebaseAuth = FirebaseAuth.getInstance();

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAccount();
            }
        });

        mUserConfirmPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        mUserName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        mUserEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        mUserPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(SignUp.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void CreateAccount(){
        final String userEmail = mUserEmail.getText().toString().trim();
        final String userName = mUserName.getText().toString().trim();
        final String userPassword = mUserPassword.getText().toString().trim();
        final String confirmPassword = mUserConfirmPassword.getText().toString().trim();

        if(!TextUtils.isEmpty(userEmail)){
            if(!TextUtils.isEmpty(userName)){
                if(!TextUtils.isEmpty(userPassword)){
                    if(userPassword.equals(confirmPassword)){
                        progressDialog =  new ProgressDialog(SignUp.this);
                        progressDialog.setMessage("Creating a New Account");
                        progressDialog.show();

                        //Creating account using createUserWithEmailAndPassword
                        firebaseAuth.createUserWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    String userId = Objects.requireNonNull(firebaseAuth.getCurrentUser()).getUid();
                                    DatabaseReference databaseReference_currentUser = databaseReference.child(userId);
                                    databaseReference_currentUser.child("User Name").setValue(userName);
                                    databaseReference_currentUser.child("User Email-Id").setValue(userEmail);
                                    progressDialog.dismiss();
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.dismiss();
                                //To get the exact error
                                displayToast(e.toString());
                            }
                        });

                    }else{
                        displayToast("Password and Confirm password does not match");
                    }
                }else {
                    displayToast("Password field can not be Empty");
                }
            }else{
                displayToast("Name field can not be Empty");
            }
        }else{
            displayToast("Email field can not be Empty");
        }


    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
