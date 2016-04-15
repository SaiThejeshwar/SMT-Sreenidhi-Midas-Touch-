package info.snist.smt1.activity;

/**
 * Created by sai on 08-02-2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.pushbots.push.Pushbots;

import info.snist.smt1.R;

public class Welcome extends Activity {


    private Button btnstu;
    private Button btnadm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_welcome);
        Pushbots.sharedInstance().init(this);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btnstu =(Button) findViewById(R.id.button2);
        btnadm =(Button) findViewById(R.id.button3);

        btnadm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


        Toast.makeText(getApplicationContext(),
                "Sorry!! Access Denied", Toast.LENGTH_LONG)
                .show();
            }

        });
        btnstu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Welcome.this,LoginActivity.class);
                startActivity(intent);

            }

        });


    }

}