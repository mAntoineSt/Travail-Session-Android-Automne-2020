package com.antoinepc.travailsessionandroidautomne2020;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class Google_Maps_Adresse extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    MapView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google__maps__adresse);

        view = (MapView) findViewById(R.id.mapview);
        view.onCreate(savedInstanceState);
        view.getMapAsync(this);
    }

    @Override
    protected void onResume() {
        view.onResume();
        super.onResume();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    public void onMapReady(View view){
        EditText endroitRecherche = (EditText) findViewById(R.id.etAdresseComplete);
        String endroit = endroitRecherche.getText().toString();
        List<Address> addresseListe=null;
        if (endroit!=null||endroit.equals("")){
            Geocoder geocoder = new Geocoder(this);
            try {
                addresseListe=geocoder.getFromLocationName(endroit,1);;
            }
            catch (IOException e){
                e.printStackTrace();
            }
            Address addresse=addresseListe.get(0);
            LatLng latLng = new LatLng(addresse.getLatitude(),addresse.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title(endroit));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        }
    }
}