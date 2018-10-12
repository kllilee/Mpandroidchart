package com.example.kunlinlee.mpandroidchart

import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_piechart.*

class piechart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_piechart)

        val piechart = bar_pie
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(22F,"aaa"))
        entries.add(PieEntry(78F,"bbb"))


        val colors = ArrayList<Int>()
        colors.add(resources.getColor(R.color.colorPrimaryDark))
        colors.add(resources.getColor(R.color.colorPrimary))

        val dataSet =PieDataSet(entries,"label")
        dataSet.setColors(colors)

        val pieData = PieData(dataSet)
        pieData.setDrawValues(true)

        piechart.setData(pieData)
        piechart.invalidate()


    }
}
