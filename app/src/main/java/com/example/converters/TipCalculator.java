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


/**
 * A simple {@link Fragment} subclass.
 */
public class TipCalculator extends Fragment  implements View.OnClickListener {

    private TextView outputView;
    private TextInputEditText billAmount;
    private String totalAmount;

    public TipCalculator() {
        outputView = null;
        billAmount = null;
        totalAmount = null;

    }


    public void onClick(View v) {

        outputView.setText(totalAmount);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tip_calculator, container, false);

        billAmount = (TextInputEditText) view.findViewById(R.id.totalAmount);

        totalAmount = (billAmount).toString();

        outputView = (TextView) view.findViewById(R.id.output);

        Button b = (Button)view.findViewById(R.id.calculate);
        b.setOnClickListener( this );


        return view;

    }

}
