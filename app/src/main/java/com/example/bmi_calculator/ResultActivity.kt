package com.example.bmi_calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.round

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        //BMI 계산
        var value = weight / (height/100.0).pow(2.0)
        value = round(value*10)/10

        var resultText = ""
        var resImage = 0
        var resColor = 0

        if(value < 18.5) {
            resultText = "Underweight"
            resImage = R.drawable.img_lv1
            resColor = Color.YELLOW
        } else if (value >= 18.9 && value < 24.9) {
            resultText = "Normal"
            resImage = R.drawable.img_lv2
            resColor = Color.GREEN
        } else if (value >= 24.9 && value < 29.9) {
            resultText = "Overweight"
            resImage = R.drawable.img_lv3
            resColor = Color.YELLOW
        } else if(value >= 29.9 && value < 34.9) {
            resultText = "Obese Class I"
            resImage = R.drawable.img_lv4
            resColor = Color.MAGENTA
        } else if(value >= 34.9 && value < 40.0) {
            resultText = "Obese Class II"
            resImage = R.drawable.img_lv5
            resColor = Color.RED
        } else {
            resultText = "Obese Class III"
            resImage = R.drawable.img_lv6
            resColor = Color.BLACK
        }

        val tv_resValue = findViewById<TextView>(R.id.tv_resValue)
        val tv_resText = findViewById<TextView>(R.id.tv_resText)
        val iv_image = findViewById<ImageView>(R.id.iv_image)
        val btn_back = findViewById<Button>(R.id.btn_back)

        tv_resValue.text = value.toString()
        tv_resText.text = resultText
        iv_image.setImageResource(resImage)
        tv_resText.setTextColor(resColor)


        btn_back.setOnClickListener {
            finish()
        }



    }
}