package com.antoinepc.travailsessionandroidautomne2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Creation_Compte extends AppCompatActivity {

    TextInputEditText   tietPrenom,
                        tietNom,
                        tietCourriel,
                        tietMdp,
                        tietConfirmationMdp,
                        tietNoTelephone;
    Button              bConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation__compte);

        tietPrenom = findViewById(R.id.tietPrenomCreationCompte);
        tietNom = findViewById(R.id.tietNomCreationCompte);
        tietCourriel = findViewById(R.id.tietCourrielCreationCompte);
        tietMdp = findViewById(R.id.tietMdpCreationCompte);
        tietConfirmationMdp = findViewById(R.id.tietConfirmationMdpCreationCompte);
        tietNoTelephone = findViewById(R.id.tietNoTelephoneCreationCompte);
        bConfirmation = findViewById(R.id.bConfirmationInscriptionCreationCompte);

        bConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Vérification si tout est correct

                //Vérifie si tous les champs ont été remplies
                if (TextUtils.isEmpty(tietPrenom.getText()) || TextUtils.isEmpty(tietNom.getText()) || TextUtils.isEmpty(tietCourriel.getText()) || TextUtils.isEmpty(tietMdp.getText()) || TextUtils.isEmpty(tietConfirmationMdp.getText()) || TextUtils.isEmpty(tietNoTelephone.getText())){
                    Toast.makeText(getApplicationContext(),"Vous devez remplir tous les champs",Toast.LENGTH_SHORT).show();
                    return;
                }



                //Création de la personne dans la BD
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
    }

    public void RetourConnexion(View view){
        Intent intent = new Intent(getApplicationContext(),Connexion.class);
        startActivity(intent);
    }
}