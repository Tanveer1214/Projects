package com.sbbusba.mfs;

import static com.sbbusba.mfs.Cart_Activity.cartItemList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.sbbusba.mfs.databinding.ActivityProductDetailBinding;

import java.util.ArrayList;
import java.util.UUID;

public class product_detail extends AppCompatActivity {

    ActivityProductDetailBinding binding;
    ProductModel productModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();

        productModel = (ProductModel) intent.getSerializableExtra("model");

        binding.title.setText(productModel.getTitle());
        binding.description.setText(productModel.getDescription());
        binding.price.setText(productModel.getPrice());
        binding.materialType.setText(productModel.getMaterial());
        binding.width.setText(productModel.getWidth());
        binding.height.setText(productModel.getHeight());
        binding.stock.setText(productModel.getStock());

        Glide.with(binding.getRoot())
                .load(productModel.getImage())
                .into(binding.detailImage);

        getSupportActionBar().setTitle(productModel.getTitle());
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.orange)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.addtoCart.setOnClickListener(v -> {
            BottomSheet(0);
        });

        binding.buyNow.setOnClickListener(v -> {
            BottomSheet(1);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.cart) {
            startActivity(new Intent(this,Cart_Activity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void BottomSheet(int i) {

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View view = LayoutInflater.from(product_detail.this).inflate(R.layout.bottom_layout,(LinearLayout)findViewById(R.id.mainLayout),false);
        bottomSheetDialog.setContentView(view);
        EditText qty = view.findViewById(R.id.qty);
        TextView st = view.findViewById(R.id.bottomStock);
        Button btn = view.findViewById(R.id.confirm);
        st.setText(productModel.getStock());
        bottomSheetDialog.show();

        btn.setOnClickListener(v -> {
            String quantity = qty.getText().toString();
            if(quantity.equals(""))
                Toast.makeText(this,"Please Enter Quantity",Toast.LENGTH_SHORT).show();
            else {
                int stock = Integer.parseInt(quantity);
                int stock2 = Integer.parseInt(productModel.getStock().substring(17));
                int stock3 = stock2 - stock;
                if(i == 0) {
                    if(stock > stock2) {
                        Toast.makeText(this, "Insufficient Stock", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.cancel();
                    }
                    else {
                        addToCart(quantity);
                        FirebaseFirestore.getInstance()
                                .collection("products")
                                .document(productModel.getId())
                                .update("stock",String.valueOf(stock3));
                        st.setText(productModel.getStock());
                        bottomSheetDialog.cancel();
                    }
                }
                else if(i == 1) {
                    if(stock > stock2) {
                        Toast.makeText(this, "Insufficient Stock", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.cancel();
                    }
                    else {
                        CartModel cartModel = new CartModel(null,productModel.getTitle(),productModel.getImage()
                                ,productModel.getPrice(),quantity,FirebaseAuth.getInstance().getUid(), null);
                        cartItemList = new ArrayList<>();
                        cartItemList.add(cartModel);
                        startActivity(new Intent(this,Order_Activity.class));
                        bottomSheetDialog.cancel();
                    }
                }
            }
        });

    }

    private void addToCart(String qty) {
        String id = UUID.randomUUID().toString();
        CartModel cartModel = new CartModel(id,productModel.getTitle(),productModel.getImage(),productModel.getPrice(),qty, FirebaseAuth.getInstance().getUid(),null);
        FirebaseFirestore.getInstance()
                .collection("cart")
                .document(id)
                .set(cartModel);
        Toast.makeText(this, "Product Added to Cart", Toast.LENGTH_SHORT).show();
    }

}