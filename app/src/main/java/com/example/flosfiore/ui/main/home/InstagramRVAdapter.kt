package com.example.flosfiore.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.data.entities.Instagram
import com.example.flosfiore.databinding.ItemHomeInstaBinding

class InstagramRVAdapter (private val datalist : ArrayList<Instagram>) :
        RecyclerView.Adapter<InstagramRVAdapter.ViewHolder>() {

//        interface MyItemClickListener{
//            fun onItemClick(instagram: Instagram)
//        }
//
//        private lateinit var mItemClickListener : MyItemClickListener
//        fun setMyItemClickListener (itemClickListener: MyItemClickListener) {
//            mItemClickListener = itemClickListener
//        }

        fun addItem(instagram: Instagram) {
            datalist.add(instagram)
            notifyDataSetChanged()
        }

        fun removeItem(position: Int) {
            datalist.removeAt(position)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val binding : ItemHomeInstaBinding = ItemHomeInstaBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datalist[position])
//            holder.itemView.setOnClickListener { mItemClickListener.onItemClick(datalist[position])}

        }

        override fun getItemCount(): Int = datalist.size

        inner class ViewHolder(val binding : ItemHomeInstaBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(instagram: Instagram) {
                binding.itemInstaMainIv.setImageResource(instagram.img!!)
                binding.itemInstaTitleTv.text = instagram.title
                binding.itemInstaContentTv.text = instagram.content
                binding.itemInstaLikeTv.text = instagram.like.toString()
            }
        }

    }