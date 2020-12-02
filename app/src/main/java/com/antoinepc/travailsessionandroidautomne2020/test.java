package com.antoinepc.travailsessionandroidautomne2020;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.DialogFragment;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class test extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Spinner sCategories = findViewById(R.id.sCategorieCreationVenteGarage);
        sCategories.setOnItemSelectedListener(this);

        Button bConfirmer = findViewById(R.id.bConfirmerCreationVenteGarage);


        bConfirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText    etTitre,
                            etNoMaison,
                            etNomRue,
                            etVille,
                            etCodePostal,
                            etCreateur;
                TextView    tvDate;

                etTitre=findViewById(R.id.etTitreCreationVenteGarage);
                tvDate=findViewById(R.id.tvChoixDateCreationVenteGarage);
                etNoMaison=findViewById(R.id.etNoAddresseCreationVenteGarage);
                etNomRue=findViewById(R.id.etNomRueCreationVenteGarage);
                etVille=findViewById(R.id.etVilleCreationVenteGarage);
                etCodePostal=findViewById(R.id.etCodePostalCreationVenteGarage);
                etCreateur=findViewById(R.id.etCreateurCreationVenteGarage);

                //Vérification si tous les champs ont été remplies
                if (TextUtils.isEmpty(etTitre.toString()) || TextUtils.isEmpty(tvDate.getText()) || TextUtils.isEmpty(etNoMaison.getText()) || TextUtils.isEmpty(etNomRue.getText()) || TextUtils.isEmpty(etVille.getText()) || TextUtils.isEmpty(etCodePostal.getText()) || TextUtils.isEmpty(etCreateur.getText())){
                    Toast.makeText(getApplicationContext(),"Vous n'avez pas remplies tous les champs",Toast.LENGTH_SHORT).show();
                    return;
                }

                //Vérification si ce sont des nombres
                if (!isNumber(etNoMaison.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Vous devez entrer un numéro pour l'adresse de la vente de garage",Toast.LENGTH_SHORT).show();
                    return;
                }

                //Vérification si le code postal est bon
                if (etCodePostal.length()==6 & !isNumber(etCodePostal.getText().toString().substring(0,1)) & isNumber(etCodePostal.getText().toString().substring(1,2)) & !isNumber(etCodePostal.getText().toString().substring(2,3)) & isNumber(etCodePostal.getText().toString().substring(3,4)) & !isNumber(etCodePostal.getText().toString().substring(4,5)) & isNumber(etCodePostal.getText().toString().substring(5)))
                {
                    Toast.makeText(getApplicationContext(),"Mise en place des données dans la BD....",Toast.LENGTH_SHORT).show();
                    //Mise en place des données dans la BD
                    //...

                }
                else{
                    Toast.makeText(getApplicationContext(),"Vous n'avez pas entrées le bon format de code postal",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,adapterView.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void choixDate(View view){
        DialogFragment dialogFragment = new ChoixDate();
        dialogFragment.show(getSupportFragmentManager(),"choix_date");
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        TextView tvDate = this.findViewById(R.id.tvChoixDateCreationVenteGarage);

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,i);
        c.set(Calendar.MONTH,i1);
        c.set(Calendar.DAY_OF_MONTH,i2);

        String laDate = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CANADA).format(c.getTime());

        tvDate.setText(laDate);
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