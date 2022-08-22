package com.example.flosfiore.ui.flower

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.HomeCategoryVPAdapter
import com.example.flosfiore.R
import com.example.flosfiore.data.entities.Flower
import com.example.flosfiore.data.entities.Post
import com.example.flosfiore.databinding.ActivityFlowerListBinding
import com.example.flosfiore.databinding.FragmentFlowerListBinding
import com.example.flosfiore.databinding.ItemFlowerListBinding
import com.example.flosfiore.ui.main.community.PostRVAdapter
import com.example.flosfiore.ui.main.community.detail.CommunityDetailActivity
import com.google.android.material.tabs.TabLayoutMediator

class FlowerListActivity: AppCompatActivity() {
    lateinit var binding : ActivityFlowerListBinding
    private val category = arrayListOf("생화", "야생화/다육이", "동양란", "서양란", "축하화환", "근조화환", "이색상품", "관엽화분")
    private val flowerList = arrayListOf(
        Flower(R.drawable.img_home_tb1, "가든 꽃바구니", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb2, "특별한 마음 꽃다발", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb3, "분홍장미계절꽃다발", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb4, "특별한 마음 꽃다발발", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb1, "가든 꽃바구니", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb2, "특별한 마음 꽃다발", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb3, "분홍장미계절꽃다발", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb4, "특별한 마음 꽃다발발", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb1, "가든 꽃바구니", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb2, "특별한 마음 꽃다발", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb3, "분홍장미계절꽃다발", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb4, "특별한 마음 꽃다발발", 88000, "플로레 화원")
    )

    private var flowerListRVAdapter = FlowerListRVAdapter(flowerList)
    private var context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlowerListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //카테고리 탭레이아웃, 뷰페이저 연결
        val categoryadapter = CustomPagerAdapter()
        binding.flowerListCategoryVp.adapter = categoryadapter
        TabLayoutMediator(binding.flowerListCategoryTb, binding.flowerListCategoryVp) {
                tab, position ->
            tab.text = category[position]
        }.attach()

        flowerListRVAdapter.setMyItemClickListener(object :
        FlowerListRVAdapter.MyItemClickListener {
            override fun onItemClick(flower: Flower) {
                var intent = Intent(context, FlowerDetailActivity::class.java)
                intent.putExtra("flower", flower)
                startActivity(intent)
            }
        })
    }

    inner class CustomPagerAdapter : RecyclerView.Adapter<CustomPagerAdapter.MyPagerViewHolder>() {
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyPagerViewHolder {
            val binding2 : FragmentFlowerListBinding = FragmentFlowerListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

            return MyPagerViewHolder(binding2)
        }

        override fun onBindViewHolder(holder: MyPagerViewHolder, position: Int) {
            holder.bind(position)
        }

        override fun getItemCount() = 8

        inner class MyPagerViewHolder(var binding2: FragmentFlowerListBinding) : RecyclerView.ViewHolder(binding2.root) {

            fun bind(position: Int) {
                binding2.flowerListRv.adapter = flowerListRVAdapter
            }

        }

    }
}