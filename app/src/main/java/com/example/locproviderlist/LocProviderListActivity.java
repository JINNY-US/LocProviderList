package com.example.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {
    TextView mTextView;
    LocationManager locMgr;
    List<String> locProviders;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.txtOutput);
        locMgr = (LocationManager) getSystemService(LOCATION_SERVICE); //가져오는 것
        //만드는 거라면 new LocationManager();

        locProviders = locMgr.getAllProviders();

        String s ="";
        for(int i = 0 ; i < locProviders.size() ; i++) {
            s += "Loc. Provider: " + locProviders.get(i) + "\n"
                    + "status: " + locMgr.isLocationEnabled(locProviders.get(i)) + "\n\n";

        }
        mTextView.setText(s);
    }
}