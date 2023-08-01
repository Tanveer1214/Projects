package com.sbbusba.mfs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.sbbusba.mfs.databinding.ActivityUserProfileBinding;

import java.util.List;
import java.util.Objects;

public class UserProfile extends AppCompatActivity {

    ActivityUserProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        binding.name.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
        binding.email.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());

        binding.pendingOrderBtn.setOnClickListener(v -> {
            Intent intent = new Intent(UserProfile.this,PendingOrdersList.class);
            intent.putExtra("status","Pending");
            startActivity(intent);
        });

        binding.deliveredOrderBtn.setOnClickListener(v -> {
            Intent intent = new Intent(UserProfile.this,PendingOrdersList.class);
            intent.putExtra("status","Delivered");
            startActivity(intent);
        });

        binding.canceledOrderBtn.setOnClickListener(v -> {
            Intent intent = new Intent(UserProfile.this,PendingOrdersList.class);
            intent.putExtra("status","Cancelled");
            startActivity(intent);
        });

        binding.logOut.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this,MainActivity.class));
            finish();
        });

    }

}