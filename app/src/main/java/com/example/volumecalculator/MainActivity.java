package com.example.volumecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridview);

        Shape shape = new Shape(R.drawable.ic_launcher_background, "Sphere");
        Shape shape2 = new Shape(R.drawable.ic_launcher_background, "Cylinder");
        Shape shape3 = new Shape(R.drawable.ic_launcher_background, "Cube");
        Shape shape4 = new Shape(R.drawable.ic_launcher_background, "Prism");

        ArrayList<Shape> shapeArrayList = new ArrayList<>();
        shapeArrayList.add(shape);
        shapeArrayList.add(shape2);
        shapeArrayList.add(shape3);
        shapeArrayList.add(shape4);

        MyAdapter myAdapter = new MyAdapter(shapeArrayList, this);
        gridView.setAdapter(myAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent;
                if(position==0){
                    intent=new Intent(getApplicationContext(), Sphere.class);
                    startActivity(intent);
                }else if(position==1){
                    intent=new Intent(getApplicationContext(), Cylinder.class);
                    startActivity(intent);
                } else if (position==2) {
                    intent=new Intent(getApplicationContext(), Cube.class);
                    startActivity(intent);
                } else if (position==3) {
                    intent=new Intent(getApplicationContext(), Prism.class);
                    startActivity(intent);
                }
            }
        });

    }
}