package com.hemanth.vitapbookhub.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.vitapbookhub.Adapter.HomeRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.Book

class LibraryJoournalsActivity : AppCompatActivity() {
    lateinit var recyclerhome: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookList= arrayListOf(
        "1","2","3","4","5","6","7","8","9","10","11","12"
    )
    val bookInfoList= arrayListOf<Book>(
        Book("New Scientist PANDEMIC CARONA ","Penny Sarchet,Rowan Hooper","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/libraryJournals%2F2020-03-07%20New%20Scientist%20(07%20March%2C%202020)%20-%20Magazine.pdf?alt=media&token=a188ef98-eb5b-4ddd-9dcc-e1caac58ef76",R.drawable.new_scientist),
        Book("Android Trics And Tips","Zinio,Cafeyn","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/libraryJournals%2FAndroid%20Tricks%20and%20Tips%20(2020)%20-%20MagBook.pdf?alt=media&token=522803e9-aac1-4dc6-8118-c54915cc680e",R.drawable.android_tricks_and_tips),
        Book("Android For Beginners","Zinio,Cafeyn","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/libraryJournals%2FAndroid%20for%20Beginners%20(June%2C%202020)%20-%20Magazine.pdf?alt=media&token=13c57455-c896-4961-84d2-8ce9a56ae8a1",R.drawable.android_for_beginers),
        Book("HOW INDIA INC.CAN FIGHT BACK","Rajeev Dubey","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/libraryJournals%2FBusiness%20Today%20(19%20April%2C%202020)%20-%20Magazine.pdf?alt=media&token=92add6c4-5a5d-4f15-a968-c1f3ddb567e3",R.drawable.business_today),
        Book("Computer Arts (April-2020)","****","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/libraryJournals%2FComputer%20Arts%20(April%2C%202020)%20-%20Magazine.pdf?alt=media&token=a9b559c7-1cdf-4df1-add6-776afeba6834",R.drawable.computer_arts),
        Book("Design World-Internet of things HandBook (April 2020)","Leland Teschler","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/libraryJournals%2FDesign%20World%20-%20Internet%20of%20Things%20Handbook%20(April%2C%202020)%20-%20Magazine.pdf?alt=media&token=f9317bae-3422-4b43-9484-0a046835eaf0",R.drawable.design_world_internet_of_things),
        Book("Down To Earth","15-Dec 2018","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/libraryJournals%2FDown%20to%20Earth%20(1-15%20Dec.%202018)%20-%20Magazine.pdf?alt=media&token=04f4310b-d373-46ea-8d47-4ed8703bc7aa",R.drawable.down_to_earth),
        Book("Environmental Science","April-May 2020","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/libraryJournals%2FEnvironmental%20Science%20%26%20Engineering%20Magazine%20(April-May%2C%202020)%20-%20Magazine.pdf?alt=media&token=13d68ba5-7cb3-4a10-884b-a6940f43fc5c",R.drawable.environmental_science),
        Book("Google For Beginners","Year 2020","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/libraryJournals%2FGoogle%20for%20Beginners%20(2e%2C%202020)%20-%20Magazine.pdf?alt=media&token=a2eee0aa-4bd1-4993-846b-ce9069982a35",R.drawable.google_trics_and_tips),
        Book("IIT Foundation Series-Mathematics","Year 2018","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/libraryJournals%2FIIT%20Foundation%20Series%20-%20Mathematics%20Practice%20Book%20Class%2010%20(2018)%20-%20Book.pdf?alt=media&token=257c58bb-0d4b-4a22-ba2c-330a43b4a7f1",R.drawable.iit_foundation_mathematics),
        Book("Learn Hot English","Issue 217-2020","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/libraryJournals%2FLearn%20Hot%20English%20(Issue%20217%2C%202020)%20-%20Magazine.pdf?alt=media&token=9a1d1a3f-4e6b-4bd8-9488-7ae04cdbeb7c",R.drawable.learn_hot_english),
        Book("National Geographic UK","June 2020","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/libraryJournals%2FNational%20Geographic%20UK%20(June%2C%202020)%20-%20Magazine.pdf?alt=media&token=5c7003e5-fe87-4669-8579-09e20ff0b51c",R.drawable.national_geographic_last_voices_of_world_war),
        Book("New Scientist International","23 may 20200","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-86e9d.appspot.com/o/libraryJournals%2FNew%20Scientist%20International%20Edition%20(23%20May%2C%202020)%20-%20Magazine.pdf?alt=media&token=199b855c-23cc-4492-96c1-6aef13a7cb0d",R.drawable.new_scientist_your_intelligent_applet)

        )
    var url:String=""
    lateinit var recycleradapter: HomeRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library_joournals)
        recyclerhome=findViewById(R.id.recyclerHome)
        layoutManager=LinearLayoutManager(this)
        recycleradapter= HomeRecyclerAdapter(this,bookInfoList)
        recyclerhome.adapter=recycleradapter
        recyclerhome.layoutManager=layoutManager
        recyclerhome.addItemDecoration(
            DividerItemDecoration(
            recyclerhome.context,
            (layoutManager as LinearLayoutManager).orientation
        ))

    }
}
