package com.example.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {
    TextView mTextView;
    LocationManager locMgr;
    List<String> locProviders;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.txtOutput);
        button = findViewById(R.id.button);
        locMgr = (LocationManager) getSystemService(LOCATION_SERVICE); //가져오는 것
        //만드는 거라면 new LocationManager();

        locProviders = locMgr.getAllProviders();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s ="";
                for (int i = 0 ; i < locProviders.size() ; i++) {
                    s += "Loc. Provider: " + locProviders.get(i) + "\n"
                            + "Status: " + locMgr.isProviderEnabled(locProviders.get(i)) + "\n\n";
                }
                mTextView.setText(s);
            }
        });
    }
}