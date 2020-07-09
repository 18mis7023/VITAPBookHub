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
import com.hemanth.vitapbookhub.Adapter.NetworkingRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.OsRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.InterviewBook
import kotlinx.android.synthetic.main.activity_journals.*
import kotlinx.android.synthetic.main.activity_networking.*
import java.util.*
import kotlin.Comparator

class NetworkingActivity : AppCompatActivity() {
    lateinit var recyclerOs: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(
        InterviewBook(1,"Computer Network Models Interview Questions","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fnetworking%2FComputer%20Network%20Models.pdf?alt=media&token=3ed2c4a8-9fc9-4674-84be-083243bbfa31"),
        InterviewBook(2,"Network Layer Interview Questions And Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fnetworking%2FNetwork%20Layer.pdf?alt=media&token=00066091-1277-4fdb-aca0-5df97434c764"),
        InterviewBook(3,"Routing Algorithim","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fnetworking%2FRouting%20algorithm.pdf?alt=media&token=1f023ddc-e566-42e9-a063-4930c7e008f3"),
        InterviewBook(4,"Types of network Protocols Explained with Functions","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fnetworking%2FTypes%20of%20Network%20Protocols%20Explained%20with%20Functions.pdf?alt=media&token=84d73d0c-8923-426f-8590-f78c780e89a3")

/*
        InterviewBook("topic1","easy",""),
        InterviewBook("topic1","easy",""),
        InterviewBook("topic1","easy","")
*/

    )

    var url:String=""
    lateinit var recycleradapter: NetworkingRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<InterviewBook>{book1,book2->
        book1.topic.compareTo(book2.topic,true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_networking)
        SetUpToolbar()
        recyclerOs=findViewById(R.id.recyclerNetworking)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= NetworkingRecyclerAdapter(this,bookInfoList)
        recyclerOs.adapter=recycleradapter
        recyclerOs.layoutManager=layoutManager
        recyclerOs.addItemDecoration(
            DividerItemDecoration(
                recyclerOs.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )
    }
    fun SetUpToolbar(){
        setSupportActionBar(networkingtoolbar)
        supportActionBar?.title="Networking"
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
