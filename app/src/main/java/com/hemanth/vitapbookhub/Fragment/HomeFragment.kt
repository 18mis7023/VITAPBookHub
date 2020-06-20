package com.hemanth.vitapbookhub.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.fragment.app.FragmentTransaction
import com.hemanth.vitapbookhub.Activity.InterviewQuestionsActivity
import com.hemanth.vitapbookhub.Activity.JournalsActivity
import com.hemanth.vitapbookhub.Activity.LibraryBooksActivity
import com.hemanth.vitapbookhub.Activity.LibraryJoournalsActivity
import com.hemanth.vitapbookhub.R

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
        relativelayoutJournals.setOnClickListener{
            //startActivity(Intent(this,JournalsActivity::class.java))
            val intent=Intent(context,JournalsActivity::class.java)
            startActivity(intent)
        }
        relativelayoutLibraryBooks.setOnClickListener{
            val intent=Intent(context,LibraryBooksActivity::class.java)
            startActivity(intent)
        }
        relativelayoutInterview.setOnClickListener {
            val intent=Intent(context,InterviewQuestionsActivity::class.java)
            startActivity(intent)
        }
        relativelayoutLibraryJournals.setOnClickListener{
            val intent=Intent(context,LibraryJoournalsActivity::class.java)
            startActivity(intent)
        }


        return view
    }


}
