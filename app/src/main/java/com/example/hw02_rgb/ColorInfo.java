package com.example.hw02_rgb;

public class ColorInfo
{
    //red green blue
    private int red;
    private int green;
    private int blue;

    //constructor
    public ColorInfo()
    {

    }

    //overloaded constructor
    public ColorInfo(int r, int g, int b)
    {
        red = r;
        green = g;
        blue = b;

    }

    //getters
    public int getRed()
    {
        return red;
    }

    public int getGreen()
    {
        return green;
    }

    public int getBlue()
    {
        return blue;
    }

    //setters

    public void setRed(int red)
    {
        this.red = red;
    }

    public void setGreen(int green)
    {
        this.green = green;
    }

    public void setBlue(int blue)
    {
        this.blue = blue;
    }

    public String getHex()
    {
        return String.format("#%02X%02X%02X", red, green, blue);
    }
}
