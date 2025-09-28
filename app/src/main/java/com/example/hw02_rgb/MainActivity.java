package com.example.hw02_rgb;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    EditText et_j_red;
    EditText et_j_green;
    EditText et_j_blue;
    EditText et_j_hexRep;
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;
    Button btn_j_saveColor;
    ListView lv_j_colorList;


    @SuppressLint("WrongViewCast")
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
        lv_j_colorList  = findViewById(R.id.lv_v_savedColors);

        






    }
}