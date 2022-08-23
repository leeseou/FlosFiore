package com.example.flosfiore.ui.flower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.R
import com.example.flosfiore.data.entities.Flower
import com.example.flosfiore.databinding.ActivityFlowerDetailBinding
import com.google.android.material.tabs.TabLayoutMediator
import java.text.DecimalFormat

class FlowerDetailActivity:AppCompatActivity() {
    lateinit var binding: ActivityFlowerDetailBinding
    val imgList = arrayListOf(R.drawable.img_flower_detail1, R.drawable.img_flower_detail2, R.drawable.img_flower_detail3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlowerDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViews()

        val imgVPAdapter = CustomPagerAdapter()
        binding.flowerDetailMainVp.adapter = imgVPAdapter

        TabLayoutMediator(binding.flowerDetailMainTb, binding.flowerDetailMainVp) {
                tab, position ->
            binding.flowerDetailMainVp.setCurrentItem(tab.position)
        }.attach()
    }

    // 화면 초기화
    private fun setViews() {
        val dec = DecimalFormat("#,###")
        var flower = intent.getSerializableExtra("flower") as Flower
        binding.flowerDetailStoreTv.text = flower.store
        binding.flowerDetailNameTv.text = flower.name
        binding.flowerDetailPriceTv.text = dec.format(flower.price)
    }

    inner class CustomPagerAdapter : RecyclerView.Adapter<CustomPagerAdapter.MyPagerViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPagerViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_flower_detail, parent, false)
            return MyPagerViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyPagerViewHolder, position: Int) {
            holder.bind(imgList[position])
        }

        override fun getItemCount(): Int {
            return imgList.size
        }

        inner class MyPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val imgView: ImageView = itemView.findViewById<ImageView>(R.id.item_flower_detail_iv)

            fun bind(img: Int) {
                imgView.setImageResource(img)
            }

        }

    }

}