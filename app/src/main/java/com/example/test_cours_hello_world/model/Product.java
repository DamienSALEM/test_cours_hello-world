package com.example.test_cours_hello_world.model;

import android.util.Log;

public class Product {
    private static final String TAG= "Product Model";
    private static  int nbProduct=0;
    private String name;
    private double price;
    
    public Product(String name, double price){
        this.name=name;
        this.price=price;
        Log.d(TAG,"product creation "+name+" "+price);
        nbProduct++;
    }
    
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double p){
        if(p>0)
            this.price=p;
        else
        Log.e(TAG,"Price should be >0");
    }
    //public void setName(String name){
    //    this.name=name;
    //}
}
