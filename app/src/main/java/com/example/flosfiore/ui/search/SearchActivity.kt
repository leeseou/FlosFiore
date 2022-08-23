package com.example.flosfiore.ui.search

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flosfiore.databinding.ActivitySearchBinding
import com.example.flosfiore.ui.main.MainActivity

class SearchActivity:AppCompatActivity() {
    lateinit var binding: ActivitySearchBinding

    lateinit var currentRVAdapter: CurrentRVAdapter
    lateinit var popularRVAdapter: PopularRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySearchBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setRVAdapters()
        setRVClickListener()

        binding.searchBackIv.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.searchSearchIv.setOnClickListener {
            var searchWord = binding.searchWordEt.text.toString()
            if(!searchWord.isEmpty()) {
                currentRVAdapter.addItem(searchWord)
                binding.searchWordEt.text = null
            }
        }

        binding.searchDeleteAllTv.setOnClickListener {
            currentRVAdapter.removeAllItem()
        }
    }

    private fun setRVAdapters() {
        val popular = arrayListOf("플랜테리어", "만천홍", "계정 꽃다발", "청자분", "꽃상자"
            , "몬스테라", "3단 축하화환", "해바라기", "알로카시아", "금전수")

        val current = arrayListOf("수국", "아레카야자", "금전수")

        currentRVAdapter = CurrentRVAdapter(current)
        popularRVAdapter = PopularRVAdapter(popular)

        var currentLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        currentLayoutManager.stackFromEnd = true

        binding.searchCurrentRv.layoutManager = currentLayoutManager
        binding.searchCurrentRv.adapter = currentRVAdapter
        binding.searchPopularRv.adapter = popularRVAdapter
    }

    private fun setRVClickListener() {
        currentRVAdapter.setMyItemClickListener(object :
            CurrentRVAdapter.MyItemClickListener {
            override fun onItemClick(position: Int) {
                currentRVAdapter.removeItem(position)
            }
        })
    }
}