package com.hemanth.vitapbookhub.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.hemanth.vitapbookhub.Fragment.*
import com.hemanth.vitapbookhub.R

class HomeActivity : AppCompatActivity() {
    lateinit var drawerlayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var frame: FrameLayout
    lateinit var toolbar:androidx.appcompat.widget.Toolbar
    lateinit var navigationview: NavigationView
    var bundle=Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        /*if(intent!=null)
        {
            var email=intent.getStringExtra("email")
        }*/

        var previousMenuItem: MenuItem?=null
        drawerlayout=findViewById(R.id.drawerlayout)
        coordinatorLayout=findViewById(R.id.coordinatorLayout)
        frame=findViewById(R.id.frame)
        toolbar=findViewById(R.id.toolbar)
        navigationview=findViewById(R.id.navigation)
        SetUpToolbar()
        val actionBarDrawerToggle=
            ActionBarDrawerToggle(this@HomeActivity,drawerlayout,
                R.string.open_drawer,
                R.string.close_drawer
            )
        drawerlayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        openDashboardFragment()
        var bundle=Bundle()
        bundle.putString("email",intent.getStringExtra("email"))
        navigationview.setNavigationItemSelectedListener {
            if(previousMenuItem!=null){
                previousMenuItem?.isChecked=false
            }
            it.isCheckable=true
            it.isChecked=true
            previousMenuItem=it
            when(it.itemId)
            {
                R.id.dashboard ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        HomeFragment()
                    ).commit()
                    drawerlayout.closeDrawers()
                    supportActionBar?.title="Home"
                }
                R.id.profile ->{

                    var frag=ProfileFragment()
                    frag.arguments=bundle
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        frag
                    )
                        .commit()

                    drawerlayout.closeDrawers()
                    supportActionBar?.title="Profile"
                }
                R.id.aboutUs ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        AboutUsFragment()
                    ).commit()
                    drawerlayout.closeDrawers()
                    supportActionBar?.title="About Us"
                }
                R.id.favourites ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        FavoritesFragment()
                    ).commit()
                    drawerlayout.closeDrawers()
                    supportActionBar?.title="Favourites"
                }
                R.id.logout ->{
                    var frag=LogoutFragment()
                    frag.arguments=bundle
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        frag
                    ).commit()
                    drawerlayout.closeDrawers()
                    supportActionBar?.title="Logout"
                }

            }
            return@setNavigationItemSelectedListener true
        }

    }
    fun openDashboardFragment()
    {
        val fragment= HomeFragment()
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(
            R.id.frame,
            HomeFragment()
        )
        transaction.commit()
        supportActionBar?.title="DashBoard"
        navigationview.setCheckedItem(R.id.dashboard)
        drawerlayout.closeDrawers()

    }

    override fun onBackPressed() {
        val frag=supportFragmentManager.findFragmentById(R.id.frame)

        when(frag){
            !is HomeFragment -> openDashboardFragment()
            else ->super.onBackPressed()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id=item.itemId

        if(id==android.R.id.home)
        {
            drawerlayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)


    }
    fun SetUpToolbar()
    {
        setSupportActionBar(toolbar)
        supportActionBar?.title="Toolbar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}
