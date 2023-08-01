package com.sbbusba.mfs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.sbbusba.mfs.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();


        binding.goForSignup.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,SignUp.class));
            finish();
        });

        binding.forgotPass.setOnClickListener(v -> {
            binding.loginErroMsg.setText("Forgot password is in under development");
        });

        binding.login.setOnClickListener(v -> {
            String email = binding.email.getText().toString();
            String password = binding.passwordLogin.getText().toString();
            if(email.equals("") || password.equals("")) {
                binding.loginErroMsg.setText("Please fill required fields");
            }
            else {
                login(email,password);
            }
        });
    }

    private void login(String email, String password) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("in process");
        progressDialog.show();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email.trim(),password.trim())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        progressDialog.cancel();
                        Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,MainScreen.class));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        binding.loginErroMsg.setText(e.getMessage());
                        progressDialog.cancel();
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(MainActivity.this,MainScreen.class));
            finish();
        }

    }
}