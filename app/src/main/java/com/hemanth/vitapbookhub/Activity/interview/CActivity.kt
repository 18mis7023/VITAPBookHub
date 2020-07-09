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
import com.hemanth.vitapbookhub.Adapter.CRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.MechanicalRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.Book
import com.hemanth.vitapbookhub.model.InterviewBook
import kotlinx.android.synthetic.main.activity_c.*
import kotlinx.android.synthetic.main.activity_journals.*
import java.util.*
import kotlin.Comparator

class CActivity : AppCompatActivity() {
    lateinit var recyclerC: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(
        InterviewBook(1,"C-Programming Language Basics","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Interview%20questions%2FC.pdf?alt=media&token=db1d2892-d6bc-4a9c-bedf-f5e6b8ae3b5e"),
        InterviewBook(2,"C-Programming Interview Q/A","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FC%20Programming%20Interview%20Questions.pdf?alt=media&token=7af656bf-6830-48df-8c53-2112ba956615"),
        InterviewBook(3,"C++ Interview Questions And Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FC%2B%2B%20Programming.pdf?alt=media&token=99b1ac78-8218-4174-aaaa-7a447e1fd944"),
        InterviewBook(4,"Data Structures Interview Q/A","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FData%20Structure%20Interview%20Questions.pdf?alt=media&token=1f68b004-e3ef-456d-811e-2c871846d8e2")
/*
        InterviewBook("topic1","easy",""),
        InterviewBook("topic1","easy",""),
        InterviewBook("topic1","easy","")
*/

        )

    var url:String=""
    lateinit var recycleradapter: CRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<InterviewBook>{book1,book2->
        book1.topic.compareTo(book2.topic,true)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
        SetUpToolbar()
        recyclerC=findViewById(R.id.recyclerC)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= CRecyclerAdapter(this,bookInfoList)
        recyclerC.adapter=recycleradapter
        recyclerC.layoutManager=layoutManager
        recyclerC.addItemDecoration(
            DividerItemDecoration(
                recyclerC.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )
    }
    fun SetUpToolbar(){
        setSupportActionBar(ctoolbar)
        supportActionBar?.title="C-Programming"
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
