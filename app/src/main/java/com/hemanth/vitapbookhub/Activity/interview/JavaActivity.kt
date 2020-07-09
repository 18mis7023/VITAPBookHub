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
import com.hemanth.vitapbookhub.Adapter.DbmsRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.JavaRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.InterviewBook
import kotlinx.android.synthetic.main.activity_java.*
import kotlinx.android.synthetic.main.activity_journals.*
import java.util.*
import kotlin.Comparator

class JavaActivity : AppCompatActivity() {
    lateinit var recyclerJava: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(
        InterviewBook(1,"Java Programming Questions And Answers-1","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Interview%20questions%2FJAVA.pdf?alt=media&token=ab20de1a-ddd8-41cc-b9d8-a7d81bec4cda"),
        InterviewBook(2,"Data Structures","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Interview%20questions%2FData%20Structures.pdf?alt=media&token=4c40e988-4ad1-461a-9090-1d4f8270354a"),
        InterviewBook(3,"Java Programming Interview Q/A-2","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FJava%20Interview%20Questions.pdf?alt=media&token=3d0d7db0-df26-4487-8520-1edb394182fd"),
        InterviewBook(4,"Object Oriented programming","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Interview%20questions%2FOOPS.pdf?alt=media&token=ff15147a-6784-4311-8c83-b579dbac2b35"),
        InterviewBook(5,"GWT Interview Questions","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fjava%2FGWT%20Interview%20Question.pdf?alt=media&token=67ea7d68-eb56-4ec7-8f1c-8cca207c17f3"),
        InterviewBook(6,"JDB Interview Questions","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fjava%2FJDB%20Interview%20Questions.pdf?alt=media&token=4251d640-2442-4a2e-85d2-7889930a6502"),
        InterviewBook(7,"Java Persistence API(JPA) Q/A","HARD","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fjava%2FJPA%20Interview%20Questions.pdf?alt=media&token=d34eb6e0-0ccf-4e4f-addb-6e8dc7c39d7d"),
        InterviewBook(8,"Java Server Faces","Hard","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fjava%2FJSF%20Interview%20Questions.pdf?alt=media&token=8c58617b-71b9-48ec-b9cb-f8ab1afc1d5b"),
        InterviewBook(9,"JUnit Interview Questions and Answers","Hard","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fjava%2FJUnit%20Interview%20Question.pdf?alt=media&token=75aa9fee-6d7f-4ce3-9dd9-be44967c4dec"),
        InterviewBook(10,"Java Multithreading and Concurrency Q/A","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fjava%2FJava%20Multithreading%20and%20Concurrency%20Interview%20Questions.pdf?alt=media&token=a97d25cd-dd18-4ae7-9bb2-70dc5cdbe32b"),
        InterviewBook(11,"Servelt Interview Questions","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fjava%2FServlet%20interview%20questions.pdf?alt=media&token=40d95a69-b806-409b-a870-58b2b308b96d"),
        InterviewBook(12,"Spring Interview Questions And Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2Fjava%2FSpring%20Interview%20Questions.pdf?alt=media&token=93778c52-24ae-4eae-9236-5a471e5f187c")


/*
        InterviewBook("topic1","easy","")
*/


    )

    var url:String=""
    lateinit var recycleradapter: JavaRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<InterviewBook>{book1,book2->
        book1.topic.compareTo(book2.topic,true)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java)
        SetUpToolbar()
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
    fun SetUpToolbar(){
        setSupportActionBar(javatoolbar)
        supportActionBar?.title="Java"
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
