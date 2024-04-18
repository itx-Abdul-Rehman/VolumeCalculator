package com.example.volumecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cylinder extends AppCompatActivity {

    EditText radius;
    EditText height;
    TextView volume;
    Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);


        radius=findViewById(R.id.radius);
        height=findViewById(R.id.height);
        calculate=findViewById(R.id.calculate);
        volume=findViewById(R.id.volume);


        calculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String rad=radius.getText().toString().trim();
                String heightCylinder=height.getText().toString();
                if(rad.isEmpty()){
                    radius.setError(getString(R.string.enter_radius));

                } else{
                    if(rad.matches(".*[a-zA-Z].*")){
                       radius.setError(getString(R.string.enter_only_digits));
                    }else{
                        if(heightCylinder.isEmpty()){
                            height.setError(getString(R.string.enter_hight));
                        }else{
                            if(heightCylinder.matches(".*[a-zA-Z].*")){
                                height.setError(getString(R.string.enter_only_digits));
                            }else{
                                double radius=Double.parseDouble(rad);
                                double height=Double.parseDouble(heightCylinder);
                                double res=Math.PI*radius*radius*height;
                                volume.setText(getString(R.string.volume)+res);
                                volume.setVisibility(View.VISIBLE);
                            }
                        }

                    }

                }

            }
        });

    }
}