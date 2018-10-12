package com.example.kunlinlee.mpandroidchart

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IValueFormatter
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import kotlinx.android.synthetic.main.activity_barchart.*

class barchart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barchart)

        val chart = bar_chart
        chart.data = BarData(getBarData())
        chart.axisLeft.apply{
            axisMinimum = 0f
            axisMaximum = 100f
            labelCount = 5
            setDrawTopYLabelEntry(true)
            setValueFormatter{
                value, axis ->""+value.toInt()
            }
        }
        chart.axisRight.apply {
            setDrawTopYLabelEntry(true)
            setDrawZeroLine(false)
            setDrawGridLines(false)
            setDrawLabels(false)
        }
        val labels = arrayOf("","國文","數學","英文")
        chart.xAxis.apply {
            valueFormatter = IndexAxisValueFormatter(labels)
            labelCount = 3 //表示させるラベル数
            position = XAxis.XAxisPosition.BOTTOM
            setDrawLabels(true)
            setDrawGridLines(false)
            setDrawAxisLine(true)
        }
        chart.apply {
            setDrawValueAboveBar(true)
            description.isEnabled = false
            isClickable = false
            legend.isEnabled = false
            setScaleEnabled(false)
            animateY(1200, Easing.EasingOption.Linear)
        }
    }


    private fun getBarData(): ArrayList<IBarDataSet>? {
        val entries = ArrayList<BarEntry>().apply {
            add(BarEntry(1f, 60f))
            add(BarEntry(2f, 80f))
            add(BarEntry(3f, 70f))

        }

        val dataSet = BarDataSet(entries, "bar").apply {
            //整数で表示
            valueFormatter = IValueFormatter { value, _, _, _ -> "" + value.toInt() }
            //ハイライトさせない
            isHighlightEnabled = false
            //Barの色をセット
            setColors(intArrayOf(R.color.material_blue, R.color.material_green, R.color.material_yellow), this@barchart)
        }
        val bars = ArrayList<IBarDataSet>()
        bars.add(dataSet)
        return bars
    }
}
