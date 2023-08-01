package com.sbbusba.adminpanel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.sbbusba.adminpanel.databinding.ActivityDashBoardBinding;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.Arrays;
import java.util.List;

public class DashBoard extends AppCompatActivity {
    ActivityDashBoardBinding binding;
    private OrdersAdapter ordersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        slider();
        getOrders();

        ordersAdapter = new OrdersAdapter(this);
        binding.productRecycler.setAdapter(ordersAdapter);
        binding.productRecycler.setLayoutManager(new LinearLayoutManager(this));

        int []image = {
                R.drawable.shipped,
                R.drawable.outbox
        };
        String []name = {"Delivered Orders","Products"};
        binding.categoryGrid.setAdapter(new CategoryAdapter(name,image,this));
        binding.categoryGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0) {
                    startActivity(new Intent(DashBoard.this,DeliveredOrders.class));
                }
                if(i == 1) {
                    startActivity(new Intent(DashBoard.this,Products.class));
                }

            }
        });


    }

    private void slider() {
        binding.carousel.addData(new CarouselItem("https://firebasestorage.googleapis.com/v0/b/furniture-app-b5286.appspot.com/o/Green%20Minimalist%20Furniture%20Banner.png?alt=media&token=b4a27a26-b60b-4595-863d-08f8dbd4675a"));
    }

    private void getOrders() {
        FirebaseFirestore.getInstance()
                .collection("orders")
                .whereIn("order_status", Arrays.asList("Pending","Confirmed"))
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> dsList = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot ds : dsList) {
                            OrderModel orderModel = ds.toObject(OrderModel.class);
                            ordersAdapter.addProduct(orderModel);
                        }
                    }
                });
    }

}