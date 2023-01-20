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

private val ViewDataBinding.tv_date: Any
    get() {}

class AlbumAdapter : RecyclerView.Adapter<AlbumAdapter.MyViewHolder>() {

    private var data = mutableListOf<AlbumData>()

    class MyViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding, root) {
        //View와 데이터를 연결시키는 함수
        fun bind(item: AlbumData) {
            binding.tv_date.text = item.date
            binding.tv_memo.text = item.memo
            Glide.with(itemView).load(item.img).into(binding.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_rv_photo, parent, false)
        return MyViewHolder(binding)
    }

    //상속받으면 자동 생성
    //ViewHolder에서 데이터 묶는 함수가 실행되는 곳
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun replaceList(newList: MutableList<AlbumData>) {
        data = newList.toMutableList()
        //어댑터의 데이터가 변했다는 notify를 날린다
        notifyDataSetChanged()
    }

}