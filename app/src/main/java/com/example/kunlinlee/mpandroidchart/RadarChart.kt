package com.example.kunlinlee.mpandroidchart

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
import com.github.mikephil.charting.components.Legend
import kotlinx.android.synthetic.main.activity_radarchart.*


class RadarChart : AppCompatActivity() {
    lateinit var radarChart : com.github.mikephil.charting.charts.RadarChart
    private var radarData: RadarData?= null
    //X轴数据
    private val xDatas = ArrayList<String>()
    //Y轴数据
    private val yDatas1 = ArrayList<RadarEntry>()
    private val yDatas2 = ArrayList<RadarEntry>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radarchart)

         radarChart = bar_radarchart

        for (i in 0..11) {
            xDatas.add("属性" + (i + 1))
            yDatas1.add(RadarEntry((Math.random() * 10).toFloat(), i.toFloat()))
            yDatas2.add(RadarEntry((Math.random() * 10).toFloat(), i.toFloat()))
        }

        radarData = getRadarData()


        showRadarChart(radarChart, radarData!!)
    }

    private fun getRadarData() :RadarData{
        val radarDataSet1 = RadarDataSet(yDatas1, "第一组属性")
        radarDataSet1.color = Color.rgb(255, 99, 71)//设置雷达图外边框颜色
        radarDataSet1.fillColor = Color.rgb(255, 174, 185)//设置雷达图内部颜色填充
        radarDataSet1.setDrawFilled(true)//填充
        radarDataSet1.fillAlpha = 180//设置透明度
        radarDataSet1.lineWidth = 2f//设置雷达图边界线宽
        radarDataSet1.isDrawHighlightCircleEnabled = true
        radarDataSet1.setDrawHighlightIndicators(false)

        val radarDataSet2 = RadarDataSet(yDatas2, "第二组属性")
        radarDataSet2.color = Color.rgb(121, 162, 175)
        radarDataSet2.fillColor = Color.rgb(147, 112, 219)
        radarDataSet2.setDrawFilled(true)
        radarDataSet2.fillAlpha = 180
        radarDataSet2.lineWidth = 2f
        radarDataSet2.isDrawHighlightCircleEnabled = true
        radarDataSet2.setDrawHighlightIndicators(false)

        //填充两组Y轴数据
        val radarDataSets = ArrayList<IRadarDataSet>()
        radarDataSets.add(radarDataSet1)
        radarDataSets.add(radarDataSet2)

        return RadarData(radarDataSets)
    }

    private fun showRadarChart(radarChart1:RadarChart, radarData: RadarData) {
        //描述

        //radarChart1.description(Description("雷达图"))
        //可旋转
        radarChart1.setRotationEnabled(true)
        //Description位置
      //  radarChart1.description.position = (750f,70f)
      //  radarChart1.description.position(750f, 70f)
        //Description字体
     //   radarChart1.setDescriptionTextSize(50)
        //花蜘蛛网
        radarChart1.setDrawWeb(true)
        //设置背景颜色
        radarChart1.setBackgroundColor(Color.rgb(255, 102, 0))
        //设置Web主干颜色
        radarChart1.setWebLineWidth(1f)
        //设置Web主干线宽
        radarChart1.setWebColor(Color.rgb(255, 255, 0))
        //设置Web支线颜色
        radarChart1.setWebColorInner(Color.rgb(255, 255, 0))
        //设置Web支线线宽
        radarChart1.setWebLineWidthInner(1f)

        //设置图例
        val legend = radarChart.getLegend()
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART_INSIDE)//图例位置
        legend.setForm(Legend.LegendForm.CIRCLE)//图例颜色块形状

        radarChart.setData(radarData)//填充数据
        radarChart.invalidate()//刷新界面
    }


}
