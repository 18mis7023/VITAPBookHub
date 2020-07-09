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
import com.hemanth.vitapbookhub.Adapter.CRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.Interview.DataRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.InterviewBook
import kotlinx.android.synthetic.main.activity_data_interpretation.*
import kotlinx.android.synthetic.main.activity_journals.*
import java.util.*
import kotlin.Comparator

class DataInterpretationActivity : AppCompatActivity() {
    lateinit var recyclerC: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(

        InterviewBook(1,"bar graph","Easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/data%20interpretation%2Fbar%20graph.pdf?alt=media&token=86deb4fc-96f7-4fd3-a1ca-58b363f9e007"),
        InterviewBook(2,"net diagrams","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/data%20interpretation%2Fnet%20diagrams.pdf?alt=media&token=88eb6a02-43dc-43de-b9ae-9c214ae9735f"),
        InterviewBook(3,"pie charts","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/data%20interpretation%2Fpie%20charts.pdf?alt=media&token=95899451-1304-4496-b0fd-36676aab955b"),
        InterviewBook(4,"tabular data","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/data%20interpretation%2Ftabular%20data.pdf?alt=media&token=83ddc6b1-68de-4ab2-9fe5-24319a564a94"),
        InterviewBook(5,"venn diagrams","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/data%20interpretation%2Fvenn%20diagrams.pdf?alt=media&token=c80e8f0c-39c9-450f-983d-e067330f2331")
    )

    var url:String=""
    lateinit var recycleradapter: DataRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<InterviewBook>{book1,book2->
        book1.topic.compareTo(book2.topic,true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_interpretation)
        SetUpToolbar()
        recyclerC=findViewById(R.id.recyclerDataInterpretation)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= DataRecyclerAdapter(this,bookInfoList)
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
        setSupportActionBar(datatoolbar)
        supportActionBar?.title="Data Interpretation"
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
