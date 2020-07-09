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
import com.hemanth.vitapbookhub.Adapter.Interview.PhpRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.InterviewBook
import kotlinx.android.synthetic.main.activity_journals.*
import kotlinx.android.synthetic.main.activity_php.*
import java.util.*
import kotlin.Comparator

class PhpActivity : AppCompatActivity() {
    lateinit var recyclerDbms: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(
        InterviewBook(1,"PHP Interview Questions","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FPhp%2Fphp%20interview%20questions.pdf?alt=media&token=9aaccef6-c590-46e4-bd07-a8eccf251520"),
        InterviewBook(2,"Wordpress Interview Questions","Hard","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FPhp%2Fwordpress%20interview%20questions.pdf?alt=media&token=51d03947-913a-4fd8-8951-93b8d6d85fec"),
        InterviewBook(3,"Magento Interview Questions And Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FPhp%2Fmagento%20interview%20questions.pdf?alt=media&token=0924180b-0b01-4963-b35d-245238cdc777"),
        InterviewBook(4,"Joomla Interview Questions And Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FPhp%2Fjoomla%20interview%20questions.pdf?alt=media&token=00961b13-be4a-46e8-901e-bc2b6a5d7519"),
        InterviewBook(5,"Drupal Interview Questions And Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FPhp%2Fdrupal%20interview%20questions.pdf?alt=media&token=44386dda-e7b5-418a-816a-abb880a1eb04"),
        InterviewBook(6,"Codeigniter Interview Questions And Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FPhp%2Fcodeigniter%20interview%20questions.pdf?alt=media&token=5bae653a-7064-43a4-8fd9-61559a3c2898"),
        InterviewBook(7,"Phalcon Interview Questions And Answers","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FLanguages%2FPhp%2Fphalcon%20interview%20questions.pdf?alt=media&token=649eec13-633b-4fd7-bbc9-7260ba514b83")
/*
        InterviewBook("topic1","easy",""),
        InterviewBook("topic1","easy",""),
        InterviewBook("topic1","easy","")
*/

    )

    var url:String=""
    lateinit var recycleradapter: PhpRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<InterviewBook>{book1,book2->
        book1.topic.compareTo(book2.topic,true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_php)
        SetUpToolbar()
        recyclerDbms=findViewById(R.id.recyclerPhp)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= PhpRecyclerAdapter(this,bookInfoList)
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
        setSupportActionBar(phptoolbar)
        supportActionBar?.title="PHP"
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
