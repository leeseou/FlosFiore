package com.example.flosfiore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flosfiore.data.entities.Item

import com.example.flosfiore.databinding.FragmentPriceBinding

// 싯가 프레그먼트
class PriceFragment : Fragment() {
    lateinit var binding: FragmentPriceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPriceBinding.inflate(inflater,container,false)

        setRVAdapters()

        return binding.root
    }

    fun setRVAdapters() {

        // 꽃 가격
        var flowers = arrayListOf(
            Item("22.08.01","플로레 화원", 7500, setImage(7500, 7500)),
            Item("22.08.01","꽃집 청년들", 7900, setImage(7900, 7500)),
            Item("22.08.01","플로레 화원", 7500, setImage(7500, 7500)),
            Item("22.08.02","플로레 화원", 7500, setImage(7500, 7500)),
            Item("22.08.02","꽃집 청년들", 7900, setImage(7900, 7500)),
            Item("22.08.02","플로레 화원", 7500, setImage(7500, 7500)),
            Item("22.08.03","플로레 화원", 7500, setImage(7500, 7500)),
            Item("22.08.03","꽃집 청년들", 7900, setImage(7900, 7500)),
            Item("22.08.03","플로레 화원", 7500, setImage(7500, 7500))
        )

        var itemAdapter = ItemRVAdapter(flowers)
        binding.priceFlowersRv.adapter = itemAdapter
        binding.priceFlowersRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
    }

    // 위아래 이미지 변환
    fun setImage(price : Int, standard : Int): Int?{
        return if(price > standard){
            R.drawable.ic_price_up
        } else{
            R.drawable.ic_price_down
        }
    }

}