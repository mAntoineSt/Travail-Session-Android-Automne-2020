package com.antoinepc.travailsessionandroidautomne2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Accueil extends AppCompatActivity {

    BottomNavigationView bnvMenuBas;

    Recherche fRecherche;
    creation_vente_garage fCreation_vente_garage;
    Ventes_garages_suivies fVentes_garages_suivies;
    Parametres fParametres;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        fRecherche = new Recherche();
        fCreation_vente_garage = new creation_vente_garage();
        fVentes_garages_suivies = new Ventes_garages_suivies();
        fParametres = new Parametres();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flFragments,fRecherche);
        fragmentTransaction.commit();

        bnvMenuBas = findViewById(R.id.bnvMenusBas);

        bnvMenuBas.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.recherche:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flFragments,fRecherche);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.creationVenteGarage:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flFragments,fCreation_vente_garage);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.ventesGaragesSuivies:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flFragments,fVentes_garages_suivies);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.monCompte:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flFragments,fParametres);
                        fragmentTransaction.commit();
                        return true;
                }
                return false;
            }
        });

        Button bVerifInfosComptes,
                bVoirVentesGaragesSuivies,
                bVoirMesVentesGarages,
                bCreerVenteGarage,
                bDeconnexion;

        bVerifInfosComptes = findViewById(R.id.bVerifInfosComptesParametres);
        bVoirVentesGaragesSuivies =findViewById(R.id.bVentesGaragesSuiviesParametres);
        bVoirMesVentesGarages = findViewById(R.id.bMesVentesGaragesParametres);
        bCreerVenteGarage = findViewById(R.id.bCreerVenteGarageParametres);
        bDeconnexion = findViewById(R.id.bSeDeconnecterParametres);

        /*
        bVerifInfosComptes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        bVoirVentesGaragesSuivies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        bVoirMesVentesGarages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        bCreerVenteGarage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        bDeconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
*/

    }
}