package com.example.flosfiore.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.data.entities.Store
import com.example.flosfiore.databinding.ItemHomePopularBinding

class PopularRVAdapter (private val datalist : ArrayList<Store>) :
        RecyclerView.Adapter<PopularRVAdapter.ViewHolder>() {

        interface MyItemClickListener{
            fun onItemClick(store: Store)
        }

        private lateinit var mItemClickListener : MyItemClickListener
        fun setMyItemClickListener (itemClickListener: MyItemClickListener) {
            mItemClickListener = itemClickListener
        }

        fun addItem(store: Store) {
            datalist.add(store)
            notifyDataSetChanged()
        }

        fun removeItem(position: Int) {
            datalist.removeAt(position)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val binding : ItemHomePopularBinding = ItemHomePopularBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datalist[position])
            holder.itemView.setOnClickListener { mItemClickListener.onItemClick(datalist[position])}

        }

        override fun getItemCount(): Int = datalist.size

        inner class ViewHolder(val binding : ItemHomePopularBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(store: Store) {
                binding.itemPopularMainIv.setImageResource(store.img!!)
                binding.itemPopularNameTv.text = store.name
                binding.itemPopularLocationTv.text = store.location
            }
        }

    }