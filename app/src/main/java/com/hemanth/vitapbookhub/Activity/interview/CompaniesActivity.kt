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
import com.hemanth.vitapbookhub.Adapter.Interview.CompaniesRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.Interview.LanguagesRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.InterviewBook
import kotlinx.android.synthetic.main.activity_companies.*
import kotlinx.android.synthetic.main.activity_journals.*
import java.util.*
import kotlin.Comparator

class CompaniesActivity : AppCompatActivity() {

    lateinit var recyclerJava: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(
        InterviewBook(1,"Infosys Interview Questions And Answers","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FCompanies%2FInfosys%20Interview%20Questions.pdf?alt=media&token=3ea8e305-b3f3-4374-aec6-d6f1fb74ec8e"),
        InterviewBook(2,"Microsoft Technical Interview Q/A","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FCompanies%2FMicrosoft%20Technical%20Interview%20Questions.pdf?alt=media&token=6653dec4-7c93-4547-91fc-868cd59ae1d1"),
        InterviewBook(3,"HCL Interview Questions And Answers","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FCompanies%2FHCL%20Interview%20Questions.pdf?alt=media&token=470d88e6-e935-4f53-8996-9142d1348724"),
        InterviewBook(4,"Wipro Technical Interviw Questions/Answers","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FCompanies%2FWipro%20Technical%20Interview%20Questions.pdf?alt=media&token=5514f3c2-dcb4-46c9-abe7-7b3011f18de9"),
        InterviewBook(5,"TCS For Recruitment for freshers Interview","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FCompanies%2FTCS%20Possible%20Technical%20Interview%20Questions%20for%20new%20Campus%20Recruitment.pdf?alt=media&token=5a00f39f-a01a-4e87-a6a3-3e6f8c98b63f"),
        InterviewBook(6,"IGate Technical Interview Q/A","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FCompanies%2FIGATE%20Technical%20Interview%20Questions.pdf?alt=media&token=e0cc4936-a186-4ac1-bb4f-fe66c3118f60"),
        InterviewBook(7,"IBS Interview For Placements","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FCompanies%2FIBS%20Technical%20Interview%20Questions.pdf?alt=media&token=da9e1aa9-bbdc-4ee0-904f-b9535b1c584a"),
        InterviewBook(8,"IBM Interview Questions","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FCompanies%2FIBM.pdf?alt=media&token=b3489857-33e0-4130-84cb-c76126599e04"),
        InterviewBook(9,"Adobe Systems InCorporated Technical","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FCompanies%2FAdobe%20Systems%20Incorparated%20Technical%20Interview%20Questions.pdf?alt=media&token=63259b7c-0e0c-472d-b445-93beadc34505"),
        InterviewBook(10,"Intel Interview Quesions and Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FCompanies%2FINTEL%20INTERVIEW%20QUESTIONS%20AND%20ANSWERS.pdf?alt=media&token=80f482c6-0084-435b-9d0b-b40953175171")
/*
        InterviewBook("topic1","easy","")
*/


    )

    var url:String=""
    lateinit var recycleradapter: CompaniesRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<InterviewBook>{book1,book2->
        book1.topic.compareTo(book2.topic,true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_companies)
        SetUpToolbar()
        recyclerJava=findViewById(R.id.recyclerCompanies)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= CompaniesRecyclerAdapter(this,bookInfoList)
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
        setSupportActionBar(companiestoolbar)
        supportActionBar?.title="Companies"
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
