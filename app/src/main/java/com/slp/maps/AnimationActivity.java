package com.slp.maps;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AnimationActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap googleMap;
    private boolean mapReady = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
       MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.google_map);
        mapFragment.getMapAsync(this);
    }

    public void pointToSeattle(View view) {
        LatLng seattle = new LatLng(47.6204,-122.3491);
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(getCameraPostion(seattle)),4000,null);
        googleMap.addMarker(new MarkerOptions().position(seattle).title(getString(R.string.seattle)));
    }

    public void pointToNewYork(View view) {
        LatLng newYork = new LatLng(40.7127,-74.0059);
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(getCameraPostion(newYork)),5000,null);
        googleMap.addMarker(new MarkerOptions().position(newYork)//.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_audiotrack_dark))
                 .title(getString(R.string.new_york)));


    }

    public void pointToDublin(View view) {
        LatLng dublin = new LatLng(53.3478,6.2597);
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(getCameraPostion(dublin)),2000,null);
        googleMap.addMarker(new MarkerOptions().position(dublin).title(getString(R.string.dublin)));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        mapReady = true;
    }

    private CameraPosition getCameraPostion(LatLng latLng){
        return CameraPosition.builder().target(latLng).zoom(15).build();
    }
}
