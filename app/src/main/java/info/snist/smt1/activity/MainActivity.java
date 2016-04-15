package info.snist.smt1.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.HashMap;

import info.snist.smt1.R;
import info.snist.smt1.helper.SQLiteHandler;
import info.snist.smt1.helper.SessionManager;

public class MainActivity extends Activity {
	InterstitialAd mInterstitialAd;

	private TextView txtName;
	private TextView txtEmail;
	private Button btnLogout;
    private Button btnnext;

	private SQLiteHandler db;
	private SessionManager session;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        addListenerOnButton();


		txtName = (TextView) findViewById(R.id.name);
		txtEmail = (TextView) findViewById(R.id.email);
		btnLogout = (Button) findViewById(R.id.btnLogout);
		btnnext =(Button) findViewById(R.id.next);

		// SqLite database handler
		db = new SQLiteHandler(getApplicationContext());

		// session manager
		session = new SessionManager(getApplicationContext());

		mInterstitialAd = new InterstitialAd(this);
		mInterstitialAd.setAdUnitId("ca-app-pub-8342113655467030/6606216901");

		mInterstitialAd.setAdListener(new AdListener() {
			@Override
			public void onAdClosed() {
				requestNewInterstitial();
                addListenerOnButton();

			}
		});

		requestNewInterstitial();




		if (!session.isLoggedIn()) {
			logoutUser();
		}

		// Fetching user details from SQLite
		HashMap<String, String> user = db.getUserDetails();

		String name = user.get("name");
		String email = user.get("email");


		// Displaying the user details on the screen
		txtName.setText(name);
		txtEmail.setText(email);

		// Logout button click event
		btnLogout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
                logoutUser();
				if (mInterstitialAd.isLoaded()) {
					mInterstitialAd.show();

				} }
		});
	}
	private void requestNewInterstitial() {
		AdRequest adRequest = new AdRequest.Builder()
				.addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
				.build();

		mInterstitialAd.loadAd(adRequest);
	}

    public void addListenerOnButton() {

        final Context context = this;

        btnnext = (Button) findViewById(R.id.next);

        btnnext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0)
            {

                if (mInterstitialAd.isLoaded())
                {
                    mInterstitialAd.show();
                }
                else
                {
                Intent intent = new Intent(context,MainActivity1.class);
                startActivity(intent);

            }
            }

        });

    }

	/**
	 * Logging out the user. Will set isLoggedIn flag to false in shared
	 * preferences Clears the user data from sqlite users table
	 * */
	private void logoutUser() {


		session.setLogin(false);

db.deleteUsers();

		// Launching the login activity
		Intent intent = new Intent(MainActivity.this, Welcome.class);
		startActivity(intent);
		finish();
	}
}
