package com.example.hw02_rgb;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    TextView et_j_red;
    TextView et_j_green;
    TextView et_j_blue;
    TextView et_j_hexRep;
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;
    Button btn_j_saveColor;
    ListView lv_j_listOfColors;

    ArrayList<ColorInfo> listOfColors;
    ColorListAdaptor adapter;



    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        et_j_red        = findViewById(R.id.et_v_red);
        et_j_green      = findViewById(R.id.et_v_green);
        et_j_blue       = findViewById(R.id.et_v_blue);
        et_j_hexRep     = findViewById(R.id.et_v_hexRep);
        sb_j_red        = findViewById(R.id.sb_v_red);
        sb_j_green      = findViewById(R.id.sb_v_green);
        sb_j_blue       = findViewById(R.id.sb_v_blue);
        btn_j_saveColor = findViewById(R.id.btn_v_saveColor);
        lv_j_listOfColors  = findViewById(R.id.lv_v_listOfColors);

        //initialze list and adapter
        listOfColors = new ArrayList<>();
        adapter = new ColorListAdaptor(this,listOfColors);
        lv_j_listOfColors.setAdapter(adapter);

        lv_j_listOfColors.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                loadColor(position);
            }
        });



        //set seekbar listeners
        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        };

        sb_j_red.setOnSeekBarChangeListener(listener);
        sb_j_green.setOnSeekBarChangeListener(listener);
        sb_j_blue.setOnSeekBarChangeListener(listener);

        btn_j_saveColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                saveColor();
            }
        });

        //initialze color
        updateColor();

    }



    private void updateColor()
    {
        int red = sb_j_red.getProgress();
        int green = sb_j_green.getProgress();
        int blue = sb_j_blue.getProgress();

        String hexColor = String.format("#%02X%02X%02X", red, green, blue);
        et_j_hexRep.setText(hexColor);
        View root = findViewById(R.id.main);
        root.setBackgroundColor(Color.rgb(red,green,blue));
        updateTextColorContrast(red, green, blue);

    }

    private void updateTextColorContrast(int red, int green, int blue)
    {
        int brightness = (red + green + blue) / 3;
        int textColor  = (brightness < 128) ? Color.WHITE : Color.BLACK;

        //this only applies for the hexrep, needed for all words
        //if(brightness < 128)
        //{
      //      et_j_hexRep.setTextColor(Color.WHITE);
       // }
      //  else
      //  {
        //    et_j_hexRep.setTextColor(Color.BLACK);
      //  }

        et_j_red.setTextColor(textColor);
        et_j_green.setTextColor(textColor);
        et_j_blue.setTextColor(textColor);
        et_j_hexRep.setTextColor(textColor);
    }

    private void saveColor()
    {
        int red   = sb_j_red.getProgress();
        int green = sb_j_green.getProgress();
        int blue  = sb_j_blue.getProgress();

        ColorInfo newColor = new ColorInfo(red, green, blue);
        listOfColors.add(newColor);
        adapter.notifyDataSetChanged();

        //reset ui
        resetSeekBars();
    }

    private void resetSeekBars()
    {
        sb_j_red.setProgress(0);
        sb_j_green.setProgress(0);
        sb_j_blue.setProgress(0);

        updateColor();
    }

    private void registerButtonClickEvent()
    {
        btn_j_saveColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                addColorToList();
            }
        });
    }

    private void addColorToList()
    {
        //create a new color object
        ColorInfo colorInfoToAdd = new ColorInfo();


        listOfColors.add(colorInfoToAdd);
    }

    private void loadColor(int position)
    {
        ColorInfo color = listOfColors.get(position);
        sb_j_red.setProgress(color.getRed());
        sb_j_green.setProgress(color.getGreen());
        sb_j_blue.setProgress(color.getBlue());
        //call update color to update
        updateColor();
    }

    private void setOnClickListener(View.OnClickListener onClickListener)
    {

    }
}