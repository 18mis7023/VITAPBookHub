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
import com.hemanth.vitapbookhub.Activity.InterviewQuestionsActivity
import com.hemanth.vitapbookhub.Adapter.Interview.LanguagesRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.JavaRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.InterviewBook
import kotlinx.android.synthetic.main.activity_journals.*
import kotlinx.android.synthetic.main.activity_languages.*
import java.util.*
import kotlin.Comparator

class HtmlActivity : AppCompatActivity() {

    lateinit var recyclerJava: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(
        InterviewBook(1,"HTML Interview Questions And Answers","Easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FHTML%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=4ada739f-e772-47ed-bed7-17a2692d1d17"),
        InterviewBook(2,"CSS Interview Questions And Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FCSS%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=2bb4a791-ac1a-44ef-8e6d-bb7dd86f68de"),
        InterviewBook(3,"Java Script Interview Q/A","Easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FJAVASCRIPT%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=a8227943-ef2b-4c78-a0b8-07259cb4ed4a"),
        InterviewBook(4,"Angular JS Interview Q/A","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FANGULAR%20JS%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=b38ff114-6eaf-456d-94ab-06698ccfa135"),
        InterviewBook(5,"Node.Js Interview Q/A-1","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FNODE.JS%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=3356c34d-b0cf-4486-bd5f-460046c51fe1"),
        InterviewBook(6,"Node.Js Interview Q/A-2","Hard","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FNode_js%20interview%20Questions.pdf?alt=media&token=6ce13f71-d5a8-4e3b-ba74-3ee552d05413")
/*
        InterviewBook("topic1","easy","")
*/


    )

    var url:String=""
    lateinit var recycleradapter: LanguagesRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<InterviewBook>{book1,book2->
        book1.topic.compareTo(book2.topic,true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_languages)
        SetUpToolbar()
        recyclerJava=findViewById(R.id.recyclerLanguage)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= LanguagesRecyclerAdapter(this,bookInfoList)
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
        setSupportActionBar(langtoolbar)
        supportActionBar?.title=""
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item?.itemId
        when(id)
        {
            android.R.id.home ->{
                startActivity(Intent(this, InterviewQuestionsActivity::class.java))
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
