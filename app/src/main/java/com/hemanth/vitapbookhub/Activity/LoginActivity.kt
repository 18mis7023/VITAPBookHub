package com.hemanth.vitapbookhub.Activity

import android.content.Context
import android.content.Intent
import android.content.LocusId
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.hemanth.vitapbookhub.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
   // lateinit var sharedPreferences: SharedPreferences
    var logged=true
    var id:String?="1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //    sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
    //    val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        setContentView(R.layout.activity_login)
        /*id=intent.getStringExtra("idLogged")
        if (isLoggedIn && id!="1") {
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }*/
        auth = FirebaseAuth.getInstance()
        txtRegister.setOnClickListener{
            startActivity(Intent(this,
                RegisterActivity::class.java))
            finish()
        }
     btnlogin.setOnClickListener {
         dologin()
     }
        txtForgotPassword.setOnClickListener {
            startActivity(Intent(this,
                ForgotPasswordActivity::class.java))
            finish()
        }
    }
    private fun dologin()
    {
        if(etemail.text.toString().isEmpty())
        {
            etemail.error="Please enter email"
            etEmailRegister.requestFocus()
            return

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(etemail.text.toString()).matches())
        {
            etemail.error="Please enter email"
            etemail.requestFocus()
            return
        }
        if(etpassword.text.toString().isEmpty())
        {
            etpassword.error="Please enter password"
            etpassword.requestFocus()
            return
        }
        auth.signInWithEmailAndPassword(etemail.text.toString(), etpassword.text.toString())
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {
                    //sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Toast.makeText(baseContext, "Login failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)

                }

            }
    }
    public override fun onStart() {
        super.onStart()/*
        val currentUser = auth.currentUser
        updateUI(currentUser)*/
    }
    private fun updateUI(currentUser : FirebaseUser?)
    {
        if(currentUser != null)
        {
            val intent=Intent(this,HomeActivity::class.java)
            id="1"
            intent.putExtra("email",etemail.text.toString())
            startActivity(intent)
            finish()
        }
        else
        {
            Toast.makeText(baseContext,"Login Failed.",Toast.LENGTH_SHORT).show()
        }
    }
}

