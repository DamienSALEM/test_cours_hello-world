package com.example.test_cours_hello_world;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listView= findViewById((R.id.listView));
        
        //data
        products= new ArrayList<>();
        products.add("Farine");
        products.add("Oeufs");
        products.add("Jambon");
        products.add("Champignons");
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,
                android.R.id.text1,products);
        listView.setAdapter(adapter);
    }
    public void onClickBtn(View v){
        Toast.makeText(this,"loading...",Toast.LENGTH_LONG).show();
        Intent nextActivity = new Intent(getApplicationContext(),NextActivity.class);
        startActivity(nextActivity); //ouvre la nouvelle activité
        finish(); //ferme l'activité courante
    }
}