package com.sbbusba.mfs;

import static android.widget.Toast.*;
import static com.sbbusba.mfs.Cart_Activity.cartItemList;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.se.omapi.Session;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.sbbusba.mfs.databinding.ActivityMainScreenBinding;
import com.sbbusba.mfs.databinding.ActivityOrderBinding;
import com.sbbusba.mfs.email.EmailDTO;
import com.sbbusba.mfs.email.SendMailAsyncTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;




public class Order_Activity extends AppCompatActivity {

    ActivityOrderBinding binding;
    int mainTotal = 0;
    String name,number,city,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        binding.cusName.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());

        binding.placeOrderBtn.setOnClickListener(v -> {
            name = binding.cusName.getText().toString();
            number = binding.cusNumber.getText().toString();
            city = binding.cusCity.getText().toString();
            address = binding.cusAddress.getText().toString();
            if(name.equals("") || number.equals("") || city.equals("") || address.equals("")) {
                makeText(this, "Please fill required fields", LENGTH_SHORT).show();
            }
            else {
                PlaceOrder();
                Toast.makeText(this,"Your order has been placed",LENGTH_LONG).show();
            }
        });

    }

    private void PlaceOrder() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        String date  = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        progressDialog.setTitle("Placing");
        progressDialog.setMessage("your order");
        progressDialog.show();
        String orderNumber = String.valueOf(getRandomNumber(100000,999999));
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        OrderModel orderModel = new OrderModel(orderNumber,
                name,number,FirebaseAuth.getInstance().getCurrentUser().getEmail(),city,address,String.valueOf(mainTotal),"5000",null,"Mazda",
                date, "Pending",FirebaseAuth.getInstance().getUid(),new Date(),new Date());

        FirebaseFirestore.getInstance()
                .collection("orders")
                .document(orderNumber)
                .set(orderModel)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        for(int i=0;i<cartItemList.size();i++) {
                            CartModel cartModel = cartItemList.get(i);
                            cartModel.setOrderNumber(orderNumber);
                            String id = UUID.randomUUID().toString();
                            cartModel.setCartid(id);
                            FirebaseFirestore.getInstance()
                                    .collection("orderProducts")
                                    .document(id)
                                    .set(cartModel);
                        }
                        binding.cusName.setText("");
                        binding.cusNumber.setText("");
                        binding.cusCity.setText("");
                        binding.cusAddress.setText("");
                        EmailDTO emailDTO = new EmailDTO();
                        emailDTO.setOrderNumber(orderNumber);

                        emailDTO.setTo(user.getEmail());
                        emailDTO.setFullName(user.getDisplayName());
                        emailDTO.setOrderStatus("Pending");
                        new SendMailAsyncTask().execute(emailDTO);
                        progressDialog.cancel();
                        startActivity(new Intent(Order_Activity.this,MainScreen.class));
                    }
                });
    }

    public static int getRandomNumber(int min, int max) {
        return (new Random()).nextInt((max - min) + 1) + min;
    }

    @Override
    protected void onStart() {
        super.onStart();
        for(int i=0;i<cartItemList.size();i++) {
            CartModel cartModel = cartItemList.get(i);
            int price = Integer.parseInt(cartModel.getProductPrice().substring(3));
            int qty = Integer.parseInt(cartModel.getProductQty());
            int total = price * qty;
            mainTotal += total;
        }
        binding.expense.setText(String.valueOf(mainTotal));
        binding.delivery.setText("5000");
        binding.total.setText(String.valueOf(mainTotal+5000));
    }

}