package com.example.kunlinlee.mpandroidchart

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.ScatterData
import com.github.mikephil.charting.data.ScatterDataSet
import kotlinx.android.synthetic.main.activity_scatter_chart.*

class ScatterChart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scatter_chart)
        val scatterChart = bar_ScatterChart
        val entries = ArrayList<Entry>()
        entries.add(Entry(1f,10f))
        entries.add(Entry(2f,20f))
        entries.add(Entry(3f,15f))
        entries.add(Entry(4f,25f))
        entries.add(Entry(5f,11f))
        entries.add(Entry(6f,21f))
        entries.add(Entry(7f,12f))
        entries.add(Entry(8f,22f))
        entries.add(Entry(9f,13f))

        val dataSet = ScatterDataSet(entries,"label")
        val data = ScatterData(dataSet)
        scatterChart.data = data
        scatterChart.invalidate()
        scatterChart.xAxis.position =XAxis.XAxisPosition.BOTTOM
        scatterChart.axisRight.isEnabled = false
        scatterChart.axisLeft.axisMinimum=0f




    }
}
