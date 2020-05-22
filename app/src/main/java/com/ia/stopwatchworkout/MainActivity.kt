package com.ia.stopwatchworkout

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val medium = Typeface.createFromAsset(assets, "fonts/Roboto.ttf")

        //load animation
        val atg = AnimationUtils.loadAnimation(this, R.anim.atg)
        val desc = AnimationUtils.loadAnimation(this, R.anim.description)
        val timeismoney = AnimationUtils.loadAnimation(this, R.anim.timeismoney)

        //active animations
        img_logo.startAnimation(atg)
        txtWelcome.startAnimation(desc)
        txtDescription.startAnimation(desc)
        txttimeismoney.startAnimation(desc)
        btn_getStarted.startAnimation(timeismoney)

        txtWelcome.setTypeface(medium)
        txtDescription.setTypeface(medium)
        txttimeismoney.setTypeface(medium)

        btn_getStarted.setOnClickListener {
            val move = Intent(this, StopActivity::class.java)
            move.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(move)
        }
    }
}
