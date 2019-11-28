package com.example.bmicalculator

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calBtn.setOnClickListener(){
            try {
                val bmi = calculate();

                if (bmi.toDouble() >= 25.00) {
                    bmiText.text = "BMI : %.2f (Overweight)".format(bmi);
                    imageView.setImageResource(R.drawable.over);
                } else if (bmi.toDouble() <= 18.50) {
                    bmiText.text = "BMI : %.2f (Underweight)".format(bmi);
                    imageView.setImageResource(R.drawable.under);
                } else {
                    bmiText.text = "BMI : %.2f (Normal)".format(bmi);
                    imageView.setImageResource(R.drawable.normal);
                }
            }catch(e:Exception){
                val toast:Toast = Toast.makeText(this, "Weight or Height cannot be empty!!!", Toast.LENGTH_SHORT);

                toast.setGravity(Gravity.CENTER,0,0);

                toast.show();
            }
        }

        resetBtn.setOnClickListener(){
            weightText.text.clear();
            heightText.text.clear();
            imageView.setImageResource(R.drawable.normal);
        }
    }

    public fun calculate():Double{

            val height = heightText.text.toString().toDouble();
            val weight = weightText.text.toString().toDouble();
            val bmi = weight / Math.pow(height / 100, 2.00);

        return bmi;
    }


}
