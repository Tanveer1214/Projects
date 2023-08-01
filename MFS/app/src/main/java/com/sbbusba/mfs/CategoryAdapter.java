package com.sbbusba.mfs;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends BaseAdapter {

    private String name[];
    private int image[];
    Context context;
    protected LayoutInflater inflater;

    public CategoryAdapter(String[] name, int[] image, Context context) {
        this.name = name;
        this.image = image;
        this.context = context;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {

        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.category_layout,null);

        ImageView img = (ImageView) view.findViewById(R.id.categoryImage);
        TextView n = (TextView) view.findViewById(R.id.categoryName);

        img.setImageResource(image[i]);
        n.setText(name[i]);
        return view;
    }
}
