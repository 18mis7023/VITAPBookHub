package com.hemanth.vitapbookhub.Adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.vitapbookhub.Activity.Books.DownloadActivity
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.Book

class PhysicsRecyclerAdapter (val context: Context, val itemList:ArrayList<Book>) : RecyclerView.Adapter<PhysicsRecyclerAdapter.PhysicsViewHolder>() {
    class PhysicsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var bookid=0
        val txtrecyclebook: TextView = view.findViewById(R.id.txtrecyclerbook)
        val txtrecycleauthor: TextView = view.findViewById(R.id.txtrecyclerauthor)
       // val txtBookRating:TextView=view.findViewById(R.id.txtratring)
        val btndownload: Button = view.findViewById(R.id.btnDownload)
        val imgbook: ImageView = view.findViewById(R.id.imgrecyclerimage)
       /* val bookEntity = BookEntity(
            bookid?.toInt() as Int,
            txtrecyclebook.text.toString(),
            txtrecycleauthor.text.toString(),
            txtBookRating.text.toString(),
            imgbook
        )*/

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhysicsViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recycler_home_single_row,parent,false)

        return PhysicsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: PhysicsViewHolder, position: Int)  {

        val book=itemList[position]
        holder.txtrecyclebook.text=book.bookName
        holder.txtrecycleauthor.text=book.bookAuthor
        holder.imgbook.setImageResource(book.bookimage)
        holder.btndownload.setOnClickListener {
            val intent = Intent(context, DownloadActivity::class.java)
            val bundle = Bundle()
            bundle.putString("data", "View")
            bundle.putString("bookname", book.bookName)
            bundle.putString("author", book.bookAuthor)
            bundle.putString("url", book.bookUrl)
            intent.putExtra("details", bundle)
            ContextCompat.startActivity(context, intent, bundle)

        }

    }
}