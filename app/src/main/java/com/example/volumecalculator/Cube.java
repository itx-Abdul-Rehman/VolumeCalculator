package com.example.volumecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cube extends AppCompatActivity {

    EditText egdeLength;
    TextView volume;
    Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

        egdeLength=findViewById(R.id.edgeLength);
        calculate=findViewById(R.id.calculate);
        volume=findViewById(R.id.volume);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edgeLength=egdeLength.getText().toString().trim();
                if(edgeLength.isEmpty()){
                    egdeLength.setError(getString(R.string.enter_edge_length));
                }else{
                    if(edgeLength.matches(".*[a-zA-Z].*")){
                        egdeLength.setError(getString(R.string.enter_only_digits));
                    }
                    double edge=Double.parseDouble(edgeLength);
                    double res=edge*edge*edge;
                    volume.setText( getString(R.string.volume)+res);
                    volume.setVisibility(View.VISIBLE);
                }

            }
        });


    }
}