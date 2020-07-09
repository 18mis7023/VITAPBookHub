package com.hemanth.vitapbookhub.Activity.Books

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.vitapbookhub.Activity.LibraryBooksActivity
import com.hemanth.vitapbookhub.Adapter.PhysicsRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.SoftwareRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.Book
import kotlinx.android.synthetic.main.activity_electronics.*
import kotlinx.android.synthetic.main.activity_physics.*
import java.util.*
import kotlin.Comparator

class PhysicsActivity : AppCompatActivity() {
    lateinit var recyclerphysics: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<Book>(
        Book("2D Materials - Properties and Devices","Phaedon Avouris, Tony F.Heinz","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Physics%2F2D%20Materials%20-%20Properties%20and%20Devices%20(Phaedon%20Avouris%2C%20Tony%20F.Heinz%2C%20Tony%20Low%2C%20(Ed.)%2C%202017)%20-%20Book.pdf?alt=media&token=b6959510-fd3a-40c2-bd39-caa177473988",R.drawable.properties_and_devices),
        Book("3+1 Formalism in General Relativity - Bases of Numerical Relativity","Ric Gourgoulhon","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Physics%2F3%2B1%20Formalism%20in%20General%20Relativity%20-%20Bases%20of%20Numerical%20Relativity%20(%EF%BF%BDric%20Gourgoulhon%2C%202012)%20-%20Book.pdf?alt=media&token=6da2acce-1fb1-45d2-8b05-a21b1a677270",R.drawable.formalisn),
        Book("3D Laser Microfabrication-Principles","Hiroaki Misawa,Saulius Juodkazis","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Physics%2F3D%20Laser%20Microfabrication%20-%20Principles%20and%20Applications%20(Hiroaki%20Misawa%2C%20Saulius%20Juodkazis%2C%20(Ed.)%2C%202006)%20-%20Book.pdf?alt=media&token=927e54c2-b35c-4cb9-af28-666fba1ed736",R.drawable.d_laser_microfabrication),
        Book("5 Steps to a 5 - AP Physics B and C 2008-09","Greg Jacobs","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Physics%2F5%20Steps%20to%20a%205%20-%20AP%20Physics%20B%20and%20C%202008-09%20(Greg%20Jacobs%2C%20Josh%20Schulman%2C%202008)%20-%20Book.pdf?alt=media&token=2618575e-ef7d-4b96-b662-f22ddd634d21",R.drawable.ap_physics_b_c),
        Book("21st Century Astronomy","Laura Kay","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Physics%2F21st%20Century%20Astronomy%20(Laura%20Kay%2C%20et%20al.%2C%202013)%20-%20Book.pdf?alt=media&token=aaecda40-19ee-43c8-b8a1-7f24fd9ca32f",R.drawable.century_astronomy),
        Book("46 Science Fair Projects for the Evil Genius","Bob Bonnet,Dan Kennen","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Physics%2F46%20Science%20Fair%20Projects%20for%20the%20Evil%20Genius%20(Bob%20Bonnet%2C%20Dan%20Keen%2C%202009)%20-%20Book.pdf?alt=media&token=43751bd9-de55-41ca-b94f-56202abce77c;",R.drawable.science_fair_projects),
        Book("100 Greatest Science Discoveries of All Time","Kendall Haven","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Physics%2F100%20Greatest%20Science%20Discoveries%20of%20All%20Time%20(Kendall%20Haven%2C%202007)%20-%20Book.pdf?alt=media&token=e1d50320-cfc5-4882-b1e3-3795dee8b1b1",R.drawable.greatest_science),
        Book("1000 Solved Problems in Modern Physics","Ahmad A.Kamal","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Physics%2F1000%20Solved%20Problems%20in%20Modern%20Physics%20(Ahmad%20A.Kamal%2C%202010)%20-%20Book.pdf?alt=media&token=9e0be89a-f6d9-44a5-a0d4-df240f26801c",R.drawable.modern_physics),
        Book("A Comprehensive Text Book of Applied Physics","Kumar Manoj","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Physics%2FA%20Comprehensive%20Text%20Book%20of%20Applied%20Physics%20(Kumar%20Manoj%2C%202009)%20-%20Book.pdf?alt=media&token=98ef0ffe-3186-4585-8ade-b75d8e0ebf73",R.drawable.applied_physics),
        Book("A Modern Introduction to Quantum Field Theory","Michele Maggiore","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Physics%2FA%20Modern%20Introduction%20to%20Quantum%20Field%20Theory%20(Michele%20Maggiore%2C%202005)%20-%20Book.pdf?alt=media&token=535fab9f-afd9-41ac-8873-6920be3cfd7f",R.drawable.quantum_field_theory),
        Book("A Students Guide Through the Great Physics Magnetism and Light","Kerry Kuehn","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Physics%2FA%20Student%EF%BF%BDs%20Guide%20Through%20the%20Great%20Physics%20Texts%20%EF%BF%BD%203.%20Electricity%2C%20Magnetism%20and%20Light%20(Kerry%20Kuehn%2C%202016)%20-%20Book.pdf?alt=media&token=61b08b30-d13d-45ff-955c-1e89440920f1",R.drawable.great_physics_texts),
        Book("Adsorption and Diffusion in Nanoporous Materials","Rolando M.A.Roque-Malherbe","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Physics%2FAdsorption%20and%20Diffusion%20in%20Nanoporous%20Materials%20(Rolando%20M.A.Roque-Malherbe%2C%202e%2C%202018)%20-%20Book.pdf?alt=media&token=f3ae9ab9-b955-492a-be41-3d7afdba15d3",R.drawable.adsorption_and_diffusion),
        Book("Advanced fiber optics-concepts and Technology","Luc Thvenaz","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Physics%2FAdvanced%20Fiber%20Optics%20-%20Concepts%20and%20Technology%20(Luc%20Th%EF%BF%BDvenaz%2C%20(Ed.)%2C%202011)%20-%20Book.pdf?alt=media&token=f62fba35-79de-415e-a374-839fa9bb9dde",R.drawable.advanced_fibre_optics),
        Book("Advanced Modern Physics - Theoretical Foundations","John Dirk Walecka","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Physics%2FAdvanced%20Modern%20Physics%20-%20Theoretical%20Foundations%20(John%20Dirk%20Walecka%2C%202010)%20-%20Book.pdf?alt=media&token=3b60c2dd-2b2f-43e7-bee4-8820a8998c18",R.drawable.advanced_modern_physics),
        Book("Advances in Solid State Physics","Rolf Haug","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Physics%2FAdvances%20in%20Solid%20State%20Physics%20(Rolf%20Haug%2C%20(Ed.)%2C%20Vol.46%2C%202008)%20-%20Book.pdf?alt=media&token=cfa872e3-8901-4f48-b0a4-89a8445b2396",R.drawable.solid_state_physics)
    )

    var url:String=""
    lateinit var recycleradapter: PhysicsRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<Book>{book1,book2->
        book1.bookName.compareTo(book2.bookName,true)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics)
        SetUpToolbar()
        recyclerphysics=findViewById(R.id.recyclersoftware)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= PhysicsRecyclerAdapter(this,bookInfoList)
        recyclerphysics.adapter=recycleradapter
        recyclerphysics.layoutManager=layoutManager
        recyclerphysics.addItemDecoration(
            DividerItemDecoration(
                recyclerphysics.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )

    }
    fun SetUpToolbar(){
        setSupportActionBar(physicstoolbar)
        supportActionBar?.title="Physics"
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
