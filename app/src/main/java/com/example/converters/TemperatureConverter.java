package com.example.converters;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TemperatureConverter extends Fragment  implements View.OnClickListener {


    private TextView textView;

    public TemperatureConverter() {
        // Required empty public constructor
    }


    public void onClick(View v) {

        textView.setText("Hello World");

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_temperature_converter, container, false);

        textView = (TextView) view.findViewById(R.id.calculate);

        Button b = (Button)view.findViewById(R.id.calculate);
        b.setOnClickListener( this );


        return view;
    }

}
