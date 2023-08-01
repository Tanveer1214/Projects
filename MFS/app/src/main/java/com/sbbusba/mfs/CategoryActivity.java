package com.sbbusba.mfs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.sbbusba.mfs.databinding.ActivityCategoryBinding;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    ActivityCategoryBinding binding;
    ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String cat = getIntent().getStringExtra("cat");
        getSupportActionBar().setTitle(cat);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productAdapter = new ProductAdapter(this);
        binding.categoryRecycler.setAdapter(productAdapter);
        binding.categoryRecycler.setLayoutManager(new GridLayoutManager(this,2));

        DisplayCategoryProducts(cat);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void DisplayCategoryProducts(String cat) {
        FirebaseFirestore.getInstance()
                .collection("products")
                .whereEqualTo("category",cat)
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