package com.slp.maps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class StreetViewActivity extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_view);
        StreetViewPanoramaFragment fragment = (StreetViewPanoramaFragment) getFragmentManager().findFragmentById(R.id.street_view_fragment);
        fragment.getStreetViewPanoramaAsync(this);
    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        streetViewPanorama.setPosition(new LatLng(36.0579667,-112.1430996));
        StreetViewPanoramaCamera camera = StreetViewPanoramaCamera.builder().tilt(20).build();
        streetViewPanorama.animateTo(camera,10);
    }
}
