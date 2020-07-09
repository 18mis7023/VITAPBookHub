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
import com.hemanth.vitapbookhub.Adapter.EnglishRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.Book
import kotlinx.android.synthetic.main.activity_english.*
import kotlinx.android.synthetic.main.activity_journals.*
import java.util.*
import kotlin.Comparator

class EnglishActivity : AppCompatActivity() {
    lateinit var recyclersoftware: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<Book>(
        Book("A Basic English Grammer","John Eastwood","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/English%2FA%20Basic%20English%20Grammar%20Exercises%20(John%20Eastwood%2C%201984)%20-%20Book.pdf?alt=media&token=f4fe7905-4c63-4615-b896-02c3ddc70d8f",R.drawable.basic_english_grammer),
        Book("Advancing Vocabulary Skills","Carole Mohr,Sherrie L.Nist","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/English%2FAdvancing%20Vocabulary%20Skills%20(Sherrie%20L.Nist%2C%20Carole%20Mohr%2C%203e%2C%202002)%20-%20Book.pdf?alt=media&token=9bff51d6-f23e-4afa-910e-fbac8e7a8b09",R.drawable.advancing_vocavulary_skills),
        Book("Basic Grammer practice handbook","M.Vijaya","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/English%2FBasic%20Grammar%20Practice%20Handbook%20on%20Tense%20(M.Vijaya%2C%202017)%20-%20Book.pdf?alt=media&token=f5a6ebbf-a7b4-43f7-b1e6-36d6fc74b5a3",R.drawable.basic_grammer_practice),
        Book("Common Errors In English","Paul Hancock","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/English%2FCommon%20Errors%20in%20English%20(Paul%20Hancock)%20-%20Book.pdf?alt=media&token=750f9a6e-903d-4434-a1c6-1e65080384b8",R.drawable.common_errors_in_english),
        Book("English Prepositions Explained","Seth LindStromBerg","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/English%2FEnglish%20Prepositions%20Explained%20(Seth%20Lindstromberg%2C%202010)%20-%20Book.pdf?alt=media&token=96413a7a-9295-4d17-a159-2d84fd0fcfde",R.drawable.english_prepositions),
        Book("English Prounciation in Use Elementary","Don Witcher","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/English%2FEnglish%20Pronunciation%20in%20Use%20Elementary%20(Jonathan%20Marks%2C%202007)%20-%20Book.pdf?alt=media&token=67a27c8d-768d-4dcb-8fe6-8c7322c35301",R.drawable.english_prouncations),
        Book("English Skills with Readings","John Langan","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/English%2FEnglish%20Skills%20with%20Readings%20(John%20Langan%2C%20Zo%C3%A9%20L.Albright%2C%209e%2C%202015)%20-%20Book.pdf?alt=media&token=bd5f7d2b-bda0-4054-84b6-ae234df34b8f",R.drawable.english_skills)
    )

    var url:String=""
    lateinit var recycleradapter: EnglishRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<Book>{book1,book2->
        book1.bookName.compareTo(book2.bookName,true)
    }

    var mydownloadid:Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english)
        SetUpToolbar()
        recyclersoftware=findViewById(R.id.recyclerEnglish)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= EnglishRecyclerAdapter(this,bookInfoList)
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
        setSupportActionBar(englishtoolbar)
        supportActionBar?.title="English"
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
