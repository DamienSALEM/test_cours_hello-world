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

//Création de la class fille MainActivity
//Descendant de la mère AppCompatActivity
public class MainActivity extends AppCompatActivity {
    
    //initailisation des variables list et products
    private ListView listView;
    private ArrayList<String> products;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //le mot clé super permet de faire appel aux fonctions
        // ou aux variables présentes dans la class mère
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Création de la liste
        listView= findViewById((R.id.listView));
        
        //data de la liste
        products= new ArrayList<>();
        products.add("Farine");
        products.add("Oeufs");
        products.add("Jambon");
        products.add("Champignons");
        
        //Création d'un adapter pour afficher la liste.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,
                android.R.id.text1,products);
        listView.setAdapter(adapter);
        
        //On fait appel à la fonction swich pour qu'au bout de 3s,
        //la page change.
        swich();
    }
    public void onClickBtn(View v){
        //La fonction lié au bouton pour changer de page/activity
        Toast.makeText(this,"loading...",Toast.LENGTH_LONG).show();
        Intent nextActivity = new Intent(getApplicationContext(),NextActivity.class);
        startActivity(nextActivity); //ouvre la nouvelle activité
        finish(); //ferme l'activité courante
    }
    public void swich(){
        // Une fonction de delay. Un test pour faire de l'asynchrone
        //Cette fonction change de page/activity au bout de 3s
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Intent nextActivity = new Intent(getApplicationContext(),NextActivity.class);
                        startActivity(nextActivity); //ouvre la nouvelle activité
                        finish(); //ferme l'activité courante
                    }
                },
                3000);
    }
}