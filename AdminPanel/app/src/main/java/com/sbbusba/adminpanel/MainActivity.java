package com.sbbusba.adminpanel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.sbbusba.adminpanel.databinding.ActivityMainBinding;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private String id,title,description,material,width,height,category,price,stock;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.upload.setOnClickListener(v -> {
            title = binding.productName.getText().toString();
            description = binding.productDiscription.getText().toString();
            material = binding.productMaterial.getText().toString();
            width = binding.productWidth.getText().toString();
            height = binding.productHeight.getText().toString();
            price = binding.productPrice.getText().toString();
            stock = binding.productStock.getText().toString();
            category = binding.productCategory.getText().toString();
            addProduct();
            Toast.makeText(this, "Product Added", Toast.LENGTH_SHORT).show();
        });

        binding.productImage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent,100);
        });

        binding.uploadImagebtn.setOnClickListener(v -> {
            uploadImage();
        });
        binding.textView.setOnClickListener(v -> {
            startActivity(new Intent(this,DashBoard.class));
        });

    }


    private void uploadImage() {
        StorageReference storageReference = FirebaseStorage.getInstance().getReference("Products/"+id+".png");
        storageReference.putFile(uri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        storageReference.getDownloadUrl()
                                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        FirebaseFirestore.getInstance()
                                                .collection("products")
                                                .document(id)
                                                .update("image",uri.toString());
                                        Toast.makeText(MainActivity.this, "Image Successfully Uploaded", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });
    }

    private void addProduct() {
        id = UUID.randomUUID().toString();
        ProductModel productModel = new ProductModel(id,title,description,material,width,height,category,price,stock,null,true);
        FirebaseFirestore.getInstance()
                .collection("products")
                .document(id)
                .set(productModel);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100) {
            uri = data.getData();
            binding.productImage.setImageURI(uri);
        }
    }
}