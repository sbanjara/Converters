package com.example.converters;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipCalculator extends Fragment  implements View.OnClickListener {

    private TextView outputView;
    private EditText billPercent;
    private EditText totalAmount;
    private EditText numPeople;
    private double percent;
    private int people;
    private double total;
    private String output;

    private static DecimalFormat df = new DecimalFormat("0.00");

    public TipCalculator() {

        outputView = null;
        billPercent = null;
        totalAmount = null;
        numPeople = null;
        output = null;
        percent = 0;
        people = 0;
        total = 0;

    }

    public void onClick(View v) {

        double tipAmount = 0;
        double totalPerPerson = 0;

        try {

            total = Double.parseDouble(totalAmount.getText().toString());
            percent = Double.parseDouble(billPercent.getText().toString());
            people = Integer.parseInt(numPeople.getText().toString());

            if(people == 0) {
                output = "INVALID ENTRY, Please enter a valid number!!";
            }
            else {
                tipAmount = ((percent / 100) * total) / people;
                totalPerPerson = (total / people) + tipAmount;
                output = "$" + df.format(totalPerPerson);
            }

        }

        catch(Exception e) {
            output = "INVALID ENTRY, Please enter a number!!";
        }

        outputView.setText(output);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_tip_calculator, container, false);

        outputView = (TextView) view.findViewById(R.id.output);
        billPercent = (EditText) view.findViewById(R.id.tipPercent);
        totalAmount = (EditText) view.findViewById(R.id.totalAmount);
        numPeople = (EditText) view.findViewById(R.id.numPeople);

        Button b = (Button)view.findViewById(R.id.calculate);
        b.setOnClickListener( this );

        return view;

    }

}
