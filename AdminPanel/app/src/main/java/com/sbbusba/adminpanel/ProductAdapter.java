package com.sbbusba.adminpanel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sbbusba.adminpanel.databinding.ItemProductBinding;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    ArrayList<ProductModel> products;

    public ProductAdapter(Context context) {
        this.context = context;
        products = new ArrayList<>();
    }

    public void addProduct(ProductModel productModel) {
        products.add(productModel);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductModel productModel = products.get(position);
        holder.binding.productTitle.setText(productModel.getTitle());
        holder.binding.productDescription.setText(productModel.getDescription());
        holder.binding.productPrice.setText(productModel.getPrice());

        Glide.with(context).load(productModel.getImage())
                .into(holder.binding.productImage);
    /*
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context,product_detail.class);
            intent.putExtra("model",productModel);
            context.startActivity(intent);
        });*/
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        ItemProductBinding binding;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemProductBinding.bind(itemView);
        }

    }

}
