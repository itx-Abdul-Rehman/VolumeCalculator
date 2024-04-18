package com.example.volumecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Prism extends AppCompatActivity {

    EditText base;
    EditText height;
    TextView volume;
    Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prism);


        base=findViewById(R.id.base);
        height=findViewById(R.id.height);
        calculate=findViewById(R.id.calculate);
        volume=findViewById(R.id.volume);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rad=base.getText().toString().trim();
                String heightCylinder=height.getText().toString();
                if(rad.isEmpty()){
                    base.setError(getString(R.string.enter_base));

                } else{
                    if(rad.matches(".*[a-zA-Z].*")){
                        base.setError(getString(R.string.enter_only_digits));
                    }else{
                        if(heightCylinder.isEmpty()){
                            height.setError(getString(R.string.enter_hight));
                        }else{
                            if(heightCylinder.matches(".*[a-zA-Z].*")){
                                height.setError(getString(R.string.enter_only_digits));
                            }else{
                                double base=Double.parseDouble(rad);
                                double height=Double.parseDouble(heightCylinder);
                                double res=base*height;
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