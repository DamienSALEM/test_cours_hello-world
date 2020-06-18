package com.example.test_cours_hello_world.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.test_cours_hello_world.R;
import com.example.test_cours_hello_world.model.Product;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private static final String TAG = "ProductAdapter";
    private List<Product> items;
    private LayoutInflater inflater;
    private Context context;
    
    public ProductAdapter(Context context,List<Product> items){
        this.items=items;
        this.context=context;
        this.inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return items.size();
    }
    
    @Override
    public Product getItem(int i) {
        return items.get(i);
    }
    
    @Override
    public long getItemId(int i) {
        return 0;
    }
    
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.product_item,null);
        TextView tvName=view.findViewById(R.id.tv_product_item1);
        TextView tvPrice=view.findViewById(R.id.tv_product_item2);
        Product currentItem=getItem(i);
        tvName.setText(currentItem.getName());
        tvPrice.setText(currentItem.getPrice()+" euros");
        Log.d(TAG, "add new item to listview"+currentItem.getName());
        return view;
    }
}
