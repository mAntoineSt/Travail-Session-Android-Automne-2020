package com.antoinepc.travailsessionandroidautomne2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Visualisation_vente_garage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualisation_vente_garage);

        Button bRevenir,
                bSuivreVenteGarage;
        TextView tvTitre,
                tvDate,
                tvNoAddresse,
                tvNomRue,
                tvVille,
                tvCodePostal,
                tvCreateur,
                tvCategorie;

        bRevenir=findViewById(R.id.bRevenirVisualisationVenteGarage);
        bSuivreVenteGarage=findViewById(R.id.bSuivreVenteGarageVisualisationVenteGarage);
        tvTitre=findViewById(R.id.tvTitreVisualisationVenteGarage);
        tvDate=findViewById(R.id.tvResultatDateVisualisationVenteGarage);
        tvNoAddresse=findViewById(R.id.tvResultatNoAdresseVisualisationVenteGarage);
        tvNomRue=findViewById(R.id.tvResultatNomRueVisualisationVenteGarage);
        tvVille=findViewById(R.id.tvResultatVilleVisualisationVenteGarage);
        tvCodePostal=findViewById(R.id.tvResultatCodePostalVisualisationVenteGarage);
        tvCreateur=findViewById(R.id.tvResultatCreateurVisualisationVenteGarage);
        tvCategorie=findViewById(R.id.tvResultatCategorieVisualisationVenteGarage);

        //Recherche BD des infos........

        //Changer pour leur vraies valeurs
        tvTitre.setText("test");
        tvDate.setText("test");
        tvNoAddresse.setText("test");
        tvNomRue.setText("test");
        tvVille.setText("test");
        tvCodePostal.setText("test");
        tvCreateur.setText("test");
        tvCategorie.setText("test");

        bRevenir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Revenir",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),Accueil.class);
                startActivity(intent);
            }
        });

        bSuivreVenteGarage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Suivre cette vente de garage",Toast.LENGTH_SHORT).show();
                //Code pour suivre la vente de garage
            }
        });
    }
}