package com.example.converters;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DistanceConverter extends Fragment  implements  OnClickListener{

    private TextView txtView;

    public DistanceConverter() {
        // Required empty public constructor
    }


    public void onClick(View v) {

        txtView.setText("Hello World");

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_distance_converter, container, false);

        /*txtView = (TextView) view.findViewById(R.id.calculate);

        Button b = (Button)view.findViewById(R.id.calculate);
        b.setOnClickListener( this );*/


        return view;
    }

}
