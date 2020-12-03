package com.antoinepc.travailsessionandroidautomne2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Accueil extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Infos_Utilisateur infos_utilisateur = new Infos_Utilisateur();

    BottomNavigationView bnvMenuBas;

    Recherche fRecherche;
    Creation_Vente_Garage fCreation_vente_garage;
    Mes_ventes_Garage fMes_ventes_garage;
    Ventes_garages_suivies fVentes_garages_suivies;
    Parametres fParametres;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        //RefreshInfos s'ils sont dans le téléphone
        //...

        fRecherche = new Recherche();
        fCreation_vente_garage = new Creation_Vente_Garage();
        fMes_ventes_garage = new Mes_ventes_Garage();
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
                        if (infos_utilisateur.getCourriel()=="-"){
                            Intent intent = new Intent(getApplicationContext(), Connexion.class);
                            startActivity(intent);
                            return true;
                        }
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flFragments,fCreation_vente_garage);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.mesVentesGarages:
                        if (infos_utilisateur.getCourriel()=="-"){
                            Intent intent = new Intent(getApplicationContext(), Connexion.class);
                            startActivity(intent);
                            return true;
                        }
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flFragments,fMes_ventes_garage);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.ventesGaragesSuivies:
                        if (infos_utilisateur.getCourriel()=="-"){
                            Intent intent = new Intent(getApplicationContext(), Connexion.class);
                            startActivity(intent);
                            return true;
                        }
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flFragments,fVentes_garages_suivies);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.monCompte:
                        if (infos_utilisateur.getCourriel()=="-"){
                            Intent intent = new Intent(getApplicationContext(), Connexion.class);
                            startActivity(intent);
                            return true;
                        }
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flFragments,fParametres);
                        fragmentTransaction.commit();
                        return true;
                }
                return false;
            }
        });

        Intent intent = getIntent();

        //À optimiser plus tard
        //switch (intent.getStringExtra("Ordre")){

        //}

        if (intent.hasExtra("fragments_1"))
        {
            activerFragmentAjout();
        }
        if (intent.hasExtra("fragments_2"))
        {
            activerFragmentAjout();
        }
        if(intent.hasExtra("Courriel")){
            infos_utilisateur.setCourriel(intent.getStringExtra("Courriel"));
        }
        if(intent.hasExtra("MotDePasse")){
            infos_utilisateur.setMdp(intent.getStringExtra("MotDePasse"));
        }
        if(intent.hasExtra("Nom")){
            infos_utilisateur.setNom(intent.getStringExtra("Nom"));
        }
        if(intent.hasExtra("Prenom")){
            infos_utilisateur.setPrenom(intent.getStringExtra("Prenom"));
        }
        if(intent.hasExtra("NoTelephone")){
            infos_utilisateur.setNoTelephone(intent.getStringExtra("NoTelephone"));
        }

    }

    public void activerFragmentAjout(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragments,fCreation_vente_garage);
        fragmentTransaction.commit();
        bnvMenuBas.getMenu().getItem(1).setChecked(true);
    }

    public void activerMesVentesGarages(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragments,fMes_ventes_garage);
        fragmentTransaction.commit();
        bnvMenuBas.getMenu().getItem(2).setChecked(true);
    }

    public void activerMesVentesGaragesSuivies(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragments,fVentes_garages_suivies);
        fragmentTransaction.commit();
        bnvMenuBas.getMenu().getItem(3).setChecked(true);
    }



    public void choixDate(View view){
        DialogFragment dialogFragment = new ChoixDate();
        dialogFragment.show(getSupportFragmentManager(),"choix_date");
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        TextView tvDate =findViewById(R.id.tvChoixDateCreationVenteGarage);

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,i);
        c.set(Calendar.MONTH,i1);
        c.set(Calendar.DAY_OF_MONTH,i2);

        String laDate = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CANADA).format(c.getTime());

        tvDate.setText(laDate);
    }

    public String getNomComplet(){
        return infos_utilisateur.getPrenom() + " " + infos_utilisateur.getNom();
    }

    public void resetInfosUtilisateur(){
        infos_utilisateur.setId_personne("-");
        infos_utilisateur.setCourriel("-");
        infos_utilisateur.setPrenom("-");
        infos_utilisateur.setNom("-");
        infos_utilisateur.setMdp("-");
        infos_utilisateur.setNoTelephone("-");
    }
}