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
import com.hemanth.vitapbookhub.Adapter.Interview.CIQRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.Interview.LanguagesRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.InterviewBook
import kotlinx.android.synthetic.main.activity_c_i_q.*
import kotlinx.android.synthetic.main.activity_journals.*
import java.util.*
import kotlin.Comparator

class CIQActivity : AppCompatActivity() {
    lateinit var recyclerJava: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(
        InterviewBook(1,"Some Imortant Points For Interview Purpose","Important","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FCommon%20Interview%20Questions%2Finterview%20tips.pdf?alt=media&token=c207ceef-0b90-4492-89b0-2832ebf85569"),
        InterviewBook(2,"How to Face Interview","Important","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FCommon%20Interview%20Questions%2FHow%20to%20face%20Interview.pdf?alt=media&token=18bb1f90-9c42-46f1-8d7e-9e28f4c46ae5"),
        InterviewBook(3,"Computer Science & Innovation and Software Engineering","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FCommon%20Interview%20Questions%2FCSI_Preparing_for_an_Interview.pdf?alt=media&token=3325b5cd-e982-4953-80fe-38fec1353871"),
        InterviewBook(4,"Electrical Engeneer Interview Question","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FCommon%20Interview%20Questions%2FThe%20Most%20Common%20Electrical%20Engineer%20Interview%20Questions.pdf?alt=media&token=3e414e94-d9f0-4ffc-8186-f8843933aefa"),
        InterviewBook(5,"Palimdrome,Armstrong Programs for Interview","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FCommon%20Interview%20Questions%2FPalimdrome%2CArmstrong.pdf?alt=media&token=71b737e9-f096-4b5d-a50b-6442d362278d"),
        InterviewBook(6,"Common Characters in n Strings","Easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FCommon%20Interview%20Questions%2FCommon%20characters%20in%20n%20strings.pdf?alt=media&token=2e1face8-ee5a-4c28-92a7-023dc74093e4")
    )

    var url:String=""
    lateinit var recycleradapter: CIQRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<InterviewBook>{book1,book2->
        book1.topic.compareTo(book2.topic,true)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c_i_q)
        SetUpToolbar()
        recyclerJava=findViewById(R.id.recyclerCIQ)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= CIQRecyclerAdapter(this,bookInfoList)
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
        setSupportActionBar(ciqtoolbar)
        supportActionBar?.title=""
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
