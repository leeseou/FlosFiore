package com.example.flosfiore.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.databinding.ItemSearchPopularBinding

class PopularRVAdapter (private val datalist : ArrayList<String>) :
    RecyclerView.Adapter<PopularRVAdapter.ViewHolder>() {

    interface MyItemClickListener{
        fun onItemClick(position: Int)
    }

    private lateinit var mItemClickListener : MyItemClickListener
    fun setMyItemClickListener (itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    fun addItem(search: String) {
        datalist.add(search)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        datalist.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding : ItemSearchPopularBinding = ItemSearchPopularBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position, datalist[position])
        holder.itemView.setOnClickListener { mItemClickListener.onItemClick(position)}

    }

    override fun getItemCount(): Int = 10

    inner class ViewHolder(val binding : ItemSearchPopularBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, search: String) {
            binding.itemSearchPopularRankTv.text = (position + 1).toString()
            binding.itemSearchPopularContentTv.text = search
        }
    }

}