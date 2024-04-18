package com.example.volumecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Sphere extends AppCompatActivity {

    EditText radius;
    TextView volume;
    Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        radius=findViewById(R.id.radius);
        calculate=findViewById(R.id.calculate);
        volume=findViewById(R.id.volume);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rad=radius.getText().toString().trim();
                if(rad.isEmpty()){
                    radius.setError(getString(R.string.enter_radius));
                }else{
                    if(rad.matches(".*[a-zA-Z].*")){
                        radius.setError(getString(R.string.enter_only_digits));
                    }else{
                        double radius=Double.parseDouble(rad);
                        double res=(1.333333333333333)*(Math.PI*(radius*radius*radius));
                        volume.setText(getString(R.string.volume)+res);
                        volume.setVisibility(View.VISIBLE);
                    }


                }

            }
        });


    }
}