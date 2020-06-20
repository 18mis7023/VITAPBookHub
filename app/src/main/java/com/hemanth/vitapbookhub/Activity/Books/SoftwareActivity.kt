package com.hemanth.vitapbookhub.Activity.Books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.vitapbookhub.Adapter.MechanicalRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.SoftwareRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.Book

class SoftwareActivity : AppCompatActivity() {
    lateinit var recyclersoftware: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<Book>(
        Book("Agile Software Development with HP Agile Manager","Liran Tal","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/software%2FAgile%20Software%20Development%20with%20HP%20Agile%20Manager%20(Liran%20Tal%2C%202015).pdf?alt=media&token=7075fef8-f2e3-4dda-91c5-fa3b4ff197b8",R.drawable.agile_software_dvelopment),
        Book("Computer Design and Architecture","Sajjan G.Shiva","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/software%2FComputer%20Design%20and%20Architecture%20(Sajjan%20G.Shiva%2C%203e%2C%202000)%20-%20Book.pdf?alt=media&token=d69842ec-39c4-46fc-8eeb-9dd2722b23d9",R.drawable.design_and_architecture),
        Book("Developing Real World Software","Richard Schlesinger","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/software%2FDeveloping%20Real%20World%20Software%20(Richard%20Schlesinger%2C2010).pdf?alt=media&token=037057e1-ddd0-43a3-b616-9668f00ec0ac",R.drawable.real_world_software),
        Book("E-Commerce SEO for Beginners - Shopping Cart Software Management","S.Holder","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/software%2FE-Commerce%20SEO%20for%20Beginners%20-%20Shopping%20Cart%20Software%20Management%20(S.Holder%2C%202015).pdf?alt=media&token=fb937832-2ce9-49f8-ad25-09ff99b009a1",R.drawable.seo_for_begginers),
        Book("Software Engineering - A Methodical Approach","Elvis C.Foster","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/software%2FSoftware%20Engineering%20-%20A%20Methodical%20Approach%20(Elvis%20C.Foster%2C%202014).pdf?alt=media&token=7c3433bf-feba-474f-a761-ab83938e67f0",R.drawable.software_engineering),
        Book("Software Project Management - A Process-Driven Approach","Ashfaque Ahmed,","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/software%2FSoftware%20Project%20Management%20-%20A%20Process-Driven%20Approach%20(Ashfaque%20Ahmed%2C%202012)%20-%20Book.pdf?alt=media&token=af21a490-327f-4d1a-aa05-54c2d669ecbe",R.drawable.software_project_management),
        Book("Software Technologies - Applications and Foundations","Manuel Mazzara","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/software%2FSoftware%20Technologies%20-%20Applications%20and%20Foundations%20(Manuel%20Mazzara%2C%202018)%20-%20Conference%20Book.pdf?alt=media&token=06e308f0-0e36-4fde-8926-c9ba8d2fd180",R.drawable.software_technologies),
        Book("TCP_IP Architecture,Implementation in Linux","Sameer Seth, M.Ajaykumar","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/software%2FTCP_IP%20Architecture%2C%20Design%2C%20and%20Implementation%20in%20Linux%20(Sameer%20Seth%2C%20M.Ajaykumar%20Venkatesulu%2C%202008)%20-%20Book.pdf?alt=media&token=68cd9c4d-b2ee-4c24-bc1b-9c81f33d2711",R.drawable.architecture_design_implementation_in_linux),
        Book("Testing Computer Software","Cem Kaner, Jack Falk","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/software%2FTesting%20Computer%20Software%20(Cem%20Kaner%2C%20Jack%20Falk%2C%20Hung%20Q.Nguyen%2C%202e)%20-%20Book.pdf?alt=media&token=751f1fe6-af89-4c89-ba4d-d0ad74c882d5",R.drawable.testing_computer_software),
        Book("The Art of Software Architecture Design Methods and Techniques ","Stephen T.Albin","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/software%2FThe%20Art%20of%20Software%20Architecture%20Design%20Methods%20and%20Techniques%20(Stephen%20T.Albin%2C%202003)%20-%20Book.pdf?alt=media&token=ac8f7411-3fa4-4d33-9f85-d873161db1a5",R.drawable.business_rules_applied)
    )

    var url:String=""
    lateinit var recycleradapter: SoftwareRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_software)
        recyclersoftware=findViewById(R.id.recyclersoftware)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= SoftwareRecyclerAdapter(this,bookInfoList)
        recyclersoftware.adapter=recycleradapter
        recyclersoftware.layoutManager=layoutManager
        recyclersoftware.addItemDecoration(
            DividerItemDecoration(
                recyclersoftware.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )
    }
}
