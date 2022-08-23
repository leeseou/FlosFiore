package com.example.flosfiore.ui.main.cart

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flosfiore.GoodsNormalRVAdapter
import com.example.flosfiore.GoodsOvernightRVAdapter
import com.example.flosfiore.R
import com.example.flosfiore.data.entities.Flower
import com.example.flosfiore.data.entities.GoodsNormal
import com.example.flosfiore.data.entities.GoodsOvernight
import com.example.flosfiore.databinding.FragmentCartBinding
import com.example.flosfiore.ui.main.MainActivity
import com.example.flosfiore.ui.main.home.HomeFragment

// 장바구니 프레그먼트
class CartFragment : Fragment() {

    lateinit var binding: FragmentCartBinding
    var goodsOvernight = arrayListOf(GoodsOvernight())
    var goodsNormal = arrayListOf(GoodsNormal())
    lateinit var goodsOvernightAdapter : GoodsOvernightRVAdapter
    lateinit var goodsNormalAdapter : GoodsNormalRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        (activity as MainActivity).setSupportActionBar(binding.cartToolbarTb)
        (activity as MainActivity).supportActionBar?.setDisplayShowTitleEnabled(false)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back_black)

        // 당일 배송 리사이클러뷰
        // 꽃 가격
        goodsOvernight = arrayListOf(
            GoodsOvernight(R.drawable.ic_cart_select, R.drawable.img_flower_detail1,"플로레 화원","가든 꽃바구니", "핑크&옐로우",1, 83000, 83000),
            GoodsOvernight(R.drawable.ic_cart_select, R.drawable.img_flower_detail2,"플로레 화원","가든 꽃바구니", "핑크&옐로우",1, 67000, 67000)
        )

        // 일반배송 리사이클러뷰
        // 꽃 가격
        goodsNormal = arrayListOf(
            GoodsNormal(R.drawable.ic_cart_select, R.drawable.img_flower_detail3,"플로레 화원","가든 꽃바구니", "핑크",1, 51000, 51000),
            GoodsNormal(R.drawable.ic_cart_select, R.drawable.img_home_sale2,"플로레 화원","가든 꽃바구니", "옐로우",1, 32000, 32000)
        )

        if((activity as MainActivity).intent.getSerializableExtra("cart") != null) {
            var flower = (activity as MainActivity).intent.getSerializableExtra("cart") as Flower
            goodsNormal.add(GoodsNormal(R.drawable.ic_cart_select, flower.img!!, flower.store, flower.name, "", 1, flower.price, flower.price))

        }

        setRVAdapter()
        updateViews()
        setRVOnClickListener()


        binding.cartAllSelectIv.setOnClickListener {
            binding.cartAllSelectIv.visibility = View.GONE
            binding.cartAllNotSelectIv.visibility = View.VISIBLE
            goodsOvernightAdapter.setCheckAll(false)
            goodsNormalAdapter.setCheckAll(false)
            updateViews()
        }

        binding.cartAllNotSelectIv.setOnClickListener {
            binding.cartAllSelectIv.visibility = View.VISIBLE
            binding.cartAllNotSelectIv.visibility = View.GONE
            goodsOvernightAdapter.setCheckAll(true)
            goodsNormalAdapter.setCheckAll(true)
            updateViews()
        }

        binding.cartSelectDeleteTv.setOnClickListener {
            goodsNormalAdapter.removeSelected()
            goodsOvernightAdapter.removeSelected()
            updateViews()
        }

        binding.cartAddGoodsBtn.setOnClickListener {
            var activity = activity as MainActivity
            activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_frm, HomeFragment())
                .commitAllowingStateLoss()
            activity.binding.bottomNavigationView.selectedItemId = R.id.homeFragment
        }

        return binding.root
    }

    private fun updateViews() {
        if(goodsNormalAdapter.itemCount == 0 && goodsOvernightAdapter.itemCount == 0) {
            // 장바구니 비었을 때
            binding.cartContentNsv.visibility = View.GONE
            binding.cartEmptyLlayout.visibility = View.VISIBLE
            return
        }

        if (goodsOvernightAdapter.itemCount == 0) {
            binding.cartOvernightDeliveryClayout.visibility = View.GONE
        } else if (goodsNormalAdapter.itemCount == 0) {
            binding.cartNormalDeliveryClayout.visibility = View.GONE
        } else {
            binding.cartOvernightDeliveryClayout.visibility = View.VISIBLE
            binding.cartNormalDeliveryClayout.visibility = View.VISIBLE
        }

        binding.cartContentNsv.visibility = View.VISIBLE
        binding.cartPaymentGoodsCountTv.text = "총 ${goodsOvernightAdapter.countGoods() + goodsNormalAdapter.countGoods()}개"
        binding.cartTotalCountTv.text = "총 ${goodsOvernightAdapter.countGoods() + goodsNormalAdapter.countGoods()}개   |"
        binding.cartPaymentGoodsPriceTv.text = "${goodsOvernightAdapter.sumPrice() + goodsNormalAdapter.sumPrice()}원"
        binding.cartPaymentPriceTv.text = "${goodsOvernightAdapter.sumPrice() + goodsNormalAdapter.sumPrice()}원"
        binding.cartTotalPriceTv.text = "${goodsOvernightAdapter.sumPrice() + goodsNormalAdapter.sumPrice()}원 결제하기"
    }

    private fun setRVAdapter() {
        // 리사이클러뷰 구분선
        val decoration = DividerItemDecoration(context, 1)
        binding.cartOvernightGoodsRv.addItemDecoration(decoration)
        binding.cartNormalGoodsRv.addItemDecoration(decoration)


        // 당일 배송 어뎁터 연결
        goodsOvernightAdapter = GoodsOvernightRVAdapter(goodsOvernight)
        binding.cartOvernightGoodsRv.adapter = goodsOvernightAdapter
        binding.cartOvernightGoodsRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)

        // 일반 배송 어뎁터 연결
        goodsNormalAdapter = GoodsNormalRVAdapter(goodsNormal)
        binding.cartNormalGoodsRv.adapter = goodsNormalAdapter
        binding.cartNormalGoodsRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
    }

    private fun setRVOnClickListener() {
        // 당일 배송 클릭 이벤트
        goodsOvernightAdapter.setMyItemClickListener(object: GoodsOvernightRVAdapter.MyItemClickListener{
            override fun onItemClick() {

            }

            override fun onRemoveGoodsOvernight(position: Int) {
                goodsOvernightAdapter.removeGoods(position)
                updateViews()
            }

            override fun onDownBtnClick(goodsOvernight: GoodsOvernight) {
                goodsOvernightAdapter.abstractNum(goodsOvernight)
                updateViews()
            }

            override fun onUpBtnClick(goodsOvernight: GoodsOvernight) {
                goodsOvernightAdapter.addNum(goodsOvernight)
                updateViews()
            }

            override fun onSelectClick(goodsOvernight: GoodsOvernight) {
                goodsOvernightAdapter.selectGoods(goodsOvernight)
                updateViews()
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
                updateViews()
            }

            override fun onDownBtnClick(goodsNormal: GoodsNormal) {
                goodsNormalAdapter.abstractNum(goodsNormal)
                updateViews()
            }

            override fun onUpBtnClick(goodsNormal: GoodsNormal) {
                goodsNormalAdapter.addNum(goodsNormal)
                updateViews()
            }

            override fun onSelectClick(goodsNormal: GoodsNormal) {
                goodsNormalAdapter.selectGoods(goodsNormal)
                updateViews()
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
    }


}