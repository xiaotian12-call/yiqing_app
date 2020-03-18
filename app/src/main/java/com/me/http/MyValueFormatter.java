package com.me.http;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.DecimalFormat;

public class MyValueFormatter extends ValueFormatter{
    private final DecimalFormat mFormat;
    private String suffix;
    private String [] str;

    public MyValueFormatter(String suffix,String [] str) {
        mFormat = new DecimalFormat("0000");
        this.suffix = suffix;
        this.str = str;
    }

    @Override
    public String getFormattedValue(float value) {
        return mFormat.format(value) + suffix;
    }

    @Override
    public String getAxisLabel(float value, AxisBase axis) {
        if (axis instanceof XAxis) {
            return str[(int)value];
        } else if (value > 0) {
            return mFormat.format(value) + suffix;
        } else {
            return mFormat.format(value);
        }
    }
}