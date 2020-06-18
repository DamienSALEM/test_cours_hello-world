package com.example.test_cours_hello_world.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.test_cours_hello_world.model.Product;

import java.util.ArrayList;

public class DBManager {
    private static final String TAG="DBManager";
    private static final String DB_NAME="listecourse.sqlite";
    private static final int DB_VERSION=1;
    private SQLiteDatabase db;
    private DBHelper helper;
    
    //private String
    public DBManager(Context context){
        helper= new DBHelper(context,DB_NAME,null,DB_VERSION);
    }
    public void addNewProductToDB(Product p){
        //db= base de donnée en écriture
        db=helper.getWritableDatabase();
        String sqlQuery="INSERT INTO Product(name,price) VALUES('"+p.getName()+"',"+p.getPrice()+");";
        //executer la requête
        db.execSQL(sqlQuery);
    }
    public ArrayList<Product> getAllProducts(){
        ArrayList<Product> results=new ArrayList<>();
        db=helper.getReadableDatabase();
        //db=la base de donnée en lecture
        String sqlQuery="SELECT * FROM Product;";
        Log.d(TAG,sqlQuery);
        Cursor c = db.rawQuery(sqlQuery,null);
        if(!c.moveToFirst()){
            Log.v(TAG,"There are no products in the database");
        }else{
            do{
                Log.d(TAG,"c.getInt(0):"+c.getInt(0));
                Log.d(TAG,"c.getString(1) :"+c.getString(1));
                Log.d(TAG,"c.getDouble(2): "+c.getDouble(2));
                
                results.add(new Product(c.getString(1),c.getDouble(2)));
            }while(c.moveToNext());
        }
        c.close();
        return results;
    }
}
