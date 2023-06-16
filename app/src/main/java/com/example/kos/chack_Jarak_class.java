package com.example.kos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class chack_Jarak_class extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;
    private List<LatLng> markedLocations;
    private Polyline polyline;

    private Button buttonCalculateDistance;
    private TextView textViewDistance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.chack_jarak_main);
        buttonCalculateDistance = findViewById(R.id.buttonCalculateDistance);
        textViewDistance = findViewById(R.id.textViewDistance);
        markedLocations = new ArrayList<>();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);

        buttonCalculateDistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDistance();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                markLocationOnMap(latLng);
            }
        });

        // Posisi default saat peta pertama kali ditampilkan
        LatLng defaultLocation = new LatLng(-6.130273, 106.818271);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 15));


    }

    private void markLocationOnMap(LatLng latLng) {
        MarkerOptions markerOptions = new MarkerOptions().position(latLng);
        googleMap.addMarker(markerOptions);

        markedLocations.add(latLng);
    }

    private void calculateDistance() {
        int n = markedLocations.size();
        double[][] distances = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = getDistance(markedLocations.get(i), markedLocations.get(j));
            }
        }

        // Terapkan algoritma Floyd Warshall untuk menghitung jarak terpendek
        distances = fw(distances);

        if (polyline != null) {
            polyline.remove();
        }

        PolylineOptions polylineOptions = new PolylineOptions().color(Color.RED).width(5);

        for (int i = 0; i < n; i++) {
            polylineOptions.add(markedLocations.get(i));
        }

        polyline = googleMap.addPolyline(polylineOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(markedLocations.get(0), 15));

        // Tampilkan hasil perhitungan jarak pada TextView
        textViewDistance.setText("Jarak terpendek: " + distances[0][n-1] + " km");
    }

    private double[][] fw(double[][] graph) {
        int n = graph.length;
        double[][] distances = new double[n][n];
        int[][] predecessor = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = graph[i][j];
                if (graph[i][j] < Double.POSITIVE_INFINITY) {
                    predecessor[i][j] = i;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distances[i][j] > distances[i][k] + distances[k][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                        predecessor[i][j] = predecessor[k][j];
                    }
                }
            }
        }

        return distances;
    }

    private double getDistance(LatLng location1, LatLng location2) {
        double lat1 = location1.latitude;
        double lon1 = location1.longitude;
        double lat2 = location2.latitude;
        double lon2 = location2.longitude;
        double R = 6371; // Radius of the earth in km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c; // Distance in km
        return distance;
    }

}