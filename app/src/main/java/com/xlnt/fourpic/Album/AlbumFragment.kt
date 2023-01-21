package com.xlnt.fourpic.Album

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xlnt.fourpic.R
import com.xlnt.fourpic.databinding.FragmentAlbumBinding

class AlbumFragment : Fragment() {
//add(AlbumData(img = R.drawable.ex_photo_1, date = "2022. 01. 19 (THU)", memo = "쭈와뿌"))
//    // 바인딩 객체 타입에 ?를 붙여서 null을 허용 해줘야한다. ( onDestroy 될 때 완벽하게 제거를 하기위해 )
//    private var mBinding: FragmentAlbumBinding? = null
//    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
//    private val binding get() = mBinding!!

    val datas = ArrayList<AlbumData>()
    lateinit var rv_photo : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_album, container, false)
        datas.add(AlbumData(R.drawable.ex_photo_1, "2022. 01. 19 (THU)", "쭈와뿌"))
        datas.add(AlbumData(R.drawable.ex_photo_1, "2022. 01. 19 (THU)", "쭈와뿌"))
        datas.add(AlbumData(R.drawable.ex_photo_1, "2022. 01. 19 (THU)", "쭈와뿌"))
        datas.add(AlbumData(R.drawable.ex_photo_1, "2022. 01. 19 (THU)", "쭈와뿌"))
        datas.add(AlbumData(R.drawable.ex_photo_1, "2022. 01. 19 (THU)", "쭈와뿌"))

        rv_photo = rootView.findViewById(R.id.rv_photo!!)as RecyclerView
        rv_photo.layoutManager = GridLayoutManager(requireContext(),2)
        rv_photo.adapter = AlbumAdapter(requireContext(), datas)

        return rootView
    }
}