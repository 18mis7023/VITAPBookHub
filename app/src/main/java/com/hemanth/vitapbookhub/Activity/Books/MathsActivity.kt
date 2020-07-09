package com.hemanth.vitapbookhub.Activity.Books

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.vitapbookhub.Activity.InterviewActivity
import com.hemanth.vitapbookhub.Activity.LibraryBooksActivity
import com.hemanth.vitapbookhub.Adapter.MathsRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.SoftwareRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.Book
import kotlinx.android.synthetic.main.activity_journals.*
import kotlinx.android.synthetic.main.activity_maths.*
import java.net.URL
import java.util.*
import kotlin.Comparator

class MathsActivity : AppCompatActivity() {
    lateinit var recyclersoftware: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<Book>(
        Book("Linear Algebra and Its applications","Gilbert strang","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/MathsBooks%2F%5BStrang_G.%5D_Linear_algebra_and_its_applications.PDF?alt=media&token=94991b45-1670-4c95-844c-4eadb982d60d",R.drawable.linearalgebra_gilbert_strang),
        Book("Advanced Calculus-A Differential Forms","Harold M.Edwards","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/MathsBooks%2FAdvanced%20Calculus%20-%20A%20Differential%20Forms%20Approach%20(Harold%20M.Edwards%2C%202014).pdf?alt=media&token=22864931-0564-4ad5-a293-c1d62bb4ace9",R.drawable.advanced_calculus),
        Book("3000 problems solved in Calculus","Elliott Mendelson","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/MathsBooks%2F3000%20Solved%20Problems%20in%20Calculus%20(Elliot%20Mendelson%2C%201988).pdf?alt=media&token=28a9bb1a-1b83-4187-80e9-74354d829b54",R.drawable.calculus_problems_solved),
        Book("1300-Math Formulas","Alex svirin,Ph.D","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/MathsBooks%2F1300%20Math%20Formulas%20(Alex%20Svirin%2C%202004).pdf?alt=media&token=dfb084bd-6eda-4b4f-890e-8ac31ed6459c",R.drawable.formulas_maths)
    )
    var url:String=""
    lateinit var recycleradapter: MathsRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<Book>{book1,book2->
        book1.bookName.compareTo(book2.bookName,true)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maths)
        SetUpToolbar()
        recyclersoftware=findViewById(R.id.recyclerMathematics)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= MathsRecyclerAdapter(this,bookInfoList)
        recyclersoftware.adapter=recycleradapter
        recyclersoftware.layoutManager=layoutManager
        recyclersoftware.addItemDecoration(
            DividerItemDecoration(
                recyclersoftware.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )
        /*btnView.setOnClickListener{
            *//*Declaring the intent which sets up the route for the navigation of the activity*//*
            val intent = Intent(this, DownloadViewActivity::class.java)
            val bundle = Bundle()
            *//*Setting a value data which is activity specific. This will be used to identify from where the data was sent*//*
            bundle.putString("data", "View")

            *//*Putting the values in Bundle*//*
            bundle.putString("bookname", txtLinearAlgebra.text.toString())
            bundle.putString("author", txtGilbert.text.toString())
            bundle.putString("url", url)

            intent.putExtra("details", bundle)
            startActivity(intent)
        }*/
    }
    fun SetUpToolbar(){
        setSupportActionBar(mathstoolbar)
        supportActionBar?.title="Maths"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item?.itemId
        when(id)
        {
            android.R.id.home ->{
                startActivity(Intent(this, LibraryBooksActivity::class.java))
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
