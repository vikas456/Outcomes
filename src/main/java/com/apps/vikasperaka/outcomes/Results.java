package com.apps.vikasperaka.outcomes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        TextView crime = (TextView)findViewById(R.id.crimeTxt);
        TextView punishment = (TextView)findViewById(R.id.punishmentTxt);
        ImageButton main = (ImageButton)findViewById(R.id.mainBtn);
        ImageButton help = (ImageButton)findViewById(R.id.helpBtn);
        ImageButton disclaimer = (ImageButton)findViewById(R.id.disclaimerbtn);

        //Sets the punishment and crime texts from information retrieved from intent
        Crime c = (Crime)getIntent().getExtras().get("crime");
        crime.setText(c.getCrime());
        if (c.getTerm() != -1)
            punishment.setText(c.getPunishmnet());
        else
            punishment.setText("Execution");

        //Back to Home Screen
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        //Starts the Help Screen
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Help.class));
            }
        });

        //Create disclaimer pop-up with on click listener and toast
        disclaimer.setOnClickListener(new View.OnClickListener() {
            final String DISCLAIMER = "We are not responsible for any crimes or consequences you " +
                    "may face while using this application. This app was made for purely " +
                    "educational purposes and does not endorse any of these actions. Not all the " +
                    "crimes are listed within this application and currently only the punishments" +
                    " for the state of Texas are included. We are working to provide " +
                    "repercussions for the other 50 states and hope to have that for you soon. " +
                    "Thank you for you patience.";
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), DISCLAIMER, Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}
