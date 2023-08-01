package com.sbbusba.mfs;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sbbusba.mfs.databinding.CartRowBinding;
import com.sbbusba.mfs.databinding.ItemProductBinding;

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

    public List<CartModel> getSelectedItem() {
        List<CartModel> selectedItem = new ArrayList<>();
        for(int i=0;i<products.size();i++) {
            if(products.get(i).is_selected) {
                selectedItem.add(products.get(i));
            }
        }
        return selectedItem;
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

        holder.itemView.setOnClickListener(v -> {
            if(cartModel.is_selected) {
                holder.binding.mainLayout.setBackgroundColor(context.getResources().getColor(R.color.white));
                cartModel.is_selected = false;
            }
            else {
                holder.binding.mainLayout.setBackgroundColor(context.getResources().getColor(R.color.selection));
                cartModel.is_selected = true;
            }
        });

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
