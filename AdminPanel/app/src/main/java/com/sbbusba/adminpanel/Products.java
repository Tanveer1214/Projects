package com.sbbusba.adminpanel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.sbbusba.adminpanel.databinding.ActivityProductsBinding;

import java.util.List;

public class Products extends AppCompatActivity {
    ActivityProductsBinding binding;
    ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        productAdapter = new ProductAdapter(this);
        binding.cartRecycler.setAdapter(productAdapter);
        binding.cartRecycler.setLayoutManager(new GridLayoutManager(this,2));
        getProducts();

        binding.proceed.setOnClickListener(v -> {
            startActivity(new Intent(Products.this,MainActivity.class));
        });


    }

    private void getProducts() {
        FirebaseFirestore.getInstance()
                .collection("products")
                .whereEqualTo("show",true)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> dsList = queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot ds:dsList) {
                            ProductModel productModel = ds.toObject(ProductModel.class);
                            productAdapter.addProduct(productModel);
                        }
                    }
                });
    }

}