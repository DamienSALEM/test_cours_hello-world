package com.example.test_cours_hello_world;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.test_cours_hello_world.adapter.ProductAdapter;
import com.example.test_cours_hello_world.database.DBManager;
import com.example.test_cours_hello_world.model.Product;

import java.util.ArrayList;

public class OtherActivity extends AppCompatActivity {
    private static final String TAG ="OtherActivity";
    private EditText etName;
    private EditText etPrice;
    private ListView listView;
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
    
        dbManager = new DBManager(this);
        
        etName=findViewById(R.id.et_main_name);
        etPrice=findViewById(R.id.et_main_price);
        listView=findViewById(R.id.lv_main);
    
        ArrayList<Product> products = new ArrayList<>();
        //products.add(new Product("Farine",3.15));
        //products.add(new Product("chocolat",4.5));
        //products.add(new Product("Oeufs x6",2.85));
        
        //ArrayList<Product> products=dbManager.getAllProducts();
        listView.setAdapter(new ProductAdapter(this,products));
    }
    public void onClickAddBtn(View view){
        String name= etName.getText().toString();
        Double price=Double.parseDouble(etPrice.getText().toString());
        Log.d(TAG,"etname : "+name);
        Log.d(TAG,"etprice : "+ price);
        
        Product newProduct=new Product(name,price);
        dbManager.addNewProductToDB(newProduct);
        finish();
        overridePendingTransition(0,0);
        startActivity(getIntent());
        overridePendingTransition(0,0);
    }
}