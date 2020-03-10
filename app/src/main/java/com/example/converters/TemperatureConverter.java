package com.example.converters;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TemperatureConverter extends Fragment  implements View.OnClickListener {


    private String f;
    private String c;

    private Double farenheit;
    private Double celcius;

    private EditText tempinfarenheit;
    private EditText tempincelcius;


    public TemperatureConverter() {

        tempinfarenheit = null;
        tempincelcius = null;
        f = null;
        c = null;

    }


    public void onClick(View v) {

        f = tempinfarenheit.getText().toString();
        c = tempincelcius.getText().toString();

        if( f.isEmpty() ) {

            if( !c.isEmpty() ) {

                celcius = Double.parseDouble(c);
                farenheit = ( celcius * (9.0 / 5.0) ) + 32;
                tempinfarenheit.setText(String.valueOf(farenheit));
            }
        }
        else {
            if( !f.isEmpty() ) {

                farenheit = Double.parseDouble(f);
                celcius = ((farenheit - 32) * (5.0 / 9.0));
                tempincelcius.setText(String.valueOf(celcius));

            }
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_temperature_converter, container, false);

        tempinfarenheit = (EditText) view.findViewById(R.id.farenheit);
        tempincelcius = (EditText) view.findViewById(R.id.celcius);

        Button b = (Button)view.findViewById(R.id.calculate);
        b.setOnClickListener( this );

        return view;
    }

}
