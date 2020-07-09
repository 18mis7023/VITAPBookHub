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
import com.hemanth.vitapbookhub.Adapter.Interview.SubjectsRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.Interview.WebDevelopmentRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.InterviewBook
import kotlinx.android.synthetic.main.activity_journals.*
import kotlinx.android.synthetic.main.activity_web_development.*
import java.util.*
import kotlin.Comparator

class WebDevelopmentActivity : AppCompatActivity() {
    lateinit var recyclerJava: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<InterviewBook>(
        InterviewBook(1,"Web Development Placement Q/A ","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FWEB%20DEVELOPMENT%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=e2f608a7-4050-4519-8439-7ed19893dae8"),
        InterviewBook(2,"HTML Interview questions And Answers","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FHTML%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=b95a8028-eef4-4862-a716-0a8539d80b2d"),
        InterviewBook(3,"CSS Interview questions And Answers","Medium","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FCSS%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=c3354eb5-6785-470c-9732-04d1c1781ec2"),
        InterviewBook(4,"Java Script Interview questions And Answers","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FJAVASCRIPT%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=859c318f-7f00-48e6-a571-c619fc78cf75"),
        InterviewBook(5,"Angular Js Interview questions And Answers","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FANGULAR%20JS%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=c2fe6042-41c9-404c-80a8-d4f94cb1ee4a"),
        InterviewBook(6,"Ajax Interview questions And Answers","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FAJAX%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=d27fec79-4b16-4cc7-9759-486d47576a8d"),
        InterviewBook(7,"Angular 7 Interview questions And Answers","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FANGULAR%207%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=6e1e6a71-3534-4336-99f3-4b7f19eee888"),
        InterviewBook(9,"Angular Interview questions And Answers","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FANGULAR%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=dcb54cef-481e-4fed-b42c-41dd9ac0f8ec"),
        InterviewBook(10,"BackBone.JS Interview questions And Answers","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FBACKBONE.JS%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=3a0c6bd7-0a79-40d8-a4a5-5dad5df0952d"),
        InterviewBook(11,"DOJO Interview questions And Answers","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FDOJO%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=abb857ed-81ca-4fb2-a045-0e93434df7a4"),
        InterviewBook(12,"Ember.JS Interview questions And Answers","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FEMBER.JS%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=3b3faaf8-05db-4071-b999-fbacfeb3932b"),
        InterviewBook(13,"FrameWork 7 Interview questions And Answers","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FFRAMEWORK7%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=8b82c60d-f19e-479e-ae55-37cfdcaaac5e"),
        InterviewBook(14,"JQuery Interview questions And Answers","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FJQUERY%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=52e61c98-bcd3-4543-9674-ad0a6737fbca"),
        InterviewBook(15,"Node.JSInterview questions And Answers","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FNODE.JS%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=3b994c1a-875c-4a54-888c-b7f66e9a30e0"),
        InterviewBook(16,"SASS Interview questions And Answers","High","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FSASS%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=8a010f98-e6ea-4257-99b8-fc8e71a40ed9"),
        InterviewBook(17,"SVG Interview questions And Answers","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FSVG%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=fd1200fd-1ab0-45fc-ab50-34921e79acac"),
        InterviewBook(18,"XHTML,XQUERY,Interview Q/A","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FXHTML%2CXQUERY%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=947bd872-ca60-4669-948a-b1fb2684534d"),
        InterviewBook(19,"XML Interview questions And Answers","easy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/Interview%20Questions%2FWeb%20Development%2FXML%20INTERVIEW%20QUESTIONS.pdf?alt=media&token=aa404b9b-21b7-497c-a88d-82215dfcfad2")




/*
        InterviewBook(8,"Interview questions And Answers","easy","")
*/


    )

    var url:String=""
    lateinit var recycleradapter: WebDevelopmentRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<InterviewBook>{book1,book2->
        book1.topic.compareTo(book2.topic,true)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_development)
        SetUpToolbar()
        recyclerJava=findViewById(R.id.recyclerWeb)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= WebDevelopmentRecyclerAdapter(this,bookInfoList)
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
        setSupportActionBar(webtoolbar)
        supportActionBar?.title="Web"
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
