package com.hemanth.vitapbookhub.Adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.vitapbookhub.Activity.Books.DownloadActivity
import com.hemanth.vitapbookhub.R
import com.hemanth.vitapbookhub.model.Book


class HomeRecyclerAdapter(val context:Context,val itemList:ArrayList<Book>) : RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {
    class HomeViewHolder(view:View):RecyclerView.ViewHolder(view){
        val txtrecyclebook:TextView=view.findViewById(R.id.txtrecyclerbook)
        val txtrecycleauthor:TextView=view.findViewById(R.id.txtrecyclerauthor)
        val btndownload:TextView=view.findViewById(R.id.btnDownload)
        val imgbook:ImageView=view.findViewById(R.id.imgrecyclerimage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_home_single_row,parent,false)

        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int)  {

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
            startActivity(context,intent,bundle)

        }

    }


}

