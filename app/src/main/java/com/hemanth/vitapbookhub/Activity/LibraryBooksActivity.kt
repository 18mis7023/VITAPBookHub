package com.hemanth.vitapbookhub.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hemanth.vitapbookhub.Activity.Books.*
import com.hemanth.vitapbookhub.R
import kotlinx.android.synthetic.main.activity_library_books.*

class LibraryBooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library_books)
        btnMaths.setOnClickListener{
            startActivity(Intent(this,MathsActivity::class.java))
            finish()
        }
        btncomputer.setOnClickListener{
            startActivity(Intent(this,ComputerActivity::class.java))
            finish()
        }
        btnSoftware.setOnClickListener{
            startActivity(Intent(this,SoftwareActivity::class.java))
            finish()
        }
        btnEnglish.setOnClickListener{
            startActivity(Intent(this,EnglishActivity::class.java))
            finish()
        }
        btnelectronics.setOnClickListener{
            startActivity(Intent(this,ElectronicsActivity::class.java))
            finish()
        }
        btnCivil.setOnClickListener{
            startActivity(Intent(this,CivilActivity::class.java))
            finish()
        }
        btnMechanical.setOnClickListener{
            startActivity(Intent(this,MechanicalActivity::class.java))
            finish()
        }
        btnphysics.setOnClickListener{
            startActivity(Intent(this,PhysicsActivity::class.java))
            finish()
        }

    }
}
