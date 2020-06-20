package com.hemanth.vitapbookhub.Activity

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.hemanth.vitapbookhub.Adapter.HomeRecyclerAdapter
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.Book
import kotlinx.android.synthetic.main.activity_civil.*
import kotlinx.android.synthetic.main.activity_computer.*
import kotlinx.android.synthetic.main.activity_journals.*
import kotlinx.android.synthetic.main.recycler_home_single_row.*
import java.io.File


class JournalsActivity : AppCompatActivity() {
    var mydownloadid:Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journals)
        btnDownloadTownSend.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/computer%2FAdvances%20in%20Artificial%20Intelligence%20(Marie-Jean%20Meurs%2C%20Frank%20Rudzicz%2C%20(Ed.)%2C%202019)%20-%20Conference%20Book_compressed.pdf?alt=media&token=1a162ada-afcf-4c02-bf17-c5c286af2ed9"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtBWYesHSNo.text.toString())
                .setDescription("${txtBWYesHSNo.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadDallas.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Journals%2FIt%20Starts%20with%20Food_%20Discover%20the%20Whole30%20and%20Change%20Your%20Life%20in%20Unexpected%20Ways.pdf?alt=media&token=2f16f8a3-679f-41f2-a1cb-bf438e8f2e65"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtChangeYourLife.text.toString())
                .setDescription("${txtChangeYourLife.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadMertz.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Journals%2FLearning%20to%20%E2%80%9CThink%20Like%20a%20Lawyer%E2%80%9D.pdf?alt=media&token=3480b6b6-15e5-4a5f-bfa3-4ee7a1a13506"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtThinkLikeARoyal.text.toString())
                .setDescription("${txtThinkLikeARoyal.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadGawain.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Journals%2FLiving%20in%20the%20Light_%20A%20guide%20to%20personal%20transformation%20PDFDrive.com%20).pdf?alt=media&token=5c1a2302-376b-4427-9c8d-83e5f222c86e"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtLivingInTheLight.text.toString())
                .setDescription("${txtLivingInTheLight.text.toString()} is downloading")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadAslan.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Journals%2FNo%20god%20but%20God_%20The%20Origins%2C%20Evolution%2C%20and%20Future%20of%20Islam.pdf?alt=media&token=bce57f72-581c-4274-bf7e-79bc857a8d32"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtNoGodButGod.text.toString())
                .setDescription("${txtNoGodButGod.text.toString()} is Downloading ")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
        }

        btnDownloadChetan.setOnClickListener {
            var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/Journals%2FOne_Indian_Girl.pdf?alt=media&token=1e70635d-20b2-40cd-bbc3-c819ec8a4e31"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtOneIndianGirl.text.toString())
                .setDescription("${txtOneIndianGirl.text.toString()} is Downloading ")
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
