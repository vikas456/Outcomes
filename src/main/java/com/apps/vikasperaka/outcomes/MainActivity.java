package com.apps.vikasperaka.outcomes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

//Later add age/juvenile consequences, punishments varying by state, web scraping

public class MainActivity extends AppCompatActivity {

    //Array constant containing all the different types of crimes contained within this app. This
    //list is influenced by the 20 most common crimes in the US.
    final String[] VALUES = {"Select", "Academic Cheating", "Animal Fight", "Assault",
    "Cable Theft", "Child Abuse", "Consumption of Alcohol by Minor", "Credit Card Abuse", "DWI",
    "Delivery of Drugs", "Manufacture Drugs", "Murder", "Possession of Drugs",
    "Possession of Marijuana", "Providing Alcohol to Minor", "Public Intoxication",
    "Purchase Alcohol by Minor", "Sexual Assault", "Shooting", "Stalking", "Threats"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Drop down menu containing the different crimes
        Spinner spinner = (Spinner)findViewById(R.id.optionSpinner);

        //Describes the app
        ImageButton about = (ImageButton)findViewById(R.id.aboutBtn);

        //Instructs user how to use the app
        ImageButton help = (ImageButton)findViewById(R.id.helpBtn);

        //Disclaimer for legal purposes
        ImageButton disclaimer = (ImageButton)findViewById(R.id.disclaimerBtn);

        //Sets up drop down menu
        ArrayAdapter<String> arrayAdapterdapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.spin, VALUES);
        spinner.setAdapter(arrayAdapterdapter);

        //On selection listener, starts Result intent
        //Sends in type of crime and punishment
        //Values based on Texas State penal code
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Punishment values for each crime
                switch (i){
                    case 1: startIntent(VALUES[1], 0, 500);
                        break;
                    case 2: startIntent(VALUES[2], 0, 500);
                        break;
                    case 3: startIntent(VALUES[3], 20, 10000);
                        break;
                    case 4: startIntent(VALUES[4], 1, 4000);
                        break;
                    case 5: startIntent(VALUES[5], 20, 10000);
                        break;
                    case 6: startIntent(VALUES[6], 0, 500);
                        break;
                    case 7: startIntent(VALUES[7], 20, 10000);
                        break;
                    case 8: startIntent(VALUES[8], 10, 10000);
                        break;
                    case 9: startIntent(VALUES[9], 99, 100000);
                        break;
                    case 10: startIntent(VALUES[10], 99, 250000);
                        break;
                    case 11: startIntent(VALUES[11], -1, -1);
                        break;
                    case 12: startIntent(VALUES[12], 99, 10000);
                        break;
                    case 13: startIntent(VALUES[13], 99, 50000);
                        break;
                    case 14: startIntent(VALUES[14], 1, 4000);
                        break;
                    case 15: startIntent(VALUES[15], 0, 500);
                        break;
                    case 16: startIntent(VALUES[16], 0, 500);
                        break;
                    case 17: startIntent(VALUES[17], 99, 10000);
                        break;
                    case 18: startIntent(VALUES[18], 10, 10000);
                        break;
                    case 19: startIntent(VALUES[19], 1, 4000);
                        break;
                    case 20: startIntent(VALUES[20], 180, 2000);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //Nothing happens if nothing is selected. Placed here to comply with interface
                //requests.
                return;
            }
        });

        //Listener for the about button. Contains the information about the app. Displays pop-up.
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String ABOUT_INFO = "Android application that teaches users the legal " +
                        "consequences for different user selected illegal activities.";
                Toast.makeText(getApplicationContext(), ABOUT_INFO, Toast.LENGTH_LONG).show();
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

        //Help on click listener, start new intent that contains the instructions
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Help.class));
            }
        });


    }

    /**
     * Starts the Results activity with varying punishment information based on the type of crime
     * that was selected.
     * Pre: crime != null
     *      years >= -1
     *      fine >= -1
     * Post: start activity sending in the Crime information
     * @param crime the name of the crime selected
     * @param years the number of years of imprisonment that will occur as a result of doing the
     *              crime
     * @param fine the fine that will occur as a result of doing the crime
     */
    private void startIntent(String crime, int years, int fine){
        Crime c = new Crime (crime, years, fine);
        Intent intent = new Intent(getApplicationContext(), Results.class);
        intent.putExtra("crime", c);
        startActivity(intent);
    }
}
