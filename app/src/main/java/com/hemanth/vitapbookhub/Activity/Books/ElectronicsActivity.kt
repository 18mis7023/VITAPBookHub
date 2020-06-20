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
import kotlinx.android.synthetic.main.activity_electronics.*
import kotlinx.android.synthetic.main.activity_maths.btnDownloadAlex
import kotlinx.android.synthetic.main.activity_maths.btnDownloadElliott
import kotlinx.android.synthetic.main.activity_maths.btnDownloadHarold

class ElectronicsActivity : AppCompatActivity() {
    var mydownloadid:Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electronics)
        btnDownloadSieve.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Electronics%2FAnalog%20and%20Digital%20Filter%20Design%20(Steve%20Winder%2C%202e%2C%202002)%20-%20Book.pdf?alt=media&token=6b94e767-e72e-43a6-bf26-7ba1e094d8e7"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtAnalogAndDigital.text.toString())
                .setDescription("${txtAnalogAndDigital.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadDon.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Electronics%2FArduino%20Electronics%20Blueprints%20(Don%20Wilcher%2C%202015)%20-%20Book.pdf?alt=media&token=36a3bd90-b25b-44ea-bb61-2adc62b83574"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtAEB.text.toString())
                .setDescription("${txtAEB.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadKip.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Electronics%2FAssembly%20Language%20for%20x86%20Processors%20(Kip%20R.Irvine%2C%207e%2C%202015).pdf?alt=media&token=b24cdf4d-ae35-45de-bfee-4996d192fd15"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtALP.text.toString())
                .setDescription("${txtALP.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadDonald.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Electronics%2FBeginning%20Artificial%20Intelligence%20with%20the%20Raspberry%20Pi%20(Donald%20J.Norris%2C%202017)%20-%20Book-min.pdf?alt=media&token=19dd624c-8b8d-4735-a9c3-ebe64b547603"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtBAIWR.text.toString())
                .setDescription("${txtBAIWR.text.toString()} is downloading")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadJack.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Electronics%2FBeginning%20C%20for%20Arduino%20-%20Learn%20C%20Programming%20for%20the%20Arduino%20(Jack%20Purdum%2C%202012)%20-%20Book-min.pdf?alt=media&token=ff06d014-84a3-400a-8887-f2a39a601d6d"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtBCFA.text.toString())
                .setDescription("${txtBCFA.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadLeon.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Electronics%2FDigital%20and%20Analog%20Communication%20Systems%20(Leon%20W.Couch%2C%207e%2C%202006)%20-%20Solutions%20Book.pdf?alt=media&token=9f964a92-9606-45cf-b977-9c045e007cb0"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtDACS.text.toString())
                .setDescription("${txtDACS.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadYury.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Electronics%2FNetwork%20and%20Web%20Applications%20Using%20Raspberry%20Pi%2C%20Arduino%20and%20Teensy%20(Yury%20Magda%2C%202015)%20-%20Book.pdf?alt=media&token=4f065f31-b2ec-48c0-8c88-44300f962ad1"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtNWA.text.toString())
                .setDescription("${txtNWA.text.toString()} is Downloading ")
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
