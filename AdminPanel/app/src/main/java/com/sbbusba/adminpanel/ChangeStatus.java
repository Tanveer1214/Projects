package com.sbbusba.adminpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.sbbusba.adminpanel.databinding.ActivityChangeStatusBinding;
import com.sbbusba.adminpanel.email.EmailDTO;
import com.sbbusba.adminpanel.email.SendMailAsyncTask;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ChangeStatus extends AppCompatActivity {
    ActivityChangeStatusBinding binding;
    OrderModel orderModel;
    String[] list = {"Confirmed","Delivered","Cancelled"};
    ArrayAdapter<String> Items;
    private String status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangeStatusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        Intent intent = getIntent();
        orderModel = (OrderModel) intent.getSerializableExtra("model");

        binding.username.setText(orderModel.getCustomer_name());
        Items = new ArrayAdapter<String>(this,R.layout.list_items,list);
        binding.autoStatus1.setAdapter(Items);

        binding.autoStatus1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                status = adapterView.getItemAtPosition(i).toString();
            }
        });

        binding.confirm.setOnClickListener(v -> {
            String status = binding.autoStatus1.getText().toString();
            String comments = binding.comments.getText().toString();
            StatusModel statusModel = new StatusModel(orderModel.getUid(),orderModel.getOrderNumber(),orderModel.getCustomer_name(),comments,status,new Date());

            Map<String,Object> updateFields = new HashMap<>();
            updateFields.put("order_status",status);
            updateFields.put("updatedOn",new Date());
            FirebaseFirestore.getInstance()
                    .collection("orders")
                    .document(orderModel.getOrderNumber())
                    .update(updateFields);

            FirebaseFirestore.getInstance()
                    .collection("orderStatus")
                    .document(orderModel.getOrderNumber())
                    .set(statusModel);
            EmailDTO emailDTO = new EmailDTO();
            emailDTO.setOrderNumber(orderModel.getOrderNumber());
            emailDTO.setFullName("Store Team");
            emailDTO.setOrderStatus(status);
            emailDTO.setOrderComment(comments);
            emailDTO.setTo(orderModel.getCustomerEmail());
            new SendMailAsyncTask().execute(emailDTO);
            Toast.makeText(this, "Order status changed", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,DashBoard.class));
            finish();
        });

    }

}