package com.example.converters;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class DistanceConverter extends Fragment  implements  OnClickListener {

    private String milesstring;
    private String kilometerstring;

    private Double miles;
    private Double kilometers;
    private final Double miletokilometer = 1.60934;

    private EditText distanceinMiles;
    private EditText distanceinKilometers;

    private static DecimalFormat df = new DecimalFormat("0.00");


    public DistanceConverter() {

        distanceinMiles = null;
        distanceinKilometers = null;
        milesstring = null;
        kilometerstring = null;

    }


    public void onClick(View v) {

        milesstring = distanceinMiles.getText().toString();
        kilometerstring = distanceinKilometers.getText().toString();

        if( milesstring.isEmpty() ) {

            if( !kilometerstring.isEmpty() ) {

                kilometers = Double.parseDouble(kilometerstring);
                miles = (kilometers / miletokilometer);
                distanceinMiles.setText(df.format(miles));
            }
        }

        else if( kilometerstring.isEmpty() ) {

            if( !milesstring.isEmpty() ) {

                miles = Double.parseDouble(milesstring);
                kilometers = (miles * miletokilometer);
                distanceinKilometers.setText(df.format(kilometers));

            }
        }
        else {

            miles = Double.parseDouble(milesstring);
            kilometers = (miles * miletokilometer);
            distanceinKilometers.setText(df.format(kilometers));

        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_distance_converter, container, false);

        distanceinMiles = (EditText) view.findViewById(R.id.distanceinMiles);
        distanceinKilometers = (EditText) view.findViewById(R.id.distanceinKilometer);

        Button b = (Button)view.findViewById(R.id.calculateButton);
        b.setOnClickListener( this );

        return view;

    }

}
