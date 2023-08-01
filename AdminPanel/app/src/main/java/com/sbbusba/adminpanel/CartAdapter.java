package com.sbbusba.adminpanel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sbbusba.adminpanel.databinding.CartRowBinding;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ProductViewHolder> {

    Context context;
    ArrayList<CartModel> products;
    public CartAdapter(Context context) {
        this.context = context;
        products = new ArrayList<>();
    }

    public void addProduct(CartModel CartModel) {
        products.add(CartModel);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_row,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        CartModel cartModel = products.get(position);
        holder.binding.cartTitle.setText(cartModel.getProductName());
        holder.binding.cartQty.setText("Quantity: "+cartModel.getProductQty());
        holder.binding.cartPrice.setText(cartModel.getProductPrice());
        Glide.with(context).load(cartModel.getProductImage())
                .into(holder.binding.cartImage);


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        CartRowBinding binding;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CartRowBinding.bind(itemView);
        }

    }

}
