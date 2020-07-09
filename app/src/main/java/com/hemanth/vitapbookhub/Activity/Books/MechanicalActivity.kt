package com.hemanth.vitapbookhub.Activity.Books

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.vitapbookhub.Activity.InterviewActivity
import com.hemanth.vitapbookhub.Activity.LibraryBooksActivity
import com.hemanth.vitapbookhub.Adapter.CivilRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.MechanicalRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.Book
import kotlinx.android.synthetic.main.activity_journals.*
import kotlinx.android.synthetic.main.activity_mechanical.*
import java.util.*
import kotlin.Comparator

class MechanicalActivity : AppCompatActivity() {
    lateinit var recyclermechanical: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val bookInfoList= arrayListOf<Book>(
        Book("Agening of composites","R.Martin","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FMechanical%2FAgeing%20of%20Composites%20(R.Martin%2C%20(Ed.)%2C%202008)%20-%20Book.pdf?alt=media&token=cbc0159d-250a-493a-9a1f-66c19540d8d7",R.drawable.ageing_of_composites),
        Book("Advances in Wave Turbulence","Victo Shira,Sergey Nazarenko","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FMechanical%2FAdvances%20in%20Wave%20Turbulence%20(Victor%20Shrira%2C%20Sergey%20Nazarenko%2C%20(Ed.)%2C%202013)%20-%20Book.pdf?alt=media&token=79755b95-485a-4ae5-9fa4-3181f5174a24",R.drawable.advance_in_wave_turbulance),
        Book("Environmentally Conscious Mechanical Design","Myer Kutz","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FMechanical%2FEnvironmentally%20Conscious%20Mechanical%20Design%20(Myer%20Kutz%2C%20(Ed.)%2C%202007)%20-%20Book.pdf?alt=media&token=05fc45fb-4a3a-451b-bbe3-49bddb9c4c78",R.drawable.mechanical_design),
        Book("Advanced Theory of constraint and motion analysis for robot mechanisms","Jingshan Zhao","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FMechanical%2FAdvanced%20Theory%20of%20Constraint%20and%20Motion%20Analysis%20for%20Robot%20Mechanisms%20(Jingshan%20Zhao%2C%20et%20al.%2C%202014)%20-%20Book.pdf?alt=media&token=45cdb960-3c7e-4550-89ee-ccb006b27542",R.drawable.theory_constraint_motion_analysis),
        Book("Advanced statistical Mechanics","Bary M.McCoy","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FMechanical%2FAdvanced%20Statistical%20Mechanics%20(Barry%20M.McCoy%2C%202010)%20-%20Book.pdf?alt=media&token=918c0789-0f5d-4a6b-b28b-aa3b68112095",R.drawable.advanced_statistical_mechanics),
        Book("Advanced Materials-Mechanics and Applications","Ivan A.Parinov","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FMechanical%2FAdvanced%20Materials%20-%20Manufacturing%2C%20Physics%2C%20Mechanics%20and%20Applications%20(Ivan%20A.Parinov%2C%20et%20al.%2C%20(Ed.)%2C%202016)%20-%20Book.pdf?alt=media&token=b81e9391-3bd8-495d-9b72-42a831fb1572",R.drawable.advanced_materials),
        Book("Advanced Fluid Dynamics","Hyoung Woo oh","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FMechanical%2FAdvanced%20Fluid%20Dynamics%20(Hyoung%20Woo%20Oh%2C%20(Ed.)%2C%202012)%20-%20Book.pdf?alt=media&token=c7ebc391-6263-4c91-a9c5-b0c129890303",R.drawable.advanced_fluid_dynamics),
        Book("Advanced Energy Design Guide for Small Retail Buildings","Ashrae","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FMechanical%2FAdvanced%20Energy%20Design%20Guide%20for%20Small%20Retail%20Buildings%20(ASHRAE%2C%202006)%20-%20Book.pdf?alt=media&token=e4f647c7-4f27-47bb-a599-43cec9e467da",R.drawable.advanced_energy_design),
        Book("A Mathematical Introduction to Fluid Mechanics","Alexandre Chorin","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FMechanical%2FA%20Mathematical%20Introduction%20to%20Fluid%20Mechanics%20(Alexandre%20Chorin%2C%20Jerrold%20E.%20Marsden%2C%201992)%20-%20Book.pdf?alt=media&token=abbda233-63b5-46b7-8c27-2e1af3093d23",R.drawable.fluid_mechanics),
        Book("A first cours in fluid dynamics","A.R.Paterson","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FMechanical%2FA%20First%20Course%20in%20Fluid%20Dynamics%20(A.R.Paterson)%20-%20Book.pdf?alt=media&token=e5b3c435-7252-458d-b942-5e0a3d6c32cf",R.drawable.fluid_dynamics),
        Book("3D Shape-Its Unique Place in Visual Perception","Zygmunt Pizlo","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FMechanical%2F3D%20Shape%20-%20Its%20Unique%20Place%20in%20Visual%20Perception%20(Zygmunt%20Pizlo%2C%202008)%20-%20Book.pdf?alt=media&token=0679b76f-2fac-422c-baf0-d104d231c0b4",R.drawable.d_shape_visual_perception),
        Book("3D printing in space","**2020**","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FMechanical%2F3D%20Printing%20in%20Space%20(2014)%20-%20Book.pdf?alt=media&token=d9891745-c1a6-4f03-8400-a0dbab69655a",R.drawable.d_printing_in_space),
        Book("3D Fibrous Assemblies-Properties, Applications","Jack Hu","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FMechanical%2F3-D%20Fibrous%20Assemblies%20-%20Properties%2C%20Applications%20and%20Modelling%20of%20Three-Dimensional%20Textile%20Structures%20(Jack%20Hu%2C%202008)%20-%20Book.pdf?alt=media&token=94c49bfd-5cd5-472e-97e0-e305b28ba462",R.drawable.d_fibrous_assemblies),
        Book("1001 Solved Engineering Fundamentals Problems","Michael R.Linderburg","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FMechanical%2F1001%20Solved%20Engineering%20Fundamentals%20Problems%20(Michael%20R.Lindeburg%2C%203e%2C%202005)%20-%20Book.pdf?alt=media&token=b0221481-a6d9-49dc-99a6-e1b0dd2393c5",R.drawable.engineering_fundamentals),
        Book("100 Volumes of 'Notes on Numerical Fluid Mechanics","Ernst Heinrich,Egon Krause","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FMechanical%2F100%20Volumes%20of%20'Notes%20on%20Numerical%20Fluid%20Mechanics'%20(Ernst%20Heinrich%20Hirschel%2C%20Egon%20Krause%2C%20(Ed.)%2C%202009)%20-%20Book.pdf?alt=media&token=3b79e919-e74d-4b27-8151-53c4bfce5ece",R.drawable.volumes_of_fluid_mechanics)
    )

    var url:String=""
    lateinit var recycleradapter: MechanicalRecyclerAdapter
    var order=-1
    var ratingcomparator=Comparator<Book>{book1,book2->
        book1.bookName.compareTo(book2.bookName,true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mechanical)
        SetUpToolbar()
        recyclermechanical=findViewById(R.id.recyclermechanical)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= MechanicalRecyclerAdapter(this,bookInfoList)
        recyclermechanical.adapter=recycleradapter
        recyclermechanical.layoutManager=layoutManager
        recyclermechanical.addItemDecoration(
            DividerItemDecoration(
                recyclermechanical.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )
    }
    fun SetUpToolbar(){
        setSupportActionBar(tmechanicaloolbar)
        supportActionBar?.title="Mechanical"
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
