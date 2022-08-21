package com.example.flosfiore.ui.main.community

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.data.entities.Post
import com.example.flosfiore.databinding.ItemCommunityGalleryBinding

class GalleryRVAdapter (private val datalist : ArrayList<Post>) :
        RecyclerView.Adapter<GalleryRVAdapter.ViewHolder>() {

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
            val binding : ItemCommunityGalleryBinding = ItemCommunityGalleryBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datalist[position])
            holder.itemView.setOnClickListener { mItemClickListener.onItemClick(datalist[position])}

        }

        override fun getItemCount(): Int = datalist.size

        inner class ViewHolder(val binding : ItemCommunityGalleryBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(post: Post) {
                binding.itemCommunityGalleryMainIv.setImageResource(post.img!!)
                binding.itemCommunityGalleryTitleTv.text = post.title
                binding.itemCommunityGalleryWriterTv.text = post.writer
                binding.itemCommunityGalleryLikeTv.text = post.like.toString()
                binding.itemCommunityGalleryCommentTv.text = post.comment.toString()

            }
        }

    }