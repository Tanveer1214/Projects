package com.sbbusba.mfs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.sbbusba.mfs.databinding.ActivityCategoriesSectionBinding;

import java.util.List;

public class CategoriesSection extends AppCompatActivity {

    ActivityCategoriesSectionBinding binding;
    ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesSectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Categories");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.orange)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int []images = {
                R.drawable.chair,
                R.drawable.sofa,
                R.drawable.table,
                R.drawable.bed_icon,
                R.drawable.drawers,
                R.drawable.wardrobe,
                R.drawable.dressing_table,
                R.drawable.swing,
                R.drawable.stool
        };
        String []names = {"Chair","Sofa","Table","Bed","Drawer","Wardrobe","Dressing Table","Swing","Stool"};
        binding.categorySectionGrid.setAdapter(new CategoryAdapter(names,images,this));
        getCategories();
        productAdapter = new ProductAdapter(this);
        binding.categorySectionRecycler.setAdapter(productAdapter);
        binding.categorySectionRecycler.setLayoutManager(new GridLayoutManager(this,2));
        getProducts();
    }

    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    public void getCategories() {
        binding.categorySectionGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String []category = {"chair","sofa","table","bed","drawer","wardrobe","dressing table","swing","stool"};
                Intent intent = new Intent(CategoriesSection.this,CategoryActivity.class);
                intent.putExtra("cat",category[i]);
                startActivity(intent);
            }
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
