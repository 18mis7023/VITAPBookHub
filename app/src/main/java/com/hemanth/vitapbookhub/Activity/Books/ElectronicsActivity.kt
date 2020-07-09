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
import com.hemanth.vitapbookhub.Adapter.ElectronicsRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.Book
import kotlinx.android.synthetic.main.activity_electronics.*
import kotlinx.android.synthetic.main.activity_journals.*
import java.util.*
import kotlin.Comparator


class ElectronicsActivity : AppCompatActivity() {

    lateinit var recyclersoftware: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<Book>(
        Book("Analog and Digital Filter Design","Sieve Winder","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Electronics%2FAnalog%20and%20Digital%20Filter%20Design%20(Steve%20Winder%2C%202e%2C%202002)%20-%20Book.pdf?alt=media&token=6b94e767-e72e-43a6-bf26-7ba1e094d8e7",R.drawable.analog_and_digital_filter),
        Book("Arduino Electronics Blueprints","Don Witcher","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Electronics%2FArduino%20Electronics%20Blueprints%20(Don%20Wilcher%2C%202015)%20-%20Book.pdf?alt=media&token=36a3bd90-b25b-44ea-bb61-2adc62b83574",R.drawable.aurdino_electronics),
        Book("Assembly Language For x86 Processors","Kip Irvine","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Electronics%2FAssembly%20Language%20for%20x86%20Processors%20(Kip%20R.Irvine%2C%207e%2C%202015).pdf?alt=media&token=b24cdf4d-ae35-45de-bfee-4996d192fd15",R.drawable.assembly_language),
        Book("Beginning Artificial Intelligence-Raspberry","Donald J. Norris","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Electronics%2FBeginning%20Artificial%20Intelligence%20with%20the%20Raspberry%20Pi%20(Donald%20J.Norris%2C%202017)%20-%20Book-min.pdf?alt=media&token=19dd624c-8b8d-4735-a9c3-ebe64b547603",R.drawable.begining_ai_with_raspberry),
        Book("Beginning C for Arduino","Ph.D Jack Purdum","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Electronics%2FBeginning%20C%20for%20Arduino%20-%20Learn%20C%20Programming%20for%20the%20Arduino%20(Jack%20Purdum%2C%202012)%20-%20Book-min.pdf?alt=media&token=ff06d014-84a3-400a-8887-f2a39a601d6d",R.drawable.begining_c_for_aurdino),
        Book("Digital and Communications System","Don Witcher","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Electronics%2FDigital%20and%20Analog%20Communication%20Systems%20(Leon%20W.Couch%2C%207e%2C%202006)%20-%20Solutions%20Book.pdf?alt=media&token=9f964a92-9606-45cf-b977-9c045e007cb0",R.drawable.digital_and_analog_sollutions),
        Book("Network and Web Applications-Raspberry","Yury Magda","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Electronics%2FNetwork%20and%20Web%20Applications%20Using%20Raspberry%20Pi%2C%20Arduino%20and%20Teensy%20(Yury%20Magda%2C%202015)%20-%20Book.pdf?alt=media&token=4f065f31-b2ec-48c0-8c88-44300f962ad1",R.drawable.network_and_web_applications)
    )

    var url:String=""
    lateinit var recycleradapter: ElectronicsRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<Book>{book1,book2->
        book1.bookName.compareTo(book2.bookName,true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electronics)
        SetUpToolbar()
        recyclersoftware=findViewById(R.id.recyclerElectronics)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= ElectronicsRecyclerAdapter(this,bookInfoList)
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
        setSupportActionBar(elctronicstoolbar)
        supportActionBar?.title="Electronics"
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
