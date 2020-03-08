package com.example.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginException;

public class PhoneActivity extends AppCompatActivity {
    private EditText editPhone;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        editPhone = findViewById(R.id.editPhone);
        callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                Log.e("TAG", "onVerificationFailed");
                signIn(phoneAuthCredential);

            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
            }

            @Override
            public void onCodeAutoRetrievalTimeOut(String s) {
                super.onCodeAutoRetrievalTimeOut(s);
            }

            private void signIn(PhoneAuthCredential phoneAuthCredential) {
                FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           Toast.makeText(PhoneActivity.this,"Успешно ", Toast.LENGTH_SHORT ).show();
                       }else {
                           Toast.makeText(PhoneActivity.this, "Ошибка", Toast.LENGTH_SHORT).show();
                       }
                    }
                });
            }

            @Override
            public void onVerificationFailed( @NonNull FirebaseException e) {
                Log.e("TAG", "onVerificationFailed" + e.getMessage());

            }
        };

    }

    public void onClick(View view) {
        String phone = editPhone.getText().toString().trim();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone, 60,
                TimeUnit.SECONDS,
                this, callbacks);

    }


}

