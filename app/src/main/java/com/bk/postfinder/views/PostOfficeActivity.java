package com.bk.postfinder.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.bk.androidlocation.R;

public class PostOfficeActivity extends AppCompatActivity {

    private static final String TAG = "PostOfficeActivity";

    private TextView poName;
    private TextView poLatitude;
    private TextView poLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_office);
        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if(getIntent().hasExtra("postOfficeName") && getIntent().hasExtra("postOfficeLatitude") && getIntent().hasExtra("postOfficeLongitude")) {
            Log.d(TAG, "getIncomingIntent: found intent extras");
            String postOfficeName = getIntent().getStringExtra("postOfficeName");
            String postOfficeLatitude = getIntent().getStringExtra("postOfficeLatitude");
            String postOfficeLongitude = getIntent().getStringExtra("postOfficeLongitude");

            setId(postOfficeName, postOfficeLatitude, postOfficeLongitude);
        }
    }

    private void setId(String postOfficeName, String postOfficeLatitude, String postOfficeLongitude) {
        poName = (TextView) findViewById(R.id.txt_postOffice_name);
        poName.setText("" + postOfficeName);

        poLatitude = (TextView) findViewById(R.id.txt_postOffice_latitude);
        poLatitude.setText("" + postOfficeLatitude);

        poLongitude = (TextView) findViewById(R.id.txt_postOffice_longitude);
        poLongitude.setText("" + postOfficeLongitude);
    }


}
