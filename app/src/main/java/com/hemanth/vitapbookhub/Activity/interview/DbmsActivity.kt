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
import com.hemanth.vitapbookhub.Adapter.DbmsRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.InterviewBook
import kotlinx.android.synthetic.main.activity_dbms.*
import kotlinx.android.synthetic.main.activity_journals.*
import java.util.*
import kotlin.Comparator

class DbmsActivity : AppCompatActivity() {
    lateinit var recyclerDbms: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(
        InterviewBook(1,"Database Systems","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Interview%20questions%2FDBMS.pdf?alt=media&token=a6b8c788-516a-402b-857d-b95c951000b8"),
        InterviewBook(2,"DataBase Management System -2","Hard","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fdatabase%2FDB2%20Interview%20Questions.pdf?alt=media&token=90b3ba2f-1f60-4a35-ad34-28d54a3abb90"),
        InterviewBook(3,"Microsoft Access Interview Questions","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fdatabase%2FMicrosoft%20Access%20Interview%20Questions.pdf?alt=media&token=2c3d7b76-779e-4f31-afdb-e3bc355d37df"),
        InterviewBook(4,"Oracle Interview Questions And Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fdatabase%2FOracle%20Interview%20Questions.pdf?alt=media&token=5541f74f-de4e-4df6-a65e-ac9995564be0"),
        InterviewBook(5,"PL/SQL Interview Questions And Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fdatabase%2FPL%20interview%20que.pdf?alt=media&token=3a5f899b-8f5d-4ea1-9703-a19988d51467"),
        InterviewBook(6,"SQL Interview Questions And Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fdatabase%2FSQL%20Interview%20Questions.pdf?alt=media&token=943aa8cd-e87c-4920-b202-fbaf4399ce1e"),
        InterviewBook(7,"SQL LITE Interview Questions And Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fdatabase%2FSQLite%20Interview%20Questions.pdf?alt=media&token=eb10bc08-5a24-4846-8f58-e9d44814bca4"),
        InterviewBook(8,"Mongo DataBase Interview Q/A","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fdatabase%2FMongoDB%20Interview%20Questions.pdf?alt=media&token=72a5d0aa-5e4f-4cb4-b38c-6158c5fa308c"),
        InterviewBook(9,"Cassandra Interview Questions And Answers","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fdatabase%2FCassandra%20Interview%20Questions.pdf?alt=media&token=1b995bc2-01da-40e1-b57f-60413f42a110"),
        InterviewBook(10,"Data Warhouse Interview Questions ","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FData%20Warehouse%20Interview%20Questions.pdf?alt=media&token=31980d23-9808-4aae-8251-00484c9d9676"),
        InterviewBook(11,"DataStage Interview Questions and Answers","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FSubjects%2FDataStage%20Interview%20Questions.pdf?alt=media&token=f7a9d135-86ce-4863-b98d-d8fd88e62aef")

/*
        InterviewBook("topic1","easy",""),
        InterviewBook("topic1","easy",""),
        InterviewBook("topic1","easy","")
*/

    )

    var url:String=""
    lateinit var recycleradapter: DbmsRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<InterviewBook>{book1,book2->
        book1.topic.compareTo(book2.topic,true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbms)
        SetUpToolbar()
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
    fun SetUpToolbar(){
        setSupportActionBar(dbmstoolbar)
        supportActionBar?.title="DBMS"
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
