package com.sbbusba.mfs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.sbbusba.mfs.databinding.ActivityCartBinding;

import java.util.List;

public class Cart_Activity extends AppCompatActivity {

    ActivityCartBinding binding;
    private CartAdapter cartAdapter;
    public static List<CartModel> cartItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        cartAdapter = new CartAdapter(this);
        binding.cartRecycler.setAdapter(cartAdapter);
        binding.cartRecycler.setLayoutManager(new LinearLayoutManager(this));
        getCartItems();
      //  getCustomOrders();
        binding.proceed.setOnClickListener(v -> {
            cartItemList = cartAdapter.getSelectedItem();
            if(cartItemList.size() == 0) {
                Toast.makeText(this,"Please select item",Toast.LENGTH_SHORT).show();
            }
            else {
                startActivity(new Intent(this,Order_Activity.class));
            }

        });
    }

    private void getCartItems() {

        FirebaseFirestore.getInstance()
                .collection("cart")
                .whereEqualTo("sellerUid", FirebaseAuth.getInstance().getUid())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> dsList = queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot ds:dsList) {
                            CartModel cartModel = ds.toObject(CartModel.class);
                            cartAdapter.addProduct(cartModel);
                        }
                    }
                });

    }

    private void getCustomOrders() {

        FirebaseFirestore.getInstance()
                .collection("CustomOrders")
                .whereEqualTo("sellerUID", FirebaseAuth.getInstance().getUid())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> dsList = queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot ds:dsList) {
                            CartModel cartModel = ds.toObject(CartModel.class);
                            cartAdapter.addProduct(cartModel);
                        }
                    }
                });

    }

}