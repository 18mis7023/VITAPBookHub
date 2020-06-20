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
import kotlinx.android.synthetic.main.activity_computer.*
import kotlinx.android.synthetic.main.activity_english.*

class ComputerActivity : AppCompatActivity() {
    var mydownloadid:Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computer)

        btnDownloadFrank.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/computer%2FAdvances%20in%20Artificial%20Intelligence%20(Marie-Jean%20Meurs%2C%20Frank%20Rudzicz%2C%20(Ed.)%2C%202019)%20-%20Conference%20Book_compressed.pdf?alt=media&token=1a162ada-afcf-4c02-bf17-c5c286af2ed9"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtAAI.text.toString())
                .setDescription("${txtAAI.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadsabino.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/computer%2FAdvances%20in%20Soft%20Computing%20(Obdulia%20Pichardo-Lagunas%2C%20Sabino%20Miranda-Jim%C3%A9nez%2C%20(Ed.)%2C%20Part%202%2C%202017)%20-%20Book_compressed.pdf?alt=media&token=0aa679a0-9218-4892-b2f7-21aa5294916a"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtASC.text.toString())
                .setDescription("${txtASC.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadNeil.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/computer%2FAndroid%20Studio%20Development%20Essentials%20(Neil%20Smyth%2C%202015)%20-%20Book.pdf?alt=media&token=3bcc0b8d-a39c-448f-a767-282c086d74d6"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtASDE.text.toString())
                .setDescription("${txtASDE.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadRich.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/computer%2FApache%20Server%20Unleashed%20(Rich%20Bowen%2C%20Ken%20Coar%2C%20et%20al.%2C%202000)%20-%20Book.pdf?alt=media&token=9762ba77-a458-4304-b960-d1adae248710"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtASU.text.toString())
                .setDescription("${txtASU.text.toString()} is downloading")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadMarty.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/computer%2FBuilding%20Java%20Programs%20%E2%80%93%20A%20Back%20to%20Basics%20Approach%20(Stuart%20Reges%2C%20Marty%20Stepp)%20-%20Book.pdf?alt=media&token=f8d13c86-4ef0-44f3-9b1f-e15f3ded2160"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtBJPrograms.text.toString())
                .setDescription("${txtBJPrograms.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadATM.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/computer%2FC%20Programming%20in%20Linux%20(Atmospheric%20Pollution%2C%202009)%20-%20Book.pdf?alt=media&token=d05651c6-55a2-47f6-808b-6af2c4748472"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtCPLinux.text.toString())
                .setDescription("${txtCPLinux.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }




        var br=object: BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?) {
                var id:Long?=p1?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1)
                if(id==mydownloadid)
                {
                    Toast.makeText(applicationContext,"successfully Downloaded the file .... downloaded file in Downloads ",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
        registerReceiver(br, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
    }
}
