package com.example.flosfiore.ui.main.community

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.flosfiore.data.entities.Post
import com.example.flosfiore.databinding.ActivityCommunityDetailBinding

class CommunityDetailActivity: AppCompatActivity() {
    lateinit var binding: ActivityCommunityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommunityDetailBinding.inflate(layoutInflater)
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
        setSupportActionBar(binding.communityDetailToolbarTb)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var post = intent.getSerializableExtra("post") as Post
        binding.communityDetailWriterTv.text = post.writer
        binding.communityDetailTitleTv.text = post.title
        binding.communityDetailContentTv.text = post.content
        binding.communityDetailCommentTv.text = post.comment.toString()
        binding.communityDetailLikeTv.text = post.like.toString()
        if(post.img == null) {
            binding.communityDetailImgCv.visibility = View.GONE
        } else {
            binding.communityDetailImgIv.setImageResource(post.img!!)
        }
    }
}