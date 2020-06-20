package com.hemanth.vitapbookhub.Activity.interview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.vitapbookhub.Adapter.CRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.MechanicalRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.Book
import com.hemanth.vitapbookhub.model.InterviewBook

class CActivity : AppCompatActivity() {
    lateinit var recyclerC: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(
        InterviewBook(1,"C-Programming","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Interview%20questions%2FC.pdf?alt=media&token=db1d2892-d6bc-4a9c-bedf-f5e6b8ae3b5e")
/*
        InterviewBook("topic1","easy",""),
        InterviewBook("topic1","easy",""),
        InterviewBook("topic1","easy","")
*/

        )

    var url:String=""
    lateinit var recycleradapter: CRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
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
}
