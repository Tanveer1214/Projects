package com.sbbusba.mfs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.sbbusba.mfs.databinding.ActivitySearchBinding;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    ActivitySearchBinding binding;
    ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String query = getIntent().getStringExtra("query");
        getSupportActionBar().setTitle(query);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        query = query.toLowerCase().trim();

        productAdapter = new ProductAdapter(this);
        binding.searchRecycler.setAdapter(productAdapter);
        binding.searchRecycler.setLayoutManager(new GridLayoutManager(this,2));

        searchProduct(query);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void searchProduct(String query) {
        FirebaseFirestore.getInstance()
                .collection("products")
                .whereEqualTo("category",query)
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