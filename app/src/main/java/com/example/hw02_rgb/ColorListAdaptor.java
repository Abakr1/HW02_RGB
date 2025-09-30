package com.example.hw02_rgb;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorListAdaptor extends BaseAdapter
{
    Context context;

    ArrayList<ColorInfo> listOfColors;
    public ColorListAdaptor(Context c,ArrayList<ColorInfo> lc)
    {
        context = c;
        listOfColors = lc;

    }

    @Override
    public int getCount()
    {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int i)
    {
        return listOfColors.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.custom_cell, null);
        }
        //find the GUI elements in my custom cell
        //textviews instead of edit texts, not editing listview
        TextView red = view.findViewById(R.id.et_cc_red);
        TextView green = view.findViewById(R.id.et_cc_green);
        TextView blue = view.findViewById(R.id.et_cc_blue);
        TextView hexRep = view.findViewById(R.id.et_cc_hexRep);

        //get data for this particular color from the color list
        //i can access different elements based off the i value that is passed to this function
        ColorInfo col = listOfColors.get(i);




        //set GUI

        red.setText(String.valueOf(col.getRed()));
        green.setText(String.valueOf(col.getGreen()));
        blue.setText(String.valueOf(col.getBlue()));
        hexRep.setText(String.valueOf(col.getHex()));


        return view;
    }

    private boolean isDarkColor(int color)
    {
        double luminance = (0.299 * Color.red(color) + 0.587 * Color.green(color) + Color.blue(color));
        return luminance < 128;
    }
}
