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
import kotlinx.android.synthetic.main.activity_electronics.btnDownloadDon
import kotlinx.android.synthetic.main.activity_electronics.btnDownloadDonald
import kotlinx.android.synthetic.main.activity_electronics.btnDownloadJack
import kotlinx.android.synthetic.main.activity_electronics.btnDownloadKip
import kotlinx.android.synthetic.main.activity_electronics.btnDownloadLeon
import kotlinx.android.synthetic.main.activity_electronics.btnDownloadYury
import kotlinx.android.synthetic.main.activity_english.*

class EnglishActivity : AppCompatActivity() {

    var mydownloadid:Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english)

        btnDownloadJhon.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/English%2FA%20Basic%20English%20Grammar%20Exercises%20(John%20Eastwood%2C%201984)%20-%20Book.pdf?alt=media&token=f4fe7905-4c63-4615-b896-02c3ddc70d8f"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtBEGE.text.toString())
                .setDescription("${txtBEGE.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadCarole.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/English%2FAdvancing%20Vocabulary%20Skills%20(Sherrie%20L.Nist%2C%20Carole%20Mohr%2C%203e%2C%202002)%20-%20Book.pdf?alt=media&token=9bff51d6-f23e-4afa-910e-fbac8e7a8b09"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtAVC.text.toString())
                .setDescription("${txtAVC.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadVijaya.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/English%2FBasic%20Grammar%20Practice%20Handbook%20on%20Tense%20(M.Vijaya%2C%202017)%20-%20Book.pdf?alt=media&token=f5a6ebbf-a7b4-43f7-b1e6-36d6fc74b5a3"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtEBGPH.text.toString())
                .setDescription("${txtEBGPH.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadPaul.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/English%2FCommon%20Errors%20in%20English%20(Paul%20Hancock)%20-%20Book.pdf?alt=media&token=750f9a6e-903d-4434-a1c6-1e65080384b8"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtECE.text.toString())
                .setDescription("${txtECE.text.toString()} is downloading")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadSeth.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/English%2FEnglish%20Prepositions%20Explained%20(Seth%20Lindstromberg%2C%202010)%20-%20Book.pdf?alt=media&token=96413a7a-9295-4d17-a159-2d84fd0fcfde"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtEPE.text.toString())
                .setDescription("${txtEPE.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadJonathon.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/English%2FEnglish%20Pronunciation%20in%20Use%20Elementary%20(Jonathan%20Marks%2C%202007)%20-%20Book.pdf?alt=media&token=67a27c8d-768d-4dcb-8fe6-8c7322c35301"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtEPUE.text.toString())
                .setDescription("${txtEPUE.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadZoe.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/English%2FEnglish%20Skills%20with%20Readings%20(John%20Langan%2C%20Zo%C3%A9%20L.Albright%2C%209e%2C%202015)%20-%20Book.pdf?alt=media&token=bd5f7d2b-bda0-4054-84b6-ae234df34b8f"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtESR.text.toString())
                .setDescription("${txtESR.text.toString()} is Downloading ")
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
