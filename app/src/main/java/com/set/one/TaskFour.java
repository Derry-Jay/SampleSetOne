package com.set.one;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TaskFour extends Activity implements LocationListener {
    TextView lat, lon, time, accuracy, height, bearing, speed, prv;
    private LocationManager lm;

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
        final Resources.Theme thm = getTheme();
        final Resources res = getResources();
        setValues();
        switch (res.getConfiguration().uiMode &
                Configuration.UI_MODE_NIGHT_MASK) {
            case Configuration.UI_MODE_NIGHT_YES:
                System.out.println("night");
                final int whiteColor = res.getColor(R.color.white, thm);
                lat.setTextColor(whiteColor);
                lon.setTextColor(whiteColor);
                time.setTextColor(whiteColor);
                accuracy.setTextColor(whiteColor);
                height.setTextColor(whiteColor);
                bearing.setTextColor(whiteColor);
                speed.setTextColor(whiteColor);
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                System.out.println("day");
                final int blackColor = res.getColor(R.color.black, thm);
                lat.setTextColor(blackColor);
                lon.setTextColor(blackColor);
                time.setTextColor(blackColor);
                accuracy.setTextColor(blackColor);
                height.setTextColor(blackColor);
                bearing.setTextColor(blackColor);
                speed.setTextColor(blackColor);
                break;

            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                System.out.println("undefined");
                break;
        }
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            System.out.println("Not Allowed");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        setValues();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(location.getTime());
        final double kmph = location.getSpeed() * 3.6, ht = location.hasAltitude() ? location.getAltitude() : 0.0;
        lat.setText("Latitude: " + location.getLatitude());
        lon.setText("Longitude: " + location.getLongitude());
        time.setText("Time: " + formatter.format(calendar.getTime()));
        accuracy.setText("Accuracy: " + location.getAccuracy());
        height.setText("Height: " + ht + " m");
        bearing.setText("Bearing: " + location.getBearing());
        speed.setText("Speed: " + kmph + " Km/hr");
        prv.setText("Provider: " + location.getProvider());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
        System.out.println(provider);
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
        System.out.println(provider);
        prv.setText("Provider: " + provider);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
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
        lm.requestLocationUpdates(provider, 0, 0, this);
    }
}