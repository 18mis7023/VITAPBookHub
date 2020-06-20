package com.hemanth.vitapbookhub.Activity.interview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.vitapbookhub.Adapter.CRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.DbmsRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.InterviewBook

class DbmsActivity : AppCompatActivity() {
    lateinit var recyclerDbms: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(
        InterviewBook(1,"Database Systems","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Interview%20questions%2FDBMS.pdf?alt=media&token=a6b8c788-516a-402b-857d-b95c951000b8")
/*
        InterviewBook("topic1","easy",""),
        InterviewBook("topic1","easy",""),
        InterviewBook("topic1","easy","")
*/

    )

    var url:String=""
    lateinit var recycleradapter: DbmsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbms)
        recyclerDbms=findViewById(R.id.recyclerDbms)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= DbmsRecyclerAdapter(this,bookInfoList)
        recyclerDbms.adapter=recycleradapter
        recyclerDbms.layoutManager=layoutManager
        recyclerDbms.addItemDecoration(
            DividerItemDecoration(
                recyclerDbms.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )
    }
}
