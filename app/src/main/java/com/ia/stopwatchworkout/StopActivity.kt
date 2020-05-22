package com.ia.stopwatchworkout

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_stop.*

class StopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stop)

        //load fonts
        val medium = Typeface.createFromAsset(assets, "fonts/Roboto.ttf")

        btn_startWorkout.setTypeface(medium)

        //optional animations
        btn_stopWorkout.setAlpha(0f)

        //load animations
        val anims = AnimationUtils.loadAnimation(this, R.anim.roundingalone)

        btn_startWorkout.setOnClickListener {
            //passing animations
            img_ancor.startAnimation(anims)
            btn_stopWorkout.animate().alpha(1f).translationY(-80f).setDuration(300).start()
            btn_startWorkout.animate().alpha(0f).setDuration(300).start()
            //start timer
            cn_timer.setBase(SystemClock.elapsedRealtime())
            cn_timer.start()
        }

        btn_stopWorkout.setOnClickListener {
            //animation is stop
            img_ancor.clearAnimation()
            btn_startWorkout.animate().alpha(1f).translationY(-80f).setDuration(300).start()
            btn_stopWorkout.animate().alpha(0f).setDuration(300).start()

            //make timer is stop and reset
            cn_timer.setBase(SystemClock.elapsedRealtime())
            cn_timer.stop()
        }
    }
}
