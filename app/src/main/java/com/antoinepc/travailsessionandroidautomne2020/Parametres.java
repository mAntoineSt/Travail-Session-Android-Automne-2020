package com.antoinepc.travailsessionandroidautomne2020;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Parametres extends Fragment implements View.OnClickListener {


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

        Button  bVerifInfosComptes,
                bVoirVentesGaragesSuivies,
                bVoirMesVentesGarages,
                bCreerVenteGarage,
                bDeconnexion;

        bVerifInfosComptes = getActivity().findViewById(R.id.bVerifInfosComptesParametres);
        bVoirVentesGaragesSuivies = getActivity().findViewById(R.id.bVentesGaragesSuiviesParametres);
        bVoirMesVentesGarages = getActivity().findViewById(R.id.bMesVentesGaragesParametres);
        bCreerVenteGarage = getActivity().findViewById(R.id.bCreerVenteGarageParametres);
        bDeconnexion = getActivity().findViewById(R.id.bSeDeconnecterParametres);
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
        });*/
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
}