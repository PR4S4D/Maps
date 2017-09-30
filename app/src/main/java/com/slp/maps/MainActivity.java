package com.slp.maps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap googleMap;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.google_map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        this.googleMap = googleMap;
        LatLng blore = new LatLng(13.0479029, 77.5103334);
        CameraPosition target = CameraPosition.fromLatLngZoom(blore, 17);
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
        googleMap.addMarker(new MarkerOptions().position(blore).title("Namma City"));
    }

    public void setMapTypeToSatellite(View view) {
        if(mapReady){
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }
    }

    public void setMapTypeToNormal(View view) {
        if(mapReady){
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
    }

    public void setMapTypeToHybrid(View view) {
        if(mapReady){
            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        }
    }

}
