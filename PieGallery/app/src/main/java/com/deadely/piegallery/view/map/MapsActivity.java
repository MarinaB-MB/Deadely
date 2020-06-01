package com.deadely.piegallery.view.map;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.deadely.piegallery.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;
    private LatLng user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    if (location != null) {
                        LatLng crimea = new LatLng(45, 34);
                        mMap.addMarker(new MarkerOptions().position(crimea).title("Crimea").draggable(false));

                        user = new LatLng(location.getLongitude(), location.getLatitude());
                        mMap.addMarker(new MarkerOptions().position(user).title("Your are here").draggable(false));

                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(user, 10), 5000, null);
                    }
                });
    }
}
