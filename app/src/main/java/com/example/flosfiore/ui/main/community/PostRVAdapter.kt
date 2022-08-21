package com.example.flosfiore.ui.main.community

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.data.entities.Community
import com.example.flosfiore.databinding.ItemCommunityPostBinding

class PostRVAdapter (private val datalist : ArrayList<Community>) :
        RecyclerView.Adapter<PostRVAdapter.ViewHolder>() {

        interface MyItemClickListener{
            fun onItemClick(community: Community)
        }

        private lateinit var mItemClickListener : MyItemClickListener
        fun setMyItemClickListener (itemClickListener: MyItemClickListener) {
            mItemClickListener = itemClickListener
        }

        fun addItem(community: Community) {
            datalist.add(community)
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
            fun bind(community: Community) {
                if(community.img == null) {
                    binding.itemCommunityPostMainIv.visibility = View.GONE
                } else {
                    binding.itemCommunityPostMainIv.setImageResource(community.img!!)
                }

                if(community.content == null) {
                    binding.itemCommunityPostContentTv.visibility = View.GONE
                } else {
                    binding.itemCommunityPostContentTv.text = community.content
                }


                binding.itemCommunityPostTitleTv.text = community.title
                binding.itemCommunityPostWriterTv.text = community.writer
                binding.itemCommunityPostLikeTv.text = community.like.toString()
                binding.itemCommunityPostCommentTv.text = community.comment.toString()

            }
        }

    }