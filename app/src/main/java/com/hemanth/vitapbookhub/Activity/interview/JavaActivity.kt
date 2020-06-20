package com.hemanth.vitapbookhub.Activity.interview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.vitapbookhub.Adapter.DbmsRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.JavaRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.InterviewBook

class JavaActivity : AppCompatActivity() {
    lateinit var recyclerJava: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(
        InterviewBook(1,"Java Programming","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Interview%20questions%2FJAVA.pdf?alt=media&token=ab20de1a-ddd8-41cc-b9d8-a7d81bec4cda"),
        InterviewBook(2,"Data Structures","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Interview%20questions%2FData%20Structures.pdf?alt=media&token=4c40e988-4ad1-461a-9090-1d4f8270354a"),
        InterviewBook(3,"Object Oriented programming","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Interview%20questions%2FOOPS.pdf?alt=media&token=ff15147a-6784-4311-8c83-b579dbac2b35")
/*
        InterviewBook("topic1","easy","")
*/


    )

    var url:String=""
    lateinit var recycleradapter: JavaRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java)
        recyclerJava=findViewById(R.id.recyclerJava)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= JavaRecyclerAdapter(this,bookInfoList)
        recyclerJava.adapter=recycleradapter
        recyclerJava.layoutManager=layoutManager
        recyclerJava.addItemDecoration(
            DividerItemDecoration(
                recyclerJava.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )

    }
}
