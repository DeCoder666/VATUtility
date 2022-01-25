package com.eyaldev.vatutility;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LineChart mRevenueChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the graph
        createGraph();

        //TODO: Link  to AddTransaction activity

    }

    //Creates the revenue graph displayed on the homepage. using MPAndroidChart
    private void createGraph(){
        mRevenueChart = findViewById(R.id.linechart); //Chart for displaying monthly revenue

        ArrayList<Entry> yValues = new ArrayList<Entry>();

        yValues.add(new Entry(1,6780));
        yValues.add(new Entry(2,6847));
        yValues.add(new Entry(3,6244));
        yValues.add(new Entry(4,6753));
        yValues.add(new Entry(5,3990));
        yValues.add(new Entry(6,5720));

        LineDataSet revenueSet = new LineDataSet(yValues, "הכנסה");

//        revenueSet.setFillAlpha(110);
//
//        mRevenueChart.getXAxis().setDrawGridLines(false);
//        mRevenueChart.setDrawGridBackground(false);
//        mRevenueChart.setDrawBorders(false);
//        mRevenueChart.getLegend().setEnabled(false);
//        mRevenueChart.setTouchEnabled(false);
//        mRevenueChart.setAutoScaleMinMaxEnabled(true);
//        mRevenueChart.setScaleEnabled(true);
//        mRevenueChart.setPinchZoom(false);

        revenueSet.setColor(Color.WHITE);
        revenueSet.setLineWidth(3f);
        revenueSet.setValueTextSize(10f);
        revenueSet.setValueTextColor(Color.WHITE);

        mRevenueChart.setDrawGridBackground(false);
        mRevenueChart.setDrawBorders(false);
        mRevenueChart.getLegend().setEnabled(false);
        mRevenueChart.setAutoScaleMinMaxEnabled(true);
        mRevenueChart.setTouchEnabled(true);
        mRevenueChart.setDragEnabled(true);
        mRevenueChart.setScaleEnabled(true);
        mRevenueChart.setPinchZoom(true);
        mRevenueChart.setDoubleTapToZoomEnabled(false);
        mRevenueChart.setBackgroundColor(Color.TRANSPARENT);
        mRevenueChart.getAxisRight().setEnabled(false);
        mRevenueChart.getDescription().setEnabled(false);

        mRevenueChart.getXAxis().setLabelCount(6, true);
        mRevenueChart.getXAxis().setAxisMinimum(1);
        mRevenueChart.getXAxis().setAxisMaximum(6);

        final YAxis yAxis = mRevenueChart.getAxisLeft();
        yAxis.setLabelCount(5,true);
        yAxis.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        yAxis.setTextColor(Color.WHITE);
        yAxis.setGridColor(Color.argb(102,255,255,255));
        yAxis.setAxisLineColor(Color.TRANSPARENT);

        final XAxis xAxis = mRevenueChart.getXAxis();
        xAxis.setDrawLimitLinesBehindData(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.WHITE);
        xAxis.disableGridDashedLine();
        xAxis.setDrawGridLines(false);
        xAxis.setGridColor(Color.parseColor("#31BBAB"));
        xAxis.setAxisLineColor(Color.TRANSPARENT);
//        xAxis.setValueFormatter(new TimestampValueFormatter());
        xAxis.setAvoidFirstLastClipping(true);
        xAxis.setSpaceMin(10f);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(revenueSet);

        LineData data = new LineData(dataSets);

        mRevenueChart.setData(data);
    }
}