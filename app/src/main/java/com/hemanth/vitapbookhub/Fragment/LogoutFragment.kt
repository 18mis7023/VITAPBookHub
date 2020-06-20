package com.hemanth.vitapbookhub.Fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.hemanth.vitapbookhub.Activity.LoginActivity

import com.hemanth.vitapbookhub.R
import kotlinx.android.synthetic.main.fragment_logout.*

/**
 * A simple [Fragment] subclass.
 */
class LogoutFragment : Fragment() {
    lateinit var txtlogoutemail: TextView
    lateinit var btnlogout:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_logout, container, false)
        val testName= arguments?.getString("email")
        System.out.println(testName)
        txtlogoutemail=view.findViewById(R.id.txtlogoutemail)
        btnlogout=view.findViewById(R.id.btnlogout)
        txtlogoutemail.text=testName

        btnlogout.setOnClickListener {
            val intent=Intent(activity as Context,LoginActivity::class.java)
            intent.putExtra("logout",false)
            intent.putExtra("idLogged","0")
            startActivity(intent)
            onDestroy()
        }
        return view
    }

}
