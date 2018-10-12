package com.example.kunlinlee.mpandroidchart

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import kotlinx.android.synthetic.main.activity_linechart.*
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.components.YAxis





class linechart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linechart)

        val linechart = bar_line
        val entries = ArrayList<Entry>()
        entries.add(Entry(0F,4F))
        entries.add(Entry(1f,1f))
        entries.add(Entry(2f,2f))
        entries.add(Entry(3f,4f))
        entries.add(Entry(5f,10f))

        val dataset = LineDataSet(entries,"Customized values")
        dataset.color = ContextCompat.getColor(this,R.color.colorPrimary)
        dataset.valueTextColor = ContextCompat.getColor(this,R.color.colorPrimaryDark)

        val xAxis = linechart.xAxis
            xAxis.position = XAxis.XAxisPosition.BOTTOM
        val months = arrayOf("Jan", "Feb", "Mar", "Apr","May","June")
        val formatter = IAxisValueFormatter{
            value, axis ->   months[value.toInt()]
        }
        xAxis.granularity = 1f
        xAxis.valueFormatter = formatter

        val yAxisRight = linechart.axisRight
        yAxisRight.setEnabled(false)

        val yAxisLeft = linechart.axisLeft
        yAxisLeft.setGranularity(1f)

        // Setting Data
        val data = LineData(dataset)
        linechart.setData(data)
        linechart.animateX(2500)
        //refresh
        linechart.invalidate()
    }
}
