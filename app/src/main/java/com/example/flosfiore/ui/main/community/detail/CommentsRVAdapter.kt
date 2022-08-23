package com.example.flosfiore.ui.main.community.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.R
import com.example.flosfiore.data.entities.Comment
import com.example.flosfiore.databinding.ItemCommunityCommentsBinding

class CommentsRVAdapter (private val datalist : ArrayList<Comment>) :
    RecyclerView.Adapter<CommentsRVAdapter.ViewHolder>() {

//    fun addItem(post: Post) {
//        datalist.add(post)
//        notifyDataSetChanged()
//    }
//
//    fun removeItem(position: Int) {
//        datalist.removeAt(position)
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding : ItemCommunityCommentsBinding = ItemCommunityCommentsBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])
//        holder.itemView.setOnClickListener { mItemClickListener.onItemClick(datalist[position])}

    }

    override fun getItemCount(): Int = datalist.size

    inner class ViewHolder(val binding : ItemCommunityCommentsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(comment: Comment) {
            if(comment.img != null) {
                binding.itemCommunityCommentsProfileCiv.setImageResource(comment.img!!)
            } else {
                binding.itemCommunityCommentsProfileCiv.setImageResource(R.drawable.ic_mypage_profile)
            }
            binding.itemCommunityCommentsWriterTv.text = comment.writer
            binding.itemCommunityCommentsTv.text = comment.content

            // 답글이 있으면 답글 리사이클러뷰에 연결
            if (comment.comments != null) {
                val commentRVAdapter = RecommentsRVAdapter(comment.comments!!)
                binding.itemCommunityCommentsReRv.adapter = commentRVAdapter
            }
        }
    }
}