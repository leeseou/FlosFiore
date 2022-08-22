package com.example.flosfiore.ui.main.community.detail

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.flosfiore.R
import com.example.flosfiore.data.entities.Comment
import com.example.flosfiore.data.entities.Post
import com.example.flosfiore.databinding.ActivityCommunityDetailBinding

class CommunityDetailActivity: AppCompatActivity() {
    lateinit var binding: ActivityCommunityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommunityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViews()
        setRVAdapter()
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
        binding.communityDetailCommentTv.text = post.comment.toString()
        binding.communityDetailLikeTv.text = post.like.toString()

        if(post.img == null) {
            binding.communityDetailImgCv.visibility = View.GONE
        } else {
            binding.communityDetailImgIv.setImageResource(post.img!!)
        }

        if (post.content == null) {
            binding.communityDetailContentTv.visibility = View.GONE
        } else {
            binding.communityDetailContentTv.text = post.content
        }
    }

    // 리사이클러뷰 어댑터 연결
    private fun setRVAdapter() {
        val commentList = arrayListOf(
            Comment(R.drawable.img_gallery3, "수염틸란드시아는 고양이와 함께 키워도 좋습니다.", "조이", System.currentTimeMillis()
                , null, arrayListOf(Comment(null, "감사합니다!", "모긴", System.currentTimeMillis(), "조이", null)))
        )
        val commentRVAdapter = CommentsRVAdapter(commentList)
        binding.communityDetailCommentRv.adapter = commentRVAdapter
    }
}