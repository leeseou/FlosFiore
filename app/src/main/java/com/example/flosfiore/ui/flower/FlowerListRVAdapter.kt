package com.example.flosfiore.ui.flower

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.data.entities.Flower
import com.example.flosfiore.databinding.ItemFlowerListBinding
import java.text.DecimalFormat

class FlowerListRVAdapter (private val flowerList: ArrayList<Flower>) : RecyclerView.Adapter<FlowerListRVAdapter.ViewHolder>() {

    interface MyItemClickListener{
        fun onItemClick(flower: Flower)
    }

    private lateinit var mItemClickListener : MyItemClickListener
    fun setMyItemClickListener (itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    fun addItem(flower: Flower) {
        flowerList.add(flower)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        flowerList.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding : ItemFlowerListBinding = ItemFlowerListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(flowerList[position])
        holder.itemView.setOnClickListener { mItemClickListener.onItemClick(flowerList[position])}

    }

    override fun getItemCount(): Int = flowerList.size

    inner class ViewHolder(val binding : ItemFlowerListBinding) : RecyclerView.ViewHolder(binding.root) {
        private val dec = DecimalFormat("#,###")
        fun bind(flower: Flower) {
            binding.categoryMainIv.setImageResource(flower.img!!)
            binding.categoryPriceTv.text = dec.format(flower.price)
            binding.categoryStoreTv.text = flower.store
            binding.categoryNameTv.text = flower.name
        }
    }

}