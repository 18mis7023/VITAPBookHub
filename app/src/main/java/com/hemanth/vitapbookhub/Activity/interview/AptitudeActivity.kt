package com.hemanth.vitapbookhub.Activity.interview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hemanth.vitapbookhub.Activity.interview.Aptitude.DataInterpretationActivity
import com.hemanth.vitapbookhub.Activity.interview.Aptitude.LogicalAptitudeActivity
import com.hemanth.vitapbookhub.Activity.interview.Aptitude.QuantitativeAptitudeActivity
import com.hemanth.vitapbookhub.Activity.interview.Aptitude.VerbalActivity
import com.hemanth.vitapbookhub.R
import kotlinx.android.synthetic.main.activity_aptitude.*

class AptitudeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aptitude)
        relativelayoutquantitative.setOnClickListener {
            startActivity(Intent(this,QuantitativeAptitudeActivity::class.java))
            finish()
        }
        relativelayoutLogical.setOnClickListener {
            startActivity(Intent(this,LogicalAptitudeActivity::class.java))
            finish()
        }
        relativelayoutDatainterpretation.setOnClickListener {
            startActivity(Intent(this,DataInterpretationActivity::class.java))
            finish()
        }
        relativelayoutVerbal.setOnClickListener {
            startActivity(Intent(this,VerbalActivity::class.java))
            finish()
        }
    }
}
