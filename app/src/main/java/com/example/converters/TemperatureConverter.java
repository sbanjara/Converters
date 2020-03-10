package com.example.converters;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;


public class TemperatureConverter extends Fragment  implements View.OnClickListener {


    private String fahrenheitstring;
    private String celsiusstring;

    private Double fahrenheit;
    private Double celsius;

    private EditText tempinfahrenheit;
    private EditText tempincelsius;

    private static DecimalFormat df = new DecimalFormat("0.00");


    public TemperatureConverter() {

        tempinfahrenheit = null;
        tempincelsius = null;
        fahrenheitstring = null;
        celsiusstring = null;

    }


    public void onClick(View v) {

        fahrenheitstring = tempinfahrenheit.getText().toString();
        celsiusstring = tempincelsius.getText().toString();

        if( fahrenheitstring.isEmpty() ) {

            if( !celsiusstring.isEmpty() ) {

                celsius = Double.parseDouble(celsiusstring);
                fahrenheit = ( celsius * (9.0 / 5.0) ) + 32;
                tempinfahrenheit.setText(df.format(fahrenheit));
            }
        }

        else if( celsiusstring.isEmpty() ) {

            if( !fahrenheitstring.isEmpty() ) {

                fahrenheit = Double.parseDouble(fahrenheitstring);
                celsius = ((fahrenheit - 32) * (5.0 / 9.0));
                tempincelsius.setText(df.format(celsius));

            }
        }

        else {

            fahrenheit = Double.parseDouble(fahrenheitstring);
            celsius = ((fahrenheit - 32) * (5.0 / 9.0));
            tempincelsius.setText(df.format(celsius));

        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_temperature_converter, container, false);

        tempinfahrenheit = (EditText) view.findViewById(R.id.fahrenheit);
        tempincelsius = (EditText) view.findViewById(R.id.celsius);

        Button b = (Button)view.findViewById(R.id.calculate);
        b.setOnClickListener( this );

        return view;
    }

}
