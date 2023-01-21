package com.xlnt.fourpic.Album

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xlnt.fourpic.R

class AlbumAdapter(private val context: Context, private val dataset: ArrayList<AlbumData>) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    class AlbumViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        val iv_photo: ImageView = view.findViewById(R.id.iv_photo)
        val tv_date: TextView = view.findViewById(R.id.tv_date)
        val tv_memo: TextView = view.findViewById(R.id.tv_memo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_photo, parent, false)
        return AlbumViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val item = dataset.get(position)
        Glide.with(context).load(item.img).into(holder.iv_photo)
        holder.tv_date.text = item.date
        holder.tv_memo.text = item.memo
    }

    override fun getItemCount(): Int = dataset.size


}