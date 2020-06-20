package com.hemanth.vitapbookhub.Activity.interview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.vitapbookhub.Adapter.DbmsRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.OsRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.InterviewBook

class OsActivity : AppCompatActivity() {
    lateinit var recyclerOs: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(
        InterviewBook(1,"Operating Systems","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Interview%20questions%2FOS.pdf?alt=media&token=c2737e5a-5772-48f7-b58c-07063aab40e6")
/*
        InterviewBook("topic1","easy",""),
        InterviewBook("topic1","easy",""),
        InterviewBook("topic1","easy","")
*/

    )

    var url:String=""
    lateinit var recycleradapter: OsRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_os)
        recyclerOs=findViewById(R.id.recyclerOs)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= OsRecyclerAdapter(this,bookInfoList)
        recyclerOs.adapter=recycleradapter
        recyclerOs.layoutManager=layoutManager
        recyclerOs.addItemDecoration(
            DividerItemDecoration(
                recyclerOs.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )
    }
}
