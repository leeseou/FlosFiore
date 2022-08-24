package com.example.flosfiore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.data.entities.Item
import com.example.flosfiore.databinding.ItemPriceFlowersBinding
import java.text.DecimalFormat

class ItemRVAdapter(private val itemList: ArrayList<Item>) : RecyclerView.Adapter<ItemRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ItemRVAdapter.ViewHolder {
        val binding : ItemPriceFlowersBinding = ItemPriceFlowersBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    inner class ViewHolder(val binding: ItemPriceFlowersBinding) : RecyclerView.ViewHolder(binding.root) {
        private val dec = DecimalFormat("#,###")
        fun bind(item: Item) {
            binding.itemPriceFlowersDateTv.text = item.date
            binding.itemPriceFlowersNameTv.text = item.name
            binding.itemPriceFlowersPriceTv.text = dec.format(item.price).toString()
            binding.itemPriceFlowersUpdownIv.setImageResource(item.img!!)

        }
    }
}