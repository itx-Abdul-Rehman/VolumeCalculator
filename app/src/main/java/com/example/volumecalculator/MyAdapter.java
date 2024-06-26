package com.example.volumecalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Shape> {

    private ArrayList<Shape> shapeArrayList=new ArrayList<>();
    private Context context;

    public MyAdapter( ArrayList<Shape> shapeArrayList, Context context) {
        super(context, R.layout.grid_item_layout,shapeArrayList);
        this.shapeArrayList = shapeArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Shape shape=getItem(position);
        ViewHolder viewHolder=new ViewHolder();
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.grid_item_layout,parent,false);
            viewHolder.imageView=(ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.textView=(TextView) convertView.findViewById(R.id.vName);
            convertView.setTag(viewHolder);

        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(shape.getShapeName());
        viewHolder.imageView.setImageResource(shape.getShapeImage());

        return convertView;
    }

    static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
