package com.example.flosfiore.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.*
import com.example.flosfiore.data.entities.Flower
import com.example.flosfiore.data.entities.Instagram
import com.example.flosfiore.data.entities.Store
import com.example.flosfiore.databinding.FragmentFlowerListBinding
import com.example.flosfiore.databinding.FragmentHomeBinding
import com.example.flosfiore.ui.flower.FlowerDetailActivity
import com.example.flosfiore.ui.flower.FlowerListActivity
import com.example.flosfiore.ui.flower.FlowerListRVAdapter
import com.google.android.material.tabs.TabLayoutMediator

// 홈 프레그먼트
class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    private val category = arrayListOf("생화", "야생화/다육이", "동양란", "서양란", "축하화환", "근조화환", "이색상품", "관엽화분")
    private val flowerList = arrayListOf(
        Flower(R.drawable.img_home_tb1, "가든 꽃바구니", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb2, "특별한 마음 꽃다발", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb3, "분홍장미계절꽃다발", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb4, "특별한 마음 꽃다발", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb1, "가든 꽃바구니", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb2, "특별한 마음 꽃다발", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb3, "분홍장미계절꽃다발", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb4, "특별한 마음 꽃다발", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb1, "가든 꽃바구니", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb2, "특별한 마음 꽃다발", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb3, "분홍장미계절꽃다발", 88000, "플로레 화원"),
        Flower(R.drawable.img_home_tb4, "특별한 마음 꽃다발", 88000, "플로레 화원")
    )

    private var flowerListRVAdapter = FlowerListRVAdapter(flowerList, 4)
    lateinit var best10Adapter: Best10RVAdapter
    lateinit var saleAdapter: SaleRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //카테고리 탭레이아웃, 뷰페이저 연결
        val categoryadapter = CustomPagerAdapter()
        binding.homeCategoryVp.adapter = categoryadapter
        TabLayoutMediator(binding.homeCategoryTb, binding.homeCategoryVp) {
                tab, position ->
            tab.text = category[position]
        }.attach()

        setRVAdapters()
        setRVClickListeners()

        binding.homeLocationTv.setOnClickListener {
            startActivity(Intent(requireContext(), FlowerDetailActivity::class.java))
        }

        binding.homeViewAllBtn.setOnClickListener {
            startActivity(Intent(requireContext(), FlowerListActivity::class.java))
        }

        flowerListRVAdapter.setMyItemClickListener(object :
            FlowerListRVAdapter.MyItemClickListener {
            override fun onItemClick(flower: Flower) {
                var intent = Intent(requireContext(), FlowerDetailActivity::class.java)
                intent.putExtra("flower", flower)
                startActivity(intent)
            }
        })

        return binding.root
    }

    fun setRVAdapters() {
        // 인기상품, 이색식물
        var best10List = arrayListOf(
            Flower(R.drawable.img_home_tb1, "가든 꽃바구니", 88000, "플로레 화원"),
            Flower(R.drawable.img_home_tb2, "가든 꽃바구니", 88000, "플로레 화원"),
            Flower(R.drawable.img_home_tb3, "가든 꽃바구니", 88000, "플로레 화원"),
            Flower(R.drawable.img_home_tb4, "가든 꽃바구니", 88000, "플로레 화원"),
            Flower(R.drawable.img_home_tb4, "가든 꽃바구니", 88000, "플로레 화원"),
        )

        // 할인 상품
        var saleList = arrayListOf(
            Flower(R.drawable.img_home_sale1, "가든 꽃바구니", 60000, "플로레 화원", 30),
            Flower(R.drawable.img_home_sale2, "가든 꽃바구니", 45000, "플로레 화원", 50),
            Flower(R.drawable.img_home_sale3, "가든 꽃바구니", 60000, "플로레 화원", 30),

        )

        //인기 꽃집
        var popularList = arrayListOf(
            Store(R.drawable.img_home_store1, "벨플로르", "서울시 노원구 중계동"),
            Store(R.drawable.img_home_store2, "포포 플라워", "서울시 노원구 월계동"),
            Store(R.drawable.img_home_store3, "참새 꽃집", "서울시 노원구 월계동")
        )

        // 생화
        var flowerList = arrayListOf(
            Flower(R.drawable.img_home_tb1, "마음을 전하는 8월 꽃다발", 0, "피오레 꽃집"),
            Flower(R.drawable.img_home_tb2, "고급 포장 수국 꽃바구니", 0, "99 플라워"),
            Flower(R.drawable.img_home_tb3, "사랑을 전하세요 러브 포유", 0, "플로레 화원"),
            Flower(R.drawable.img_home_tb4, "마음을 전하는 8월 꽃다발", 0, "피오레 꽃집"),
            Flower(R.drawable.img_home_tb1, "고급 포장 수국 꽃바구니", 0, "99 플라워"),
            Flower(R.drawable.img_home_tb2, "사랑을 전하세요 러브 포유", 0, "플로레 화원"),
        )

        // 인스타그램
        var instagramList = arrayListOf(
            Instagram(
                R.drawable.img_home_test, "회색 도시를 녹색으로 바꾸는 '플랜테리어'",
                "유럽에서는 가정이나 사무실 등에서 식물을 인테리어로 활용하는 플랜테리어(Plant+Interior)가 여전히 큰 인기를...", 52),
            Instagram(
                R.drawable.img_home_test, "회색 도시를 녹색으로 바꾸는 '플랜테리어'",
                "유럽에서는 가정이나 사무실 등에서 식물을 인테리어로 활용하는 플랜테리어(Plant+Interior)가 여전히 큰 인기를...", 52)
        )

        best10Adapter = Best10RVAdapter(best10List)
        binding.homeBest10Rv.adapter = best10Adapter
        binding.homeUniqueRv.adapter = best10Adapter

        saleAdapter = SaleRVAdapter(saleList)
        binding.homeSaleRv.adapter = saleAdapter

        var popularAdapter = PopularRVAdapter(popularList)
        binding.homePopularRv.adapter = popularAdapter

        var flowerAdapter = FlowerRVAdapter(flowerList)
        binding.homeFlowerRv.adapter = flowerAdapter
        activity.let {
            binding.homeFlowerRv.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        }

        var instaAdapter = InstagramRVAdapter(instagramList)
        binding.homeInstaRv.adapter = instaAdapter
    }

    fun setRVClickListeners() {
        flowerListRVAdapter.setMyItemClickListener(object :
            FlowerListRVAdapter.MyItemClickListener {
            override fun onItemClick(flower: Flower) {
                var intent = Intent(requireContext(), FlowerDetailActivity::class.java)
                intent.putExtra("flower", flower)
                startActivity(intent)
            }
        })

        best10Adapter.setMyItemClickListener(object :
            Best10RVAdapter.MyItemClickListener {
            override fun onItemClick(flower: Flower) {
                var intent = Intent(requireContext(), FlowerDetailActivity::class.java)
                intent.putExtra("flower", flower)
                startActivity(intent)
            }
        })

        saleAdapter.setMyItemClickListener(object :
            SaleRVAdapter.MyItemClickListener {
            override fun onItemClick(flower: Flower) {
                var intent = Intent(requireContext(), FlowerDetailActivity::class.java)
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