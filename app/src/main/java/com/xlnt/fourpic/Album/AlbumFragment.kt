package com.xlnt.fourpic.Album

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.xlnt.fourpic.R
import com.xlnt.fourpic.databinding.FragmentAlbumBinding

class AlbumFragment : Fragment() {

    val datas = ArrayList<AlbumData>()
    lateinit var rv_photo : RecyclerView
    lateinit var tv_count : TextView
    lateinit var btn_qr : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_album, container, false)

        init(rootView)

        datas.add(AlbumData(R.drawable.ex_photo_1, "2022. 01. 19 (THU)", "쭈와뿌"))
        datas.add(AlbumData(R.drawable.ex_photo_1, "2022. 01. 19 (THU)", "쭈와뿌"))
        datas.add(AlbumData(R.drawable.ex_photo_1, "2022. 01. 19 (THU)", "쭈와뿌"))
        datas.add(AlbumData(R.drawable.ex_photo_1, "2022. 01. 19 (THU)", "쭈와뿌"))
        datas.add(AlbumData(R.drawable.ex_photo_1, "2022. 01. 19 (THU)", "쭈와뿌"))

        tv_count.text = datas.size.toString()

        rv_photo.layoutManager = GridLayoutManager(requireContext(),2)
        rv_photo.adapter = AlbumAdapter(requireContext(), datas)

        btn_qr.setOnClickListener { it ->
            Toast.makeText(context, "qr코드 버튼 입니다.", Toast.LENGTH_SHORT).show()
        }

        return rootView
    }

    fun init(rootView : View){
        rv_photo = rootView.findViewById(R.id.rv_photo!!)as RecyclerView
        tv_count = rootView.findViewById(R.id.tv_count)
        btn_qr = rootView.findViewById(R.id.btn_qr)
    }
}