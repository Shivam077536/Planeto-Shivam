package com.example.planeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_planet_detail.*

class PlanetDetail : AppCompatActivity() {
    private lateinit var obj:planetData
    private  var planetImg:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_detail)
        obj=intent.getParcelableExtra("planet")!!
        planetImg=intent.getIntExtra("planetImage",-1)
        setDaata(obj,planetImg!!)

    }
    private fun setDaata(obj:planetData,planetImg:Int){
        title_info.text=obj.title
        distance_info.text=obj.distance+"m km"
        gravity_info.text=obj.gravity+" m/ss"
        overview_info.text= obj.overview
        galaxy_info.text=obj.galaxy
        planet_img_info.setImageResource(planetImg)


    }
}