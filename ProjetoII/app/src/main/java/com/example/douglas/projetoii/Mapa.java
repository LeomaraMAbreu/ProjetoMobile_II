package com.example.douglas.projetoii;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

public class Mapa extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private TextView local;
    private GoogleApiClient mGoogleApiCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_mapa );

        local = (TextView) findViewById( R.id.local );
        callConnection();
    }

    private synchronized void callConnection() {
        mGoogleApiCliente = new GoogleApiClient.Builder( this )
                .addOnConnectionFailedListener( this )
                .addConnectionCallbacks( this )
                .addApi( LocationServices.API )
                .build();
        mGoogleApiCliente.connect();


    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.i( "LOG", "onConnected(" + bundle + ")" );
        if (ActivityCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission( this, Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location l = LocationServices.FusedLocationApi.getLastLocation( mGoogleApiCliente );
        if (l != null){
            Log.i("LOG", "latitude: "+l.getLatitude());
            Log.i("LOG", "longitude: "+l.getLongitude());
            local.setText(l.getLatitude() + " | " +l.getLongitude() );
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i("LOG", "onConnectionSuspended("+ i +")");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.i("LOG", "onConnectionFailed("+ connectionResult +")");
    }
}
