package com.example.charo_android

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charo_android.data.MapSearchInfo
import com.example.charo_android.databinding.FragmentWriteMapSearchBinding
import com.example.charo_android.ui.write.WriteMapSearchAdapter
import com.skt.Tmap.TMapData

class WriteMapSearchFragment : Fragment() {


//    inner class addressListAdapterToList{
//        fun getAddressId(address: Room){
//
//        }
//    }

    companion object {
        fun newInstance() = WriteMapSearchFragment()
    }

    private lateinit var writeMapSearchAdapter: WriteMapSearchAdapter
    lateinit var userId: String
    lateinit var nickName: String

    private lateinit var locationFlag: String

    private lateinit var viewModel: WriteMapSearchViewModel

    private var _binding: FragmentWriteMapSearchBinding? = null

    private val binding get() = _binding!!

    var writeShareActivity: WriteShareActivity? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        writeShareActivity = context as WriteShareActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWriteMapSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root
        Log.d("jjj", "success go searchActivity")

//        userId = intent.getStringExtra("userId").toString()
//        nickName = intent.getStringExtra("nickName").toString()


//        내가 추가한 코드
//        locationFlag = intent.getStringExtra("locationFlag").toString()
//        var text: String = when (locationFlag) {
//            "1" -> {
//                "출발지로 설정"
//            }
//            "4" -> {
//                "도착지로 설정"
//            }
//            else -> {
//                "경유지로 설정"
//            }
//        }
//        binding.etWriteMapSearchStart.hint = text

        binding.imgWriteMapSearchBack.setOnClickListener {
            writeShareActivity?.onBackPressed()
        }

        // 1. 우리가 사용할 어뎁터의 초기 값을 넣어준다
        writeMapSearchAdapter =  WriteMapSearchAdapter()

//        WriteMapSearchAdapter(locationFlag, text, userId, nickName)

        // 2. RecyclerView 에 어뎁터를 우리가 만든 어뎁터로 만들기
        binding.recyclerviewWriteMapSearch.adapter = writeMapSearchAdapter

        val tmapdata = TMapData()

        binding.etWriteMapSearchStart.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("myLog", "before")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("myLog", "changing")
            }

            override fun afterTextChanged(s: Editable?) {
                Log.d("myLog", "after")
                var list = mutableListOf<MapSearchInfo>()
                Handler(Looper.getMainLooper()).postDelayed({
                    if(binding.etWriteMapSearchStart.text.isNotEmpty()) {
                        tmapdata.findTitlePOI(binding.etWriteMapSearchStart.text.toString()) { poiItem ->
                            for (i in 0 until poiItem.size) {
                                val item = poiItem[i]

                                list.add(
                                    MapSearchInfo(
                                        locationName = item.poiName,
                                        locationAddress = item.poiAddress.replace("null", "")
                                    )

                                )
                            }
                            writeMapSearchAdapter.userList = list
                        }
                        writeMapSearchAdapter.notifyDataSetChanged()
                    }
                }, 500)
            }
        })

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WriteMapSearchViewModel::class.java)
        // TODO: Use the ViewModel
    }

}