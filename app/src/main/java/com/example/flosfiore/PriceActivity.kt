package com.example.flosfiore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flosfiore.data.entities.FlowerPrice
import com.example.flosfiore.data.entities.Item
import com.example.flosfiore.data.remote.*
import com.example.flosfiore.databinding.ActivityPriceBinding
import com.example.flosfiore.databinding.ActivitySignupBinding
import java.text.DecimalFormat

// 싯가 프레그먼트
class PriceActivity : AppCompatActivity(), HydraView, LisianView, MistView, RoseView {
    lateinit var binding: ActivityPriceBinding
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

    private var context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPriceBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var itemAdapter = ItemRVAdapter(flowers)
        binding.priceFlowersRv.adapter = itemAdapter
        binding.priceFlowersRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    // 위아래 이미지 변환
    fun setImage(price : Int, standard : Int): Int?{
        return if(price > standard){
            R.drawable.ic_price_up
        } else{
            R.drawable.ic_price_down
        }
    }


    override fun onStart() {
        super.onStart()
        getRose()
    }



    // 수국
    private fun getHydra(){
        val itemService = ItemService()
        itemService.setHydraView(this)

        itemService.getHydra()
        binding.priceGoodsNameTv.text = "수국"
    }

    override fun onGetHydraLoading() {

    }

    override fun onGetHydraSuccess(code: Int, result: FlowerPrice) {
        val dec = DecimalFormat("#,###")
        binding.priceGoodsRegularPriceTv.text = "평균 ${dec.format(result.flowerAgePrice)}원"
    }

    override fun onGetHydraFailure(code: Int, message: String) {
        Log.d("HYDRA-FRAG/HYDRA-RESPONSE", message)
    }


    // 장미
    private fun getRose(){
        val itemService = ItemService()
        itemService.setRoseView(this)

        itemService.getRose()
        binding.priceGoodsNameTv.text = "장미"
    }
    override fun onGetRoseLoading() {

    }

    override fun onGetRoseSuccess(code: Int, result: FlowerPrice) {
        val dec = DecimalFormat("#,###")
        binding.priceGoodsRegularPriceTv.text = "평균 ${dec.format(result.flowerAgePrice)}원"
    }

    override fun onGetRoseFailure(code: Int, message: String) {
        Log.d("ROSE-FRAG/ROSE-RESPONSE", message)
    }


    // 안개꽃
    private fun getMist(){
        val itemService = ItemService()
        itemService.setMistView(this)

        itemService.getMist()
        binding.priceGoodsNameTv.text = "안개꽃"
    }

    override fun onGetMistLoading() {

    }

    override fun onGetMistSuccess(code: Int, result: FlowerPrice) {
        val dec = DecimalFormat("#,###")
        binding.priceGoodsRegularPriceTv.text = "평균 ${dec.format(result.flowerAgePrice)}원"
    }

    override fun onGetMistFailure(code: Int, message: String) {
        Log.d("MIST-FRAG/MIST-RESPONSE", message)
    }


    // 리시안셔스
    private fun getLisian(){
        val itemService = ItemService()
        itemService.setLisianView(this)

        itemService.getLisian()
        binding.priceGoodsNameTv.text = "리시안셔스"
    }

    override fun onGetLisianLoading() {

    }

    override fun onGetLisianSuccess(code: Int, result: FlowerPrice) {
        val dec = DecimalFormat("#,###")
        binding.priceGoodsRegularPriceTv.text = "평균 ${dec.format(result.flowerAgePrice)}원"
    }

    override fun onGetLisianFailure(code: Int, message: String) {
        Log.d("LISIAN-FRAG/LISIAN-RESPONSE", message)
    }

}