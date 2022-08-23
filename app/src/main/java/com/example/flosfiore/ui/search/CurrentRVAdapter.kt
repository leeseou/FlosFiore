package com.example.flosfiore.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.databinding.ItemCurrentSearchBinding

class CurrentRVAdapter (private val datalist : ArrayList<String>) :
    RecyclerView.Adapter<CurrentRVAdapter.ViewHolder>() {

    interface MyItemClickListener{
        fun onItemClick(position: Int)
    }

    private lateinit var mItemClickListener : MyItemClickListener
    fun setMyItemClickListener (itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    fun addItem(search: String) {
        datalist.add(search)
        if(datalist.size > 5) {
            removeItem(0)
        }
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        datalist.removeAt(position)
        notifyDataSetChanged()
    }

    fun removeAllItem() {
        datalist.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding : ItemCurrentSearchBinding = ItemCurrentSearchBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])
        holder.binding.itemCurrentSearchDeleteIv.setOnClickListener { mItemClickListener.onItemClick(position) }
    }

    override fun getItemCount(): Int = datalist.size

    inner class ViewHolder(val binding : ItemCurrentSearchBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(search: String) {
            binding.itemCurrentSearchTv.text = search
        }
    }

}