package com.hemanth.vitapbookhub.Activity

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.hemanth.vitapbookhub.Adapter.ComputerRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.HomeRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.JournalsRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.Book
import kotlinx.android.synthetic.main.activity_civil.*
import kotlinx.android.synthetic.main.activity_computer.*
import kotlinx.android.synthetic.main.activity_journals.*
import java.util.*
import kotlin.Comparator


class JournalsActivity : AppCompatActivity() {


    lateinit var recyclersoftware: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<Book>(
        Book("Boundaries to yes,how to say No","John TownSend","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Journals%2FBoundaries_%20When%20to%20Say%20Yes%2C%20How%20to%20Say%20No%20to%20Take%20Control%20of%20Your%20Life.pdf?alt=media&token=f21c46f9-9ffb-45dc-a2df-3257d5f11bb8",R.drawable.boundaries),
        Book("Change Your Life in unexpected ways","Dallas,Melissa HartWig","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Journals%2FIt%20Starts%20with%20Food_%20Discover%20the%20Whole30%20and%20Change%20Your%20Life%20in%20Unexpected%20Ways.pdf?alt=media&token=2f16f8a3-679f-41f2-a1cb-bf438e8f2e65",R.drawable.starts_with_food),
        Book("The Language Of Law School","Elizabeth Mertz","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Journals%2FLearning%20to%20%E2%80%9CThink%20Like%20a%20Lawyer%E2%80%9D.pdf?alt=media&token=3480b6b6-15e5-4a5f-bfa3-4ee7a1a13506",R.drawable.language_of_law_school),
        Book("Living in a Light","Shakti Gawain","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Journals%2FLiving%20in%20the%20Light_%20A%20guide%20to%20personal%20transformation%20PDFDrive.com%20).pdf?alt=media&token=5c1a2302-376b-4427-9c8d-83e5f222c86e",R.drawable.living_in_the_light),
        Book("No God But God","Marty Stepp","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Journals%2FNo%20god%20but%20God_%20The%20Origins%2C%20Evolution%2C%20and%20Future%20of%20Islam.pdf?alt=media&token=bce57f72-581c-4274-bf7e-79bc857a8d32",R.drawable.no_god_but_god),
        Book("One Indian Girl","Atmospheric Pollution","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Journals%2FOne_Indian_Girl.pdf?alt=media&token=1e70635d-20b2-40cd-bbc3-c819ec8a4e31",R.drawable.one_indian_girl)
        )

    var url:String=""
    lateinit var recycleradapter: JournalsRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<Book>{ book1, book2->
        book1.bookName.compareTo(book2.bookName,ignoreCase = true)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journals)
        SetUpToolbar()
        recyclersoftware=findViewById(R.id.recyclerJournals)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= JournalsRecyclerAdapter(this,bookInfoList)
        recyclersoftware.adapter=recycleradapter
        recyclersoftware.layoutManager=layoutManager
        recyclersoftware.addItemDecoration(
            DividerItemDecoration(
                recyclersoftware.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )

    }
    fun SetUpToolbar(){
        setSupportActionBar(journaltoolbar)
        supportActionBar?.title="Journals"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item?.itemId
        if(id==android.R.id.home)
        {
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }
        when(id)
        {
            android.R.id.home ->{
                startActivity(Intent(this,HomeActivity::class.java))
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
