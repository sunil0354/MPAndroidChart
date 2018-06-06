package com.app.mpandroidchart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private LineChart linechart;
    String TAG="tag";
    public int day;
    Button Time,Date,Month;
    private ArrayList<String> mDateList,mRevenueList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate: "+getCount("1988-07-29 12:12:12") );
        linechart=findViewById(R.id.chart1);
        Time=findViewById(R.id.Time);
        Date=findViewById(R.id.Date);
        Month=findViewById(R.id.Month);
        Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DayAxisValueFormatter.day=1;
                startActivity(new Intent(MainActivity.this,MainActivity.class));
                finish();
            }
        });
        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DayAxisValueFormatter.day=2;
                startActivity(new Intent(MainActivity.this,MainActivity.class));
                finish();
            }
        });
        Month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DayAxisValueFormatter.day=3;
                startActivity(new Intent(MainActivity.this,MainActivity.class));
                finish();
            }
        });
        setDatatest(mDateList,mRevenueList);
    }

    private void setDatatest(ArrayList<String> dateList,ArrayList<String> revenueList) {
        ArrayList<Entry> entries = new ArrayList<>();
//        entries.add(new Entry(count, range));
        entries.add(new Entry(Integer.parseInt(getCount("2018-01-01 12:00:12")),50));
        entries.add(new Entry(Integer.parseInt(getCount("2018-02-02 13:00:12")),100));
        entries.add(new Entry(Integer.parseInt(getCount("2018-03-03 14:00:12")),50));
        entries.add(new Entry(Integer.parseInt(getCount("2018-04-04 15:00:12")),150));
        LineDataSet dataSet = new LineDataSet(entries,"");
        LineData lineData = new LineData(dataSet);
//        //Custom dateset points
//        dataSet.setColors(getResources().getColor(R.color.colorBlueGreenLightLight));
//        dataSet.setValueTextColor(getResources().getColor(R.color.colorWhite));//change text color of points
//        dataSet.setDrawValues(false);//disable data value point text
//        dataSet.setColor(getResources().getColor(R.color.colorWhite));//line color
//        dataSet.setCircleColor(getResources().getColor(R.color.colorWhite));//circle color
//        dataSet.setCircleColorHole(getResources().getColor(R.color.colorBlueGreen));//inside circle color
//        dataSet.setCircleRadius(5f);//change circle radious
//        dataSet.setCircleHoleRadius(3);//change inner circle radius
//        dataSet.setLineWidth(2f);//line width
//        //Custom line graph
//        linechart.setTouchEnabled(false);//to remove on touch
//        XAxis xAxis = linechart.getXAxis();
//        if (((BaseActivity)getActivity()) != null) {
//            xAxis.setTypeface(((BaseActivity)getActivity()).setTypeface());//font style of x axis
//        }
//        xAxis.setGridColor(getResources().getColor(R.color.colorBlueGreenLightLight));//change x axis line color
//        xAxis.setGranularity(1);//vertical line
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//position of x axis text
//        xAxis.setValueFormatter(new DayAxisValueFormatter());
//        YAxis yAxisRight = linechart.getAxisRight();
//        yAxisRight.setEnabled(false);//disable right side y axis text
//        YAxis yAxis = linechart.getAxisLeft();
//        if (((BaseActivity)getActivity()) != null) {
//            yAxis.setTypeface(((BaseActivity)getActivity()).setTypeface());//font style of y axis
//        }
////        yAxis.setGridColor(getResources().getColor(R.color.colorBlueGreenLightLight));////change y axis line color
////        linechart.getAxisLeft().setDrawGridLines(false);//remove horizontal line
//        linechart.getXAxis().setDrawGridLines(false);//remove vertical line
//        linechart.getAxisLeft().setTextColor(getResources().getColor(R.color.colorBlueGreenLightLight));//change text color of y axis
//        linechart.getXAxis().setTextColor(getResources().getColor(R.color.colorBlueGreenLightLight));//change text color of x axis
//        linechart.getLegend().setEnabled(false);//disable the bottom box
//        linechart.getDescription().setEnabled(false);//disable the description label text
        linechart.setData(lineData);
    }

    private String getCount(String value){
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =null;
        try {date = format.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (DayAxisValueFormatter.day==1){
            return (String) DateFormat.format("HH",   date);
        }else if(DayAxisValueFormatter.day==2){
            return String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        }else{
            return (String) DateFormat.format("MM",   date);
        }
    }
}
