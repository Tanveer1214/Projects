package com.sbbusba.mfs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.sbbusba.mfs.databinding.ActivityCustomOrderBinding;

import java.util.UUID;

public class CustomOrder extends AppCompatActivity {
    ActivityCustomOrderBinding binding;
    private String id,name,number,furnitureType,woodType,width,height,quantity;
    private String ID;
    private Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        binding.customOrderName.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());

        binding.customOrderPlaceOrder.setOnClickListener(v -> {
            name = binding.customOrderName.getText().toString();
            number = binding.customOrderNumber.getText().toString();
            furnitureType = binding.customOrderFType.getText().toString();
            woodType = binding.customOrderWType.getText().toString();
            width = binding.customOrderWidth.getText().toString();
            height = binding.customOrderHeight.getText().toString();
            quantity = binding.customOrderQuantity.getText().toString();
            addOrder();
            Toast.makeText(this, "Your Order has been placed", Toast.LENGTH_SHORT).show();
        });

        binding.customOrderImage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent,100);
        });

        binding.customOrderUploadImage.setOnClickListener(v -> {
            uploadImage();
        });
        ID = UUID.randomUUID().toString();
    }

    private void uploadImage() {
        StorageReference storageReference = FirebaseStorage.getInstance().getReference("CustomOrders/"+id+".png");
        storageReference.putFile(uri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        storageReference.getDownloadUrl()
                                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        FirebaseFirestore.getInstance()
                                                .collection("CustomOrders")
                                                .document(ID)
                                                .update("productImage",uri.toString());
                                        Toast.makeText(CustomOrder.this, "Done", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });
    }

    private void addOrder() {
        id = FirebaseAuth.getInstance().getUid();
        CustomOrderModel customOrderModel = new CustomOrderModel(ID,id,name,number,furnitureType,woodType,width,height,quantity,"0","Pending",null,true);
        FirebaseFirestore.getInstance()
                .collection("CustomOrders")
                .document(ID)
                .set(customOrderModel);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100) {
            uri = data.getData();
            binding.customOrderImage.setImageURI(uri);
        }
    }

}