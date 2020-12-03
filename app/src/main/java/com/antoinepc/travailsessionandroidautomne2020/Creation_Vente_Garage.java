package com.antoinepc.travailsessionandroidautomne2020;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Creation_Vente_Garage extends Fragment implements AdapterView.OnItemSelectedListener
{



    public Creation_Vente_Garage() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_creation__vente__garage, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Accueil accueil = (Accueil) getActivity();
        EditText etCreateur=getActivity().findViewById(R.id.etCreateurCreationVenteGarage);
        etCreateur.setText(accueil.getNomComplet());

        Spinner sCategories = getActivity().findViewById(R.id.sCategorieCreationVenteGarage);
        sCategories.setOnItemSelectedListener(this);

        Button bConfirmer = getActivity().findViewById(R.id.bConfirmerCreationVenteGarage);
        Button bRevenir = getActivity().findViewById(R.id.bRevenirCreationVenteGarage);

        bConfirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etTitre,
                        etNoMaison,
                        etNomRue,
                        etVille,
                        etCodePostal;
                TextView tvDate;

                etTitre= getActivity().findViewById(R.id.etTitreCreationVenteGarage);
                tvDate=getActivity().findViewById(R.id.tvChoixDateCreationVenteGarage);
                etNoMaison=getActivity().findViewById(R.id.etNoAddresseCreationVenteGarage);
                etNomRue=getActivity().findViewById(R.id.etNomRueCreationVenteGarage);
                etVille=getActivity().findViewById(R.id.etVilleCreationVenteGarage);
                etCodePostal=getActivity().findViewById(R.id.etCodePostalCreationVenteGarage);

                //Vérification si tous les champs ont été remplies
                if (TextUtils.isEmpty(etTitre.getText()) || TextUtils.isEmpty(tvDate.getText()) || TextUtils.isEmpty(etNoMaison.getText()) || TextUtils.isEmpty(etNomRue.getText()) || TextUtils.isEmpty(etVille.getText()) || TextUtils.isEmpty(etCodePostal.getText())){
                    Toast.makeText(getContext(),"Vous n'avez pas remplies tous les champs",Toast.LENGTH_SHORT).show();
                    return;
                }

                //Vérification si ce sont des nombres
                if (!isNumber(etNoMaison.getText().toString()))
                {
                    Toast.makeText(getContext(),"Vous devez entrer un numéro pour l'adresse de la vente de garage",Toast.LENGTH_SHORT).show();
                    return;
                }

                //Vérification si le code postal est bon
                if (etCodePostal.length()==6 & !isNumber(etCodePostal.getText().toString().substring(0,1)) & isNumber(etCodePostal.getText().toString().substring(1,2)) & !isNumber(etCodePostal.getText().toString().substring(2,3)) & isNumber(etCodePostal.getText().toString().substring(3,4)) & !isNumber(etCodePostal.getText().toString().substring(4,5)) & isNumber(etCodePostal.getText().toString().substring(5)))
                {
                    Toast.makeText(getContext(),"Mise en place des données dans la BD....",Toast.LENGTH_SHORT).show();
                    //Mise en place des données dans la BD
                    //...

                }
                else{
                    Toast.makeText(getContext(),"Vous n'avez pas entrées le bon format de code postal",Toast.LENGTH_SHORT).show();
                }

            }
        });

        bRevenir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Accueil.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }




    private boolean isNumber(String test)
    {
        try {
            Integer.parseInt(test);
        }
        catch (NullPointerException | NumberFormatException ignored){
            return false;
        }
        return true;
    }
}