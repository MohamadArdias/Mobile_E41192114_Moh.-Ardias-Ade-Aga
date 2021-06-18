package com.example.lbs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    final private int REQUEST_COURSE_ACCES = 123;
    boolean permissionGranted = false;
    LocationListener locationListener;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onPause(){
        super.onPause();
//        ---remove the lonation listener---
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_COURSE_ACCES);
            return;
        } else {
            permissionGranted = true;
        }if(permissionGranted){
            locationManager.removeUpdates(locationListener);
        }
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

//        Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(42.3601, -71.0589);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        mMap = googleMap;
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new MyLocationListener();

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new
                    String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_COURSE_ACCES);
            return;
        }else {
            permissionGranted = true;
        }if (permissionGranted) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    0,0, locationListener);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permission,
                                          int[] grantResults) {
        switch (requestCode) {
            case REQUEST_COURSE_ACCES:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    permissionGranted = true;
                }else {
                    permissionGranted = false;
                }break;
            default:
                super.onRequestPermissionsResult(requestCode, permission,grantResults);
        }
    }

    private class MyLocationListener implements LocationListener{
        private String provider;
        private int status;
        private Bundle extras;

        public void onLocationChanged(Location location){
            if (location != null){
                Toast.makeText(getBaseContext(), "Location changed : Lat: \"" +
                        + location.getLatitude() +" \n"+" \"Lng: \n"
                        + location.getLongitude(), Toast.LENGTH_SHORT).show();
                LatLng p = new LatLng((int) (location.getLatitude()),
                        (int) (location.getLongitude()));
                mMap.moveCamera((CameraUpdateFactory.newLatLng(p)));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(9));
            }
        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {

        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }


    }
}