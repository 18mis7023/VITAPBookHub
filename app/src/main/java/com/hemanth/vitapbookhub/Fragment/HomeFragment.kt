package com.hemanth.vitapbookhub.Fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.hemanth.vitapbookhub.Activity.*
import com.hemanth.vitapbookhub.R
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var relativelayoutJournals:RelativeLayout
    lateinit var relativelayoutLibraryJournals:RelativeLayout
    lateinit var relativelayoutLibraryBooks:RelativeLayout
    lateinit var relativelayoutInterview:RelativeLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_home, container, false)
        relativelayoutInterview=view.findViewById(R.id.relativelayoutInterview)
        relativelayoutJournals=view.findViewById(R.id.relativelayoutJournal)
        relativelayoutLibraryBooks=view.findViewById(R.id.relativelayoutLibraryBooks)
        relativelayoutLibraryJournals=view.findViewById(R.id.relativelayoutLibraryJournals)
        var validate=false
        var signinAccount= GoogleSignIn.getLastSignedInAccount(activity as Context)
        if(signinAccount!=null)
        {
            var x=signinAccount.email.toString()
            if(x.contains("@vitap.ac.in"))
            {
                validate=true
            }

        }
        relativelayoutJournals.setOnClickListener{
            //startActivity(Intent(this,JournalsActivity::class.java))
           // val intent=Intent(context,JournalsActivity::class.java)

           // startActivity(intent)

            if(validate==true)
            {
                val intent=Intent(context,JournalsActivity::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(activity as Context,"Please Loging with Vitap mail id.....only for vitap students have access to it.......",Toast.LENGTH_SHORT).show()
            }
        }
        relativelayoutLibraryBooks.setOnClickListener{
           // val intent=Intent(context,LibraryBooksActivity::class.java)
           // startActivity(intent)

            if(validate==true)
            {
                val intent=Intent(context,LibraryBooksActivity::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(activity as Context,"Please Loging with Vitap mail id.....only for vitap students have access to it.......",Toast.LENGTH_SHORT).show()
            }
        }
        relativelayoutInterview.setOnClickListener {
            val intent=Intent(context,InterviewActivity::class.java)
            startActivity(intent)

        }
        relativelayoutLibraryJournals.setOnClickListener{

            if(validate==true)
            {
                val intent=Intent(context,LibraryJoournalsActivity::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(activity as Context,"Please Loging with Vitap mail id.....only for vitap students have access to it.......",Toast.LENGTH_SHORT).show()
            }
        }


        return view
    }


}
