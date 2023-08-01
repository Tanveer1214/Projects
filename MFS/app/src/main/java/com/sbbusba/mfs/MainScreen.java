package com.sbbusba.mfs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.mancj.materialsearchbar.MaterialSearchBar;
import com.sbbusba.mfs.databinding.ActivityMainScreenBinding;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.List;

public class MainScreen extends AppCompatActivity {

    ActivityMainScreenBinding binding;
    ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        int []image = {
                R.drawable.profile,
                R.drawable.tools,
                R.drawable.carts,
                R.drawable.arrow_right
        };
        String []name = {"My Account","Custom Order","Cart","Categories"};
        binding.categoryGrid.setAdapter(new CategoryAdapter(name,image,this));
        binding.categoryGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0) {
                    startActivity(new Intent(MainScreen.this,UserProfile.class));
                }
                if(i == 1) {
                    startActivity(new Intent(MainScreen.this,CustomOrder.class));
                }
                if(i == 2) {
                    startActivity(new Intent(MainScreen.this,Cart_Activity.class));
                }
                if(i == 3) {
                    startActivity(new Intent(MainScreen.this,CategoriesSection.class));
                }
            }
        });


        productAdapter = new ProductAdapter(this);
        binding.productRecycler.setAdapter(productAdapter);
        binding.productRecycler.setLayoutManager(new GridLayoutManager(this,2));
        getProducts();
        slider();
        binding.searchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {

            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                Intent intent = new Intent(MainScreen.this,SearchActivity.class);
                intent.putExtra("query",text.toString());
                startActivity(intent);
            }

            @Override
            public void onButtonClicked(int buttonCode) {

            }
        });
    }

    private void slider() {
        binding.carousel.addData(new CarouselItem("https://firebasestorage.googleapis.com/v0/b/furniture-app-b5286.appspot.com/o/Green%20Minimalist%20Furniture%20Banner.png?alt=media&token=b4a27a26-b60b-4595-863d-08f8dbd4675a"));
        binding.carousel.addData(new CarouselItem("https://firebasestorage.googleapis.com/v0/b/furniture-app-b5286.appspot.com/o/home%20furniture.png?alt=media&token=636675c3-d3fe-4b8e-89d3-165419277ccd"));
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