package com.example.kunlinlee.mpandroidchart

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private val btn_barchart_click = View.OnClickListener{
        val intent = Intent(this,barchart::class.java)
        startActivity(intent)
    }

    private val btn_linechart_click = View.OnClickListener{
        val intent = Intent(this,linechart::class.java)
        startActivity(intent)
    }

    private val btn_pie_click = View.OnClickListener{
        val intent = Intent(this,piechart::class.java)
        startActivity(intent)
    }


    private val btn_ScatterChart_click = View.OnClickListener{
        val intent = Intent(this,ScatterChart::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_barchart.setOnClickListener(btn_barchart_click)
        btn_linechart.setOnClickListener(btn_linechart_click)
        btn_pie.setOnClickListener(btn_pie_click)
        btn_ScatterChart.setOnClickListener(btn_ScatterChart_click)

    }

}
