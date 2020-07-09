package com.hemanth.vitapbookhub.Fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthCredential
import com.hemanth.vitapbookhub.Activity.LoginActivity

import com.hemanth.vitapbookhub.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_logout.*

/**
 * A simple [Fragment] subclass.
 */
class LogoutFragment : Fragment() {
    lateinit var txtlogoutemail: TextView
    lateinit var txtlogoutname: TextView
    lateinit var imgProfile:ImageView
    lateinit var btnlogout:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_logout, container, false)
        val testName= arguments?.getString("email")
       // System.out.println(testName)
        txtlogoutname=view.findViewById(R.id.txtlogoutname)
        txtlogoutemail=view.findViewById(R.id.txtlogoutemail)
        btnlogout=view.findViewById(R.id.btnlogout)
        imgProfile=view.findViewById(R.id.imgprofile)
        txtlogoutemail.text=testName
        var signinAccount=GoogleSignIn.getLastSignedInAccount(activity as Context)
        if(signinAccount!=null)
        {
            txtlogoutname.text=signinAccount.displayName
            txtlogoutemail.text=signinAccount.email
            Picasso.get().load(signinAccount.photoUrl).into(imgProfile);
            //imgProfile.setImageResource(signinAccount.photoUrl)

        }
        btnlogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent=Intent(activity as Context,LoginActivity::class.java)
            /*intent.putExtra("logout",false)
            intent.putExtra("idLogged","0")*/
            startActivity(intent)

        }
        return view
    }

}
