package com.sbbusba.mfs;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.sbbusba.mfs.databinding.ItemProductBinding;
import com.sbbusba.mfs.databinding.OrderRowBinding;

import java.util.ArrayList;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ProductViewHolder> {

    Context context;
    ArrayList<OrderModel> products;

    public OrdersAdapter(Context context) {
        this.context = context;
        products = new ArrayList<>();
    }

    public void addProduct(OrderModel productModel) {
        products.add(productModel);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_row,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        OrderModel orderModel = products.get(position);
        holder.binding.orderName.setText(orderModel.getCustomer_name());
        holder.binding.orderNumber.setText(orderModel.getCustomer_number());
        holder.binding.orderAddress.setText(orderModel.getCustomer_address());
        holder.binding.orderCity.setText(orderModel.getCustomer_city());
        holder.binding.orderTitle.setText(orderModel.getOrderNumber());
        holder.binding.orderStatus.setText(orderModel.getOrder_status());
        holder.binding.orderTrackingNumber.setText(orderModel.getOrderPlacingDate());
        /**
        if(orderModel.getOrderTrackingNumber() != null) {
            holder.binding.orderTrackingNumber.setText(orderModel.getOrderTrackingNumber());
        }*/

        int totalAmount = Integer.parseInt(orderModel.getItemExpense())+Integer.parseInt(orderModel.getDelivery_charges());
        holder.binding.orderAmount.setText(String.valueOf(totalAmount));

        CartAdapter cartAdapter = new CartAdapter(context);
        holder.binding.orderProductRecycler.setAdapter(cartAdapter);
        holder.binding.orderProductRecycler.setLayoutManager(new LinearLayoutManager(context));
        FirebaseFirestore.getInstance()
                .collection("orderProducts")
                .whereEqualTo("orderNumber",orderModel.getOrderNumber())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> dsList = queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot ds:dsList) {
                            CartModel cartModel = ds.toObject(CartModel.class);
                            cartAdapter.addProduct(cartModel);
                        }
                    }
                });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        OrderRowBinding binding;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = OrderRowBinding.bind(itemView);
        }

    }

}
