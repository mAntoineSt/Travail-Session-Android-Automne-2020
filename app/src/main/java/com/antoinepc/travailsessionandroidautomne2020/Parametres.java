package com.antoinepc.travailsessionandroidautomne2020;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Parametres extends Fragment implements View.OnClickListener {

    Button  bVerifInfosComptes,
            bVoirVentesGaragesSuivies,
            bVoirMesVentesGarages,
            bCreerVenteGarage,
            bDeconnexion;

    public Parametres() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parametres, container, false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.bVerifInfosComptesParametres:
                Toast.makeText(getContext(),"sdffsd",Toast.LENGTH_SHORT).show(); break;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bVerifInfosComptes = getActivity().findViewById(R.id.bVerifInfosComptesParametres);
        bVoirVentesGaragesSuivies = getActivity().findViewById(R.id.bVentesGaragesSuiviesParametres);
        bVoirMesVentesGarages = getActivity().findViewById(R.id.bMesVentesGaragesParametres);
        bCreerVenteGarage = getActivity().findViewById(R.id.bCreerVenteGarageParametres);
        bDeconnexion = getActivity().findViewById(R.id.bSeDeconnecterParametres);

        bVerifInfosComptes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        bVoirVentesGaragesSuivies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Accueil accueil = (Accueil) getActivity();
                accueil.activerMesVentesGaragesSuivies();
            }
        });

        bVoirMesVentesGarages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Accueil accueil = (Accueil) getActivity();
                accueil.activerMesVentesGarages();
            }
        });

        bCreerVenteGarage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Accueil accueil = (Accueil) getActivity();
                accueil.activerFragmentAjout();
            }
        });

        bDeconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Accueil accueil = (Accueil) getActivity();
                accueil.resetInfosUtilisateur();
                Intent intent = new Intent(getContext(),Accueil.class);
                Toast.makeText(getContext(),"Déconnection effectuée",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}