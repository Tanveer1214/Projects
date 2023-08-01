package com.sbbusba.mfs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.sbbusba.mfs.databinding.ActivitySignUpBinding;

public class SignUp extends AppCompatActivity {

    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.goLogin.setOnClickListener(v -> {
            startActivity(new Intent(SignUp.this,MainActivity.class));
            finish();
        });

        binding.signupbtn.setOnClickListener(v -> {
            String username = binding.signupUsername.getText().toString();
            String email = binding.signupEmail.getText().toString();
            String password = binding.signupPassword.getText().toString();
            String mobile = binding.signupPhone.getText().toString();
            if(username.equals("") || email.equals("") || password.equals("") || mobile.equals("")) {
                binding.erroMsg.setText("Please fill all fields");
            }
            else {
                createAccount(username,email,password,mobile);
            }
        });

    }

    private void createAccount(String username, String email, String password, String mobile) {

        FirebaseAuth fAuth = FirebaseAuth.getInstance();
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Creating");
        progressDialog.setMessage("Account");
        progressDialog.show();
        fAuth.createUserWithEmailAndPassword(email.trim(),password.trim()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder()
                        .setDisplayName(username).build();
                FirebaseAuth.getInstance().getCurrentUser().updateProfile(profileChangeRequest);
                progressDialog.cancel();
                Toast.makeText(SignUp.this,"Account created",Toast.LENGTH_SHORT).show();
                binding.signupUsername.setText("");
                binding.signupEmail.setText("");
                binding.signupPassword.setText("");
                binding.signupPhone.setText("");
                startActivity(new Intent(SignUp.this,MainActivity.class));
                finish();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        binding.erroMsg.setText(e.getMessage());
                        progressDialog.cancel();
                    }
                });
    }
}