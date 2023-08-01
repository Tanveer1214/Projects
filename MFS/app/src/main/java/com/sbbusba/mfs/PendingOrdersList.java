package com.sbbusba.mfs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.sbbusba.mfs.databinding.ActivityPendingOrdersListBinding;

import java.util.Arrays;
import java.util.List;

public class PendingOrdersList extends AppCompatActivity {
    ActivityPendingOrdersListBinding binding;
    OrdersAdapter ordersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPendingOrdersListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String status = getIntent().getStringExtra("status");
        getSupportActionBar().setTitle(status);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ordersAdapter = new OrdersAdapter(this);
        binding.pendingOrderListRecycler.setAdapter(ordersAdapter);
        binding.pendingOrderListRecycler.setLayoutManager(new LinearLayoutManager(this));
        getOrders(status);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void getOrders(String status) {
        FirebaseFirestore.getInstance()
                .collection("orders")
                .whereEqualTo("order_status", status)
                .whereEqualTo("uid", FirebaseAuth.getInstance().getUid())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> dsList = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot ds : dsList) {
                            OrderModel orderModel = ds.toObject(OrderModel.class);
                            ordersAdapter.addProduct(orderModel);
                        }
                    }
                });
    }

}