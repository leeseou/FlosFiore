package com.example.flosfiore.ui.main.community

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.flosfiore.R
import com.example.flosfiore.databinding.ActivityCommunityWriteBinding

class CommunityWriteActivity: AppCompatActivity() {
    lateinit var binding: ActivityCommunityWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommunityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViews()

    }

    // toolbar 뒤로가기 clickListener
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    // 화면 초기화
    private fun setViews() {
        // 툴바
        setSupportActionBar(binding.communityWriteToolbarTb)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_toolbar_back)
    }
}