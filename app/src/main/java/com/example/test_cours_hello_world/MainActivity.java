package com.example.test_cours_hello_world;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        
        
    }
    public void onClickBtn(View v){
        Toast.makeText(this,"loading...",Toast.LENGTH_LONG).show();
        Intent nextActivity = new Intent(getApplicationContext(),NextActivity.class);
        startActivity(nextActivity); //ouvre la nouvelle activité
        finish(); //ferme l'activité courante
    }
}