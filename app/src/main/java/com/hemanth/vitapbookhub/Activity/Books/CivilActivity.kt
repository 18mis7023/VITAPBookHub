package com.hemanth.vitapbookhub.Activity.Books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.vitapbookhub.Adapter.CivilRecyclerAdapter
import com.hemanth.vitapbookhub.Adapter.HomeRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.Book

class CivilActivity : AppCompatActivity() {
    lateinit var recyclercivil: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager

    val bookInfoList= arrayListOf<Book>(
        Book("The Complete Idiots Guide to Green Building and Remodeling","John Barrows,Lisa Iannucci","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FThe%20Complete%20Idiot%EF%BF%BDs%20Guide%20to%20Green%20Building%20and%20Remodeling%20(John%20Barrows%2C%20Lisa%20Iannucci%2C%202009)%20-%20Book.pdf?alt=media&token=af664bd2-de0b-4b6c-9422-3335cc445dd6",R.drawable.building_remodelling),
        Book("Repair,Protection and Waterproofing of Concrete Structures","P.H.Perkins","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FRepair%2C%20Protection%20and%20Waterproofing%20of%20Concrete%20Structures%20(P.H.Perkins%2C%203e%2C%201997)%20-%20Book.pdf?alt=media&token=e1c21da7-0841-46ca-bcc0-88ab9d3a6a7b",R.drawable.concrete_structures),
        Book("Military and Civilian Pyrotechnics","Herbert Ellern","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FMilitary%20and%20Civilian%20Pyrotechnics%20(Herbert%20Ellern%2C%201968)%20-%20Book.pdf?alt=media&token=60b14b08-58d0-47d3-b8af-68cda0f977ae",R.drawable.military_civil_pyrotechnics),
        Book("Managing the Building Design Process","Gavin Tunstall","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FManaging%20the%20Building%20Design%20Process%20(Gavin%20Tunstall%2C%202e%2C%202006)%20-%20Book.pdf?alt=media&token=88131caf-bfa3-493d-8b12-eda5281befa8",R.drawable.building_design_process),
        Book("Geosynthetics in Civil Engineering","R.W.Sarsby","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FGeosynthetics%20in%20Civil%20Engineering%20(R.W.Sarsby%2C%20(Ed.)%2C%202007)%20-%20Book.pdf?alt=media&token=6febfced-c93d-4252-ae72-3b178747d9a9",R.drawable.geosynthetics_civil_engineering),
        Book("Environmental Aspects of Construction with Waste Materials","Elsevier","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FEnvironmental%20Aspects%20of%20Construction%20with%20Waste%20Materials%20(1994)%20-%20Conference%20Book.pdf?alt=media&token=a73262dd-2b0e-49c8-b3d6-247bd5189f59",R.drawable.construction_with_waste_materials),
        Book("Engineering Geology\n","F.G.Bell","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FEngineering%20Geology%20(F.G.Bell%2C%202e%2C%202007)%20-%20Book.pdf?alt=media&token=67ba8099-bb25-488c-82c6-9c4a817248cd",R.drawable.engineering_geology),
        Book("Dictionary of Construction Terms","Fenwick Elliot LLP","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FDictionary%20of%20Construction%20Terms%20(Simon%20Tolson%2C%20Jeremy%20Glover%2C%20Stacy%20Sinclair%2C%20(Ed.)%2C%202012)%20-%20Book.pdf?alt=media&token=ed6df169-f9ca-4d10-96fc-db9ab856f6e7",R.drawable.construction_terms),
        Book("Dams in Japan-Past,Present,Future","Japan Commission","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FDams%20in%20Japan%20-%20Past%2C%20Present%20and%20Future%20(2009)%20-%20Book.pdf?alt=media&token=326e37a6-7b6e-423f-9701-202ff4f7f98d",R.drawable.dams_in_japan),
        Book("Challenges,Opportunities,Solutions in Structural Engineering","Nader Ghafoori","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FChallenges%2C%20Opportunities%20and%20Solutions%20in%20Structural%20Engineering%20and%20Construction%20(Nader%20Ghafoori%2C%20(Ed.)%2C%202010)%20-%20Conference%20Book.pdf?alt=media&token=bd1a506f-9e94-47cf-9fd8-b7bd3a633065",R.drawable.challenges_oppurtunities_structural_engineering),
        Book("An Introduction to Excel for Civil Enginners","Gunthar Pangaribuan","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FAn%20Introduction%20to%20Excel%20for%20Civil%20Engineers%20(Gunthar%20Pangaribuan%2C%202016)%20-%20Book.pdf?alt=media&token=3313d475-88d8-44b7-86da-4430bfb0640b",R.drawable.civil_engineers),
        Book("A Changing World-Challenges for Landscape Research","Sucharitha Ghosh,Felix Kienast","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FA%20Changing%20World%20-%20Challenges%20for%20Landscape%20Research%20(Felix%20Kienast%2C%20Otto%20Wildi%2C%20Sucharita%20Ghosh%2C%20(Ed.)%2C%202007)%20-%20Book.pdf?alt=media&token=30344498-f1ba-4a3a-820f-a5e477d9edef",R.drawable.changing_world),
        Book("100 Home Design Principles","Arthur Gao","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2F100%20Home%20Design%20Principles%20-%20Book.pdf?alt=media&token=ca1b0650-017a-43df-a682-3afa8a7916f8",R.drawable.home_design_principles),
        Book("Urban Microclimate","Evyatar Erell,David Pearlmutter","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FUrban%20Microclimate%20-%20Designing%20the%20Spaces%20Between%20Buildings%20(Evyatar%20Erell%2C%20David%20Pearlmutter%2C%20Terry%20Williamson%2C%202011)%20-%20Book.pdf?alt=media&token=996e547f-6a62-4be5-851d-454f9925c381",R.drawable.urban_microclimate),
        Book("Wind Issues in the Design of Buildings","American Society of Civil Engineers","https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-9c2cc.appspot.com/o/Civil%20%2FWind%20Issues%20in%20the%20Design%20of%20Buildings%20(Leighton%20Cochran%2C%202012)%20-%20Book.pdf?alt=media&token=a8ecbef4-6940-4b2d-85da-c013f57bf55f",R.drawable.wind_issues)
    )

    var url:String=""
    lateinit var recycleradapter: CivilRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_civil)

        recyclercivil=findViewById(R.id.recyclerCivil)
        layoutManager= LinearLayoutManager(this)
        recycleradapter= CivilRecyclerAdapter(this,bookInfoList)
        recyclercivil.adapter=recycleradapter
        recyclercivil.layoutManager=layoutManager
        recyclercivil.addItemDecoration(
            DividerItemDecoration(
                recyclercivil.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )

    }
}
