package com.hemanth.vitapbookhub.Activity.Books

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hemanth.vitapbookhub.R
import kotlinx.android.synthetic.main.activity_maths.*
import java.net.URL

class MathsActivity : AppCompatActivity() {
    var mydownloadid:Long = 0
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maths)
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
        btnDownloadGilbert.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/MathsBooks%2F%5BStrang_G.%5D_Linear_algebra_and_its_applications.PDF?alt=media&token=94991b45-1670-4c95-844c-4eadb982d60d"
            var request=DownloadManager.Request(Uri.parse(url))
                .setTitle("Linear Algebra and Its applications")
                .setDescription("Linear Algebra and its application Gilbert is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
             //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm:DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadHarold.setOnClickListener {
             var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/MathsBooks%2FAdvanced%20Calculus%20-%20A%20Differential%20Forms%20Approach%20(Harold%20M.Edwards%2C%202014).pdf?alt=media&token=22864931-0564-4ad5-a293-c1d62bb4ace9"
             var request=DownloadManager.Request(Uri.parse(url))
                 .setTitle("Advanced Calculus - A Differential Forms")
                 .setDescription("Advanced Calculus is Downloading ")
                 .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                 .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
             //   .setAllowedOverMetered(false)
             //    .setAllowedOverMetered(true)
             var dm:DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
             mydownloadid=dm.enqueue(request)
         }

        btnDownloadElliott.setOnClickListener {
             var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/MathsBooks%2F3000%20Solved%20Problems%20in%20Calculus%20(Elliot%20Mendelson%2C%201988).pdf?alt=media&token=28a9bb1a-1b83-4187-80e9-74354d829b54"
             var request=DownloadManager.Request(Uri.parse(url))
                 .setTitle("3000 problems solved - Advanced Calculus")
                 .setDescription("3000 problems solved - Advanced Calculus is Downloading ")
                 .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                 .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
             //   .setAllowedOverMetered(false)
             //    .setAllowedOverMetered(true)
             var dm:DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
             mydownloadid=dm.enqueue(request)
         }

        btnDownloadAlex.setOnClickListener {
             var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/MathsBooks%2F1300%20Math%20Formulas%20(Alex%20Svirin%2C%202004).pdf?alt=media&token=dfb084bd-6eda-4b4f-890e-8ac31ed6459c"
             var request=DownloadManager.Request(Uri.parse(url))
                 .setTitle("1300 Maths Formulas")
                 .setDescription("1300 formulas in Mathematics ")
                 .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                 .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
             //   .setAllowedOverMetered(false)
             //    .setAllowedOverMetered(true)
             var dm:DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
             mydownloadid=dm.enqueue(request)
         }


        var br=object:BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?) {
                var id:Long?=p1?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1)
                if(id==mydownloadid)
                {
                    Toast.makeText(applicationContext,"successfully Downloaded the file .... downloaded file in Downloads ",Toast.LENGTH_SHORT).show()
                }
            }
        }
        registerReceiver(br, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
    }
}
