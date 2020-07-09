package com.hemanth.vitapbookhub.Activity.interview.Aptitude

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.vitapbookhub.Activity.InterviewActivity
import com.hemanth.vitapbookhub.Activity.interview.AptitudeActivity
import com.hemanth.vitapbookhub.Adapter.Interview.DataRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.Interview.VerbalRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.InterviewBook
import kotlinx.android.synthetic.main.activity_journals.*
import kotlinx.android.synthetic.main.activity_verbal.*
import java.util.*
import kotlin.Comparator

class VerbalActivity : AppCompatActivity() {

    lateinit var recyclerC: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(
        InterviewBook(1,"Error correction","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/verbal%20ability%2FError%20Correction.pdf?alt=media&token=45a7a165-bd6c-4d26-8450-9428ee4807e0"),
        InterviewBook(2,"antonyms","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/verbal%20ability%2Fantonyms.pdf?alt=media&token=821f9aa7-73cc-4a67-980d-dd998cacdf29"),
        InterviewBook(3,"comprehension","Easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/verbal%20ability%2Fcomprehension.pdf?alt=media&token=7e089140-b026-4aa4-90bb-60d3cedd96a6"),
        InterviewBook(4,"idioms and phases","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/verbal%20ability%2Fidioms%20and%20phrases.pdf?alt=media&token=0452d88f-a4f1-451b-b116-b58df444b6f1"),
        InterviewBook(5,"parts of speech","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/verbal%20ability%2Fparts%20of%20speech.pdf?alt=media&token=6a2e5fed-1176-4c25-8f3d-5e04df505acd"),
        InterviewBook(6,"synonyms","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/verbal%20ability%2Fsynonyms.pdf?alt=media&token=d5a78bd7-c9a9-40e6-a00c-36285ae3f986")


/*
        InterviewBook(1,"topic1","easy",""),
        InterviewBook(2"topic1","easy",""),
        InterviewBook(3"topic1","easy","")
*/

    )

    var url:String=""
    lateinit var recycleradapter: VerbalRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<InterviewBook>{book1,book2->
        book1.topic.compareTo(book2.topic,true)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verbal)
        SetUpToolbar()
        recyclerC=findViewById(R.id.recyclerVerbal)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= VerbalRecyclerAdapter(this,bookInfoList)
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
        setSupportActionBar(verbaltoolbar)
        supportActionBar?.title="Verbal"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item?.itemId
        when(id)
        {
            android.R.id.home ->{
                startActivity(Intent(this, AptitudeActivity::class.java))
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
