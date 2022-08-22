package com.example.flosfiore.ui.main.community

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.data.entities.Post
import com.example.flosfiore.databinding.ItemCommunityPostBinding

class PostRVAdapter (private val datalist : ArrayList<Post>) :
        RecyclerView.Adapter<PostRVAdapter.ViewHolder>() {

        interface MyItemClickListener{
            fun onItemClick(post: Post)
        }

        private lateinit var mItemClickListener : MyItemClickListener
        fun setMyItemClickListener (itemClickListener: MyItemClickListener) {
            mItemClickListener = itemClickListener
        }

        fun addItem(post: Post) {
            datalist.add(post)
            notifyDataSetChanged()
        }

        fun removeItem(position: Int) {
            datalist.removeAt(position)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val binding : ItemCommunityPostBinding = ItemCommunityPostBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datalist[position])
            holder.itemView.setOnClickListener { mItemClickListener.onItemClick(datalist[position])}

        }

        override fun getItemCount(): Int = datalist.size

        inner class ViewHolder(val binding : ItemCommunityPostBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(post: Post) {
                if(post.img == null) {
                    binding.itemCommunityPostMainIv.visibility = View.GONE
                } else {
                    binding.itemCommunityPostMainIv.setImageResource(post.img!!)
                }

                if(post.content == null) {
                    binding.itemCommunityPostContentTv.visibility = View.GONE
                } else {
                    binding.itemCommunityPostContentTv.text = post.content
                }


                binding.itemCommunityPostTitleTv.text = post.title
                binding.itemCommunityPostWriterTv.text = post.writer
                binding.itemCommunityPostLikeTv.text = post.like.toString()
                binding.itemCommunityPostCommentTv.text = post.comment.toString()

            }
        }

    }