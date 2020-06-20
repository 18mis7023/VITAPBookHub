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
import com.hemanth.vitapbookhub.Activity.JournalsActivity
import com.hemanth.vitapbookhub.Activity.LibraryJoournalsActivity
import com.hemanth.vitapbookhub.Adapter.HomeRecyclerAdapter
import com.hemanth.vitapbookhub.R
import kotlinx.android.synthetic.main.activity_download_view.*

class DownloadActivity : AppCompatActivity() {
    var mydownloadid:Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)

        if (intent != null) {

            /*Fetching the details from the intent*/
            val details = intent.getBundleExtra("details")

            /*Getting the value of data from the bundle object*/
            val data = details.getString("data")
            val txtBookname = details.getString("bookname")
            val txtAuthor=details.getString("author")
            var url=details.getString("url")
            //var url="https://firebasestorage.googleapis.com/v0/b/vitap-bookhub-4f07c.appspot.com/o/MathsBooks%2F1300%20Math%20Formulas%20(Alex%20Svirin%2C%202004).pdf?alt=media&token=dfb084bd-6eda-4b4f-890e-8ac31ed6459c"
            var request= DownloadManager.Request(Uri.parse(url))
                .setTitle(txtBookname)
                .setDescription("${txtBookname} is downloading")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            //   .setAllowedOverMetered(false)
            //    .setAllowedOverMetered(true)
            var dm: DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownloadid=dm.enqueue(request)
            var br=object: BroadcastReceiver(){
                override fun onReceive(p0: Context?, p1: Intent?) {
                    var id:Long?=p1?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1)
                    if(id==mydownloadid)
                    {
                        Toast.makeText(applicationContext,"successfully Downloaded the file .... downloaded file in Downloads ",
                            Toast.LENGTH_SHORT).show()
                        /*startActivity(Intent(this@DownloadActivity,LibraryJoournalsActivity::class.java))
                        finish()*/
                    }
                }
            }
            registerReceiver(br, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
        }
    }
}
