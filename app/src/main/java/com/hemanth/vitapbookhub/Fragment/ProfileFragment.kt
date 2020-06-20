package com.hemanth.vitapbookhub.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.hemanth.vitapbookhub.R

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {
lateinit var txtemailprofile:TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_profile, container, false)

        val testName= arguments!!.getString("email")
        System.out.println(testName)
        txtemailprofile=view.findViewById(R.id.txtemailprofile)
        txtemailprofile.text=testName
        return view

    }

}
