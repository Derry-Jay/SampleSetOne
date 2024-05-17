package com.set.one;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

public class TaskFour extends Activity implements LocationListener {
    TextView lat, lon, time, accuracy, height, bearing, speed, prv;
    private LocationManager lm;

//    private LocationListener li;

    private void setValues() {
        lat = findViewById(R.id.latitude);
        lon = findViewById(R.id.longitude);
        time = findViewById(R.id.time);
        accuracy = findViewById(R.id.accuracy);
        height = findViewById(R.id.height);
        bearing = findViewById(R.id.bearing);
        speed = findViewById(R.id.speed);
        prv = findViewById(R.id.provider);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_four);
        setValues();
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        setValues();
        lat.setText("Latitude: " + location.getLatitude());
        lon.setText("Longitude: " + location.getLongitude());
        time.setText("Time: " + location.getTime());
        accuracy.setText("Accuracy: " + location.getAccuracy());
        height.setText("Height: " + location.getAltitude());
        bearing.setText("Bearing: " + location.getBearing());
        speed.setText("Speed: " + location.getSpeed());
        prv.setText("Provider: " + location.getProvider());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
        prv.setText("Provider: " + provider);
    }
}