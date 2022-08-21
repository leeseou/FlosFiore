package com.example.flosfiore.ui.main.community

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.data.entities.Community
import com.example.flosfiore.databinding.ItemCommunityGalleryBinding

class GalleryRVAdapter (private val datalist : ArrayList<Community>) :
        RecyclerView.Adapter<GalleryRVAdapter.ViewHolder>() {

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
            val binding : ItemCommunityGalleryBinding = ItemCommunityGalleryBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datalist[position])
            holder.itemView.setOnClickListener { mItemClickListener.onItemClick(datalist[position])}

        }

        override fun getItemCount(): Int = datalist.size

        inner class ViewHolder(val binding : ItemCommunityGalleryBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(community: Community) {
                binding.itemCommunityGalleryMainIv.setImageResource(community.img!!)
                binding.itemCommunityGalleryTitleTv.text = community.title
                binding.itemCommunityGalleryWriterTv.text = community.writer
                binding.itemCommunityGalleryLikeTv.text = community.like.toString()
                binding.itemCommunityGalleryCommentTv.text = community.comment.toString()

            }
        }

    }