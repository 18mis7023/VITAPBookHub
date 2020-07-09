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
import com.hemanth.vitapbookhub.Adapter.ComputerRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.SoftwareRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.Book
import kotlinx.android.synthetic.main.activity_computer.*
import kotlinx.android.synthetic.main.activity_electronics.*
import kotlinx.android.synthetic.main.activity_english.*
import kotlinx.android.synthetic.main.activity_journals.*
import java.util.*
import kotlin.Comparator

class ComputerActivity : AppCompatActivity() {

    lateinit var recyclersoftware: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<Book>(
        Book("advances in Artificial Intelligence","Frank Rudzicz","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/computer%2FAdvances%20in%20Artificial%20Intelligence%20(Marie-Jean%20Meurs%2C%20Frank%20Rudzicz%2C%20(Ed.)%2C%202019)%20-%20Conference%20Book_compressed.pdf?alt=media&token=1a162ada-afcf-4c02-bf17-c5c286af2ed9",R.drawable.advantages_in_artificial_intelligence),
        Book("Advances in Soft Computing","Sabino Mirandra-Jimenez","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/computer%2FAdvances%20in%20Soft%20Computing%20(Obdulia%20Pichardo-Lagunas%2C%20Sabino%20Miranda-Jim%C3%A9nez%2C%20(Ed.)%2C%20Part%202%2C%202017)%20-%20Book_compressed.pdf?alt=media&token=0aa679a0-9218-4892-b2f7-21aa5294916a",R.drawable.adv_in_soft_computing),
        Book("Android studio development","Neil Smyth","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/computer%2FAndroid%20Studio%20Development%20Essentials%20(Neil%20Smyth%2C%202015)%20-%20Book.pdf?alt=media&token=3bcc0b8d-a39c-448f-a767-282c086d74d6",R.drawable.androidstudio_development),
        Book("Apache Server unleashed","Rich Bowen","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/computer%2FApache%20Server%20Unleashed%20(Rich%20Bowen%2C%20Ken%20Coar%2C%20et%20al.%2C%202000)%20-%20Book.pdf?alt=media&token=9762ba77-a458-4304-b960-d1adae248710",R.drawable.apache_server),
        Book("Building Java Programs","Marty Stepp","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/computer%2FBuilding%20Java%20Programs%20%E2%80%93%20A%20Back%20to%20Basics%20Approach%20(Stuart%20Reges%2C%20Marty%20Stepp)%20-%20Book.pdf?alt=media&token=f8d13c86-4ef0-44f3-9b1f-e15f3ded2160",R.drawable.building_java_programs),
        Book("C Programming in Linux","Atmospheric Pollution","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/computer%2FC%20Programming%20in%20Linux%20(Atmospheric%20Pollution%2C%202009)%20-%20Book.pdf?alt=media&token=d05651c6-55a2-47f6-808b-6af2c4748472",R.drawable.c_programming_in_linux)
    )

    var url:String=""
    lateinit var recycleradapter: ComputerRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<Book>{book1,book2->
        book1.bookName.compareTo(book2.bookName,true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computer)
        SetUpToolbar()
        recyclersoftware=findViewById(R.id.recyclerComputer)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= ComputerRecyclerAdapter(this,bookInfoList)
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
        setSupportActionBar(computertoolbar)
        supportActionBar?.title="Computer"
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
