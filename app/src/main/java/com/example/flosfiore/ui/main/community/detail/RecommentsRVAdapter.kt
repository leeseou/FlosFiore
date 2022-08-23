package com.example.flosfiore.ui.main.community.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.R
import com.example.flosfiore.data.entities.Comment
import com.example.flosfiore.databinding.ItemCommunityReCommentsBinding

class RecommentsRVAdapter (private val datalist : ArrayList<Comment>) :
    RecyclerView.Adapter<RecommentsRVAdapter.ViewHolder>() {

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
        val binding : ItemCommunityReCommentsBinding = ItemCommunityReCommentsBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])
//        holder.itemView.setOnClickListener { mItemClickListener.onItemClick(datalist[position])}

    }

    override fun getItemCount(): Int = datalist.size

    inner class ViewHolder(val binding : ItemCommunityReCommentsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(comment: Comment) {
            if(comment.img != null) {
                binding.itemCommunityCommentsProfileCiv.setImageResource(comment.img!!)
            } else {
                binding.itemCommunityCommentsProfileCiv.setImageResource(R.drawable.ic_mypage_profile)
            }
            binding.itemCommunityCommentsWriterTv.text = comment.writer
            binding.itemCommunityCommentsTv.text = comment.content
            binding.itemCommunityCommentsUserTv.text = "@" + comment.reUser
        }
    }
}