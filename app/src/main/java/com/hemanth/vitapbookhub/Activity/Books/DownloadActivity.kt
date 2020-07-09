package com.hemanth.vitapbookhub.Activity.Books

import android.app.AlertDialog
import android.app.DownloadManager
import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import com.hemanth.vitapbookhub.Activity.JournalsActivity
import com.hemanth.vitapbookhub.Activity.LibraryJoournalsActivity
import com.hemanth.vitapbookhub.Adapter.HomeRecyclerAdapter
import com.hemanth.vitapbookhub.R
import kotlinx.android.synthetic.main.activity_download_view.*
import com.internshala.bookhub.util.ConnectionManager
import hotchemi.android.rate.AppRate

class DownloadActivity : AppCompatActivity() {
    var mydownloadid:Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)
        if(ConnectionManager().checkConnectivity(this@DownloadActivity))
        {

            AppRate.with(this)
                .setInstallDays(2)
                .setLaunchTimes(3)
                .setRemindInterval(2)
                .monitor()
            AppRate.showRateDialogIfMeetsConditions(this)
            if (intent != null) {

                /*Fetching the details from the intent*/
                val details = intent.getBundleExtra("details")

                val txtBookname = details.getString("bookname")
                var url=details.getString("url")
                var request= DownloadManager.Request(Uri.parse(url))
                    .setTitle(txtBookname)
                    .setDescription("${txtBookname} is downloading")
                    .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"${System.currentTimeMillis()}")
                    .setMimeType("application/pdf")
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)

                var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                mydownloadid=dm.enqueue(request)
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
        else
        {
            val dialog= AlertDialog.Builder(this@DownloadActivity)
            dialog.setTitle("Error")
            dialog.setMessage("Internet is not connected to the BookHub app")
            dialog.setPositiveButton("Open Settings"){text, listener ->
                val settingsintent= Intent(Settings.ACTION_WIRELESS_SETTINGS)
                startActivity(settingsintent)
                finish()
            }
                dialog.setNegativeButton("exit"){text, listener ->
                ActivityCompat.finishAffinity(this@DownloadActivity)
            }
            dialog.create()
            dialog.show()
        }


    }
}
