package com.example.flosfiore.ui.main.cart

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flosfiore.GoodsNormalRVAdapter
import com.example.flosfiore.GoodsOvernightRVAdapter
import com.example.flosfiore.R
import com.example.flosfiore.data.entities.GoodsNormal
import com.example.flosfiore.data.entities.GoodsOvernight
import com.example.flosfiore.databinding.FragmentCartBinding
import java.text.DecimalFormat

// 장바구니 프레그먼트
class CartFragment : Fragment() {

    lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)


        // 당일 배송 리사이클러뷰
        // 꽃 가격
        var goodsOvernight = arrayListOf(
            GoodsOvernight(R.drawable.ic_cart_select, R.drawable.img_flower_detail1,"플로레 화원","가든 꽃바구니", "핑크&옐로우",1, 83000, 83000),
            GoodsOvernight(R.drawable.ic_cart_select, R.drawable.img_flower_detail2,"플로레 화원","가든 꽃바구니", "핑크&옐로우",1, 67000, 67000)
        )

        // 리사이클러뷰 구분선
        val decoration = DividerItemDecoration(context, 1)
        binding.cartOvernightGoodsRv.addItemDecoration(decoration)


        // 어뎁터 연결
        var goodsOvernightAdapter = GoodsOvernightRVAdapter(goodsOvernight)
        binding.cartOvernightGoodsRv.adapter = goodsOvernightAdapter
        binding.cartOvernightGoodsRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)


        // 일반배송 리사이클러뷰
        // 꽃 가격
        var goodsNormal = arrayListOf(
            GoodsNormal(R.drawable.ic_cart_select, R.drawable.img_flower_detail3,"플로레 화원","가든 꽃바구니", "핑크",1, 51000, 51000),
            GoodsNormal(R.drawable.ic_cart_select, R.drawable.img_home_sale2,"플로레 화원","가든 꽃바구니", "옐로우",1, 32000, 32000)
        )

        // 리사이클러뷰 구분선
        binding.cartNormalGoodsRv.addItemDecoration(decoration)


        // 어뎁터 연결
        var goodsNormalAdapter = GoodsNormalRVAdapter(goodsNormal)
        binding.cartNormalGoodsRv.adapter = goodsNormalAdapter
        binding.cartNormalGoodsRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)


        val dec = DecimalFormat("#,###")

        // 가격 반영
        fun changePrice(){
            binding.cartPaymentGoodsCountTv.text = "총 ${dec.format(goodsOvernightAdapter.countGoods() + goodsNormalAdapter.countGoods())}개"
            binding.cartTotalCountTv.text = "총 ${dec.format(goodsOvernightAdapter.countGoods() + goodsNormalAdapter.countGoods())}개   |"
            binding.cartPaymentGoodsPriceTv.text = "${dec.format(goodsOvernightAdapter.sumPrice() + goodsNormalAdapter.sumPrice())}원"
            binding.cartPaymentPriceTv.text = "${dec.format(goodsOvernightAdapter.sumPrice() + goodsNormalAdapter.sumPrice())}원"
            binding.cartTotalPriceTv.text = "${dec.format(goodsOvernightAdapter.sumPrice() + goodsNormalAdapter.sumPrice())}원 결제하기"
        }

        // 당일 배송 클릭 이벤트
        goodsOvernightAdapter.setMyItemClickListener(object: GoodsOvernightRVAdapter.MyItemClickListener{
            override fun onItemClick() {
            
            }

            override fun onRemoveGoodsOvernight(position: Int) {
                goodsOvernightAdapter.removeGoods(position)
                changePrice()
            }

            override fun onDownBtnClick(goodsOvernight: GoodsOvernight) {
                goodsOvernightAdapter.abstractNum(goodsOvernight)
                changePrice()
            }

            override fun onUpBtnClick(goodsOvernight: GoodsOvernight) {
                goodsOvernightAdapter.addNum(goodsOvernight)
                changePrice()
            }

            override fun onSelectClick(goodsOvernight: GoodsOvernight) {
                goodsOvernightAdapter.selectGoods(goodsOvernight)
                changePrice()
                if(goodsOvernightAdapter.countSelect()&&goodsNormalAdapter.countSelect()){
                    binding.cartAllSelectIv.visibility = View.VISIBLE
                    binding.cartAllNotSelectIv.visibility = View.GONE
                }
                else{
                    binding.cartAllSelectIv.visibility = View.GONE
                    binding.cartAllNotSelectIv.visibility = View.VISIBLE
                }
            }

        })


        // 일반 배송 클릭 이벤트
        goodsNormalAdapter.setMyItemClickListener(object: GoodsNormalRVAdapter.MyItemClickListener{
            override fun onItemClick() {

            }

            override fun onRemoveGoodsNormal(position: Int) {
                goodsNormalAdapter.removeGoods(position)
                changePrice()
            }

            override fun onDownBtnClick(goodsNormal: GoodsNormal) {
                goodsNormalAdapter.abstractNum(goodsNormal)
                changePrice()
            }

            override fun onUpBtnClick(goodsNormal: GoodsNormal) {
                goodsNormalAdapter.addNum(goodsNormal)
                changePrice()
            }

            override fun onSelectClick(goodsNormal: GoodsNormal) {
                goodsNormalAdapter.selectGoods(goodsNormal)
                changePrice()
                if(goodsOvernightAdapter.countSelect()&&goodsNormalAdapter.countSelect()){
                    binding.cartAllSelectIv.visibility = View.VISIBLE
                    binding.cartAllNotSelectIv.visibility = View.GONE
                }
                else{
                    binding.cartAllSelectIv.visibility = View.GONE
                    binding.cartAllNotSelectIv.visibility = View.VISIBLE
                }
            }
        })


        binding.cartAllSelectIv.setOnClickListener {
            binding.cartAllSelectIv.visibility = View.GONE
            binding.cartAllNotSelectIv.visibility = View.VISIBLE
            goodsOvernightAdapter.setCheckAll(false)
            goodsNormalAdapter.setCheckAll(false)
            changePrice()
        }

        binding.cartAllNotSelectIv.setOnClickListener {
            binding.cartAllSelectIv.visibility = View.VISIBLE
            binding.cartAllNotSelectIv.visibility = View.GONE
            goodsOvernightAdapter.setCheckAll(true)
            goodsNormalAdapter.setCheckAll(true)
            changePrice()
        }

        changePrice()


        return binding.root
    }


}