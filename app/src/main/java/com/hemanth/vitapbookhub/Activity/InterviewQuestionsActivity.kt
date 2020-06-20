package com.hemanth.vitapbookhub.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hemanth.vitapbookhub.Activity.Books.DownloadViewActivity
import com.hemanth.vitapbookhub.Activity.interview.CActivity
import com.hemanth.vitapbookhub.Activity.interview.DbmsActivity
import com.hemanth.vitapbookhub.Activity.interview.JavaActivity
import com.hemanth.vitapbookhub.Activity.interview.OsActivity
import com.hemanth.vitapbookhub.R
import kotlinx.android.synthetic.main.activity_interview_questions.*

class InterviewQuestionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interview_questions)
        relativelayoutJava.setOnClickListener{
            startActivity(Intent(this,JavaActivity::class.java))
        }
        relativelayoutC.setOnClickListener {
            startActivity(Intent(this,CActivity::class.java))
        }
        relativelayoutDatabase.setOnClickListener {
            startActivity(Intent(this, DbmsActivity::class.java))
        }
        relativelayoutOS.setOnClickListener {
            startActivity(Intent(this, OsActivity::class.java))
        }
    }
}
