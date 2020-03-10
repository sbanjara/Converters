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


public class DistanceConverter extends Fragment  implements  OnClickListener {

    private String m;
    private String k;

    private Double miles;
    private Double kilometers;
    private final Double miletokilometer = 1.60934;

    private EditText distanceinMiles;
    private EditText distanceinKilometers;


    public DistanceConverter() {

        distanceinMiles = null;
        distanceinKilometers = null;
        m = null;
        k = null;

    }


    public void onClick(View v) {

        m = distanceinMiles.getText().toString();
        k = distanceinKilometers.getText().toString();

        if( m.isEmpty() ) {

            if( !k.isEmpty() ) {

                kilometers = Double.parseDouble(k);
                miles = (kilometers / miletokilometer);
                distanceinMiles.setText(String.valueOf(miles));
            }
        }
        else {
            if( !m.isEmpty() ) {

                miles = Double.parseDouble(m);
                kilometers = (miles * miletokilometer);
                distanceinKilometers.setText(String.valueOf(kilometers));

            }
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
