package com.example.sensorsexample

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var sensorManager: SensorManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView2.visibility = View.GONE

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val mList: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        for (i in 1 until mList.size) {
            textView2.visibility = View.VISIBLE
            textView2.append(
                """
            
            ${mList[i].name}
            ${mList[i].vendor}
            ${mList[i].version}
            """.trimIndent()
            )
        }

    }


}