package com.antoinepc.travailsessionandroidautomne2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class Connexion extends AppCompatActivity {

    Toolbar             tbMenuHaut;
    TextInputEditText   tietCourriel,
                        tietMdp;
    Button              bConnexion;
    TextView            tvMdpOublie,
                        tvCreerCompte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);


        tietCourriel = findViewById(R.id.tietCourrielConnexion);
        tietMdp = findViewById(R.id.tietMdpConnexion);
        bConnexion = findViewById(R.id.bConnexionConnexion);
        tvMdpOublie = findViewById(R.id.tvMdpOublieConnexion);
        tvCreerCompte = findViewById(R.id.tvCreationCompteConnexion);


        bConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Vérifications pour voir si tout est ok

                //Vérifie si toutes les infos ont étés entrées
                if (TextUtils.isEmpty(tietCourriel.getText()) || TextUtils.isEmpty(tietMdp.getText())){
                    Toast.makeText(getApplicationContext(),"Vous devez entrer des informations dans tous les champs",Toast.LENGTH_SHORT).show();
                    return;
                }

                //Vérifie si le format de l'adresse mail est ok
                //...

                //Vérifie si le mot de passe est à la bonne taille
                if (tietMdp.length()>20){
                    Toast.makeText(getApplicationContext(),"Vous ne pouvez entrer qu'un nombre de 20 caractères maximum pour le mot de passe",Toast.LENGTH_SHORT).show();
                    return;
                }

                //Connexion à la BD pour vérifier si tout est correct
                //...

                //Si tout est correct
                Intent intent = new Intent(getApplicationContext(),Accueil.class);
                intent.putExtra("Courriel","antoine.st.arnaud.01@edu.cegeptr.qc.ca");
                intent.putExtra("MotDePasse","1234");
                intent.putExtra("Nom","St-Arnaud");
                intent.putExtra("Prenom","Antoine");
                intent.putExtra("NoTelephone","438-522-3176");
                startActivity(intent);
            }
        });

        tvMdpOublie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Bon bah RIP man",Toast.LENGTH_SHORT).show();
            }
        });

        tvCreerCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Creation_Compte.class);
                startActivity(intent);
            }
        });
    }

    public void retourAccueil(View view){
        Intent intent = new Intent(getApplicationContext(),Accueil.class);
        startActivity(intent);
    }
}