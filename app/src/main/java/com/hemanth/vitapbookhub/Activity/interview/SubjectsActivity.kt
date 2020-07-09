package com.hemanth.vitapbookhub.Activity.interview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.vitapbookhub.Activity.InterviewActivity
import com.hemanth.vitapbookhub.Adapter.Interview.LanguagesRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.Interview.SubjectsRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.InterviewBook
import kotlinx.android.synthetic.main.activity_journals.*
import kotlinx.android.synthetic.main.activity_subjects.*
import java.util.*
import kotlin.Comparator

class SubjectsActivity : AppCompatActivity() {
    lateinit var recyclerJava: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(
        InterviewBook(1,"Android Interview Questons","Important","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FAndroid%20Interview%20Questions.pdf?alt=media&token=60378aee-c97a-43db-96b3-1d8d0f62425c"),
        InterviewBook(2,"Cloud Computing Interview Q/A","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FCloud%20Computing%20Interview%20Questions.pdf?alt=media&token=11f9738e-4ca6-4da6-baab-5654269f057a"),
        InterviewBook(3,"Ciso Certified Network Associate Interview Q/A","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FCisco%20Certified%20Network%20Associate%20Interview%20Questions.pdf?alt=media&token=be40cf0e-275f-47b7-8fcf-d2e9c7f96ae4"),
        InterviewBook(4,"Networking Interview Questions/Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FNetworking%20Interview%20Questions.pdf?alt=media&token=739d8309-b6de-4c7f-a731-8f3bb1ec4597"),
        InterviewBook(5,"AC & DC  Electrical Interview Q/A","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FElectrical%20interview%20questions%20from%20AC%26DC.pdf?alt=media&token=85f939a6-ba3d-44cf-8b61-a3deefea31d7"),
        InterviewBook(6,"Power Electronics Questions/Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FElectrical%20Interview%20Questions%20from%20Power%20Electronics.pdf?alt=media&token=68aac3b6-186a-4657-81c3-a21c0702c9be"),
        InterviewBook(8,"Algorithim Interview Questions And ANswers","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FAlgorithm%20Interview%20Questions%20and%20Answers.pdf?alt=media&token=54ffbd36-dbb0-4c65-a455-1aa8ee7ead6e"),
        InterviewBook(9,"Electrical Interview Questions from Power Electronics","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FAndroid%20Interview%20Questions.pdf?alt=media&token=60378aee-c97a-43db-96b3-1d8d0f62425c"),
        InterviewBook(10,"DataWarehouse Interview Questions","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FData%20Warehouse%20Interview%20Questions.pdf?alt=media&token=31980d23-9808-4aae-8251-00484c9d9676"),
        InterviewBook(11,"DataStage Interview Questions and Concept","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FDataStage%20Interview%20Questions.pdf?alt=media&token=f7a9d135-86ce-4863-b98d-d8fd88e62aef"),
        InterviewBook(12,"Digital Electronics Interview Questions","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FDigital%20Electronics%20Interview%20Questions.pdf?alt=media&token=41bd2096-ca42-4f26-b0a0-29533e8c5a8c"),
        InterviewBook(13,"Electrical Machines Interview Questions","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FElectrical%20Machines%20Interview%20questions.pdf?alt=media&token=38b0ca05-0886-4d3a-a011-795fbae415c1"),
        InterviewBook(14,"Flutter Interview Questions","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FFlutter%20Interview%20Questions.pdf?alt=media&token=1eec5a69-7a95-488b-91ed-9bef53bdfbc3"),
        InterviewBook(15,"GIT Interview Questions","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FGIT%20Interview%20Questions.pdf?alt=media&token=6cf92e22-e958-4d26-aa18-949296b41d0b"),
        InterviewBook(16,"Kali Linux Interview Questions","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FKali%20Linux%20Interview%20Questions.pdf?alt=media&token=887cc679-3a06-49ae-b6f9-6251b2de3f53"),
        InterviewBook(17,"Matlab Interview Questions Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FMATLAB%20Interview%20Questions.pdf?alt=media&token=5d6b56b2-74cc-479a-ab84-cad4fcae6fac"),
        InterviewBook(18,"Networking Interview Questions","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FNetworking%20Interview%20Questions.pdf?alt=media&token=739d8309-b6de-4c7f-a731-8f3bb1ec4597"),
        InterviewBook(19,"Power Electronics Control Methods","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FPOWER%20ELECTRONICS%20CONTROL%20METHODS.pdf?alt=media&token=f5d4e36a-37e5-4076-833d-9bcb6f4fb97f"),
        InterviewBook(20,"PowerShell Interview Questions","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FPowerShell%20Interview%20Questions.pdf?alt=media&token=7f24b1e5-ba3d-4cc5-809b-712e3de54d39"),
        InterviewBook(21,"Python Pandas Interview Questions","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FPython%20Pandas%20interview%20questions.pdf?alt=media&token=c0069959-46b8-4415-8b63-4e0138df93f4"),
        InterviewBook(22,"R Interview Questions","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FR%20Interview%20Questions.pdf?alt=media&token=c745340c-cbcc-4e9f-bfed-d89269186f96"),
        InterviewBook(23,"Robotics Interview Questions and Answers","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FRobotics%20Interview%20questions.pdf?alt=media&token=074611c7-b43b-4a1e-80ab-218819a8892a"),
        InterviewBook(24,"Web Services Interview Questions And Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FWeb%20Services%20Interview%20Questions.pdf?alt=media&token=a460e5a9-5d29-4998-9064-462a474e0463")


/*
        InterviewBook("topic1","easy","")
*/


    )

    var url:String=""
    lateinit var recycleradapter: SubjectsRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<InterviewBook>{book1,book2->
        book1.topic.compareTo(book2.topic,true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subjects)
        SetUpToolbar()
        recyclerJava=findViewById(R.id.recyclerSubjects)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= SubjectsRecyclerAdapter(this,bookInfoList)
        recyclerJava.adapter=recycleradapter
        recyclerJava.layoutManager=layoutManager
        recyclerJava.addItemDecoration(
            DividerItemDecoration(
                recyclerJava.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )
    }
    fun SetUpToolbar(){
        setSupportActionBar(subjtoolbar)
        supportActionBar?.title="Subjects"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item?.itemId
        when(id)
        {
            android.R.id.home ->{
                startActivity(Intent(this, InterviewActivity::class.java))
                finish()
            }
            R.id.action_sort_inc ->{
                if(order==1) {
                    Collections.sort(bookInfoList, ratingcomparator)
                    order=0
                }
                else if(order==0)
                {
                    Collections.sort(bookInfoList, ratingcomparator)
                    bookInfoList.reverse()
                    order=1
                }
                else
                {
                    Collections.sort(bookInfoList, ratingcomparator)
                    order=0
                }
            }
        }
        recycleradapter.notifyDataSetChanged()

        return super.onOptionsItemSelected(item)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_dashboard,menu)
        return super.onCreateOptionsMenu(menu)
    }
}
