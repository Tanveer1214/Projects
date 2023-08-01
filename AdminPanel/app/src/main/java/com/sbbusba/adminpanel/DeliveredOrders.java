package com.sbbusba.adminpanel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.sbbusba.adminpanel.databinding.ActivityDeliveredOrdersBinding;

import java.util.Arrays;
import java.util.List;

public class DeliveredOrders extends AppCompatActivity {

    ActivityDeliveredOrdersBinding binding;
    OrdersAdapter ordersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeliveredOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        ordersAdapter = new OrdersAdapter(this);
        binding.deliveredOrderRecycler.setAdapter(ordersAdapter);
        binding.deliveredOrderRecycler.setLayoutManager(new LinearLayoutManager(this));
        getOrders();

    }

    private void getOrders() {
        FirebaseFirestore.getInstance()
                .collection("orders")
                .whereIn("order_status", Arrays.asList("Delivered","Cancelled"))
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