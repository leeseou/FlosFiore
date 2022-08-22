package com.example.flosfiore.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.data.entities.Flower
import com.example.flosfiore.databinding.ItemHomeFlowerBinding

class FlowerRVAdapter (private val datalist : ArrayList<Flower>) :
        RecyclerView.Adapter<FlowerRVAdapter.ViewHolder>() {

        interface MyItemClickListener{
            fun onItemClick(flower: Flower)
        }

        private lateinit var mItemClickListener : MyItemClickListener
        fun setMyItemClickListener (itemClickListener: MyItemClickListener) {
            mItemClickListener = itemClickListener
        }

        fun addItem(flower: Flower) {
            datalist.add(flower)
            notifyDataSetChanged()
        }

        fun removeItem(position: Int) {
            datalist.removeAt(position)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val binding : ItemHomeFlowerBinding = ItemHomeFlowerBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datalist[position])
            holder.itemView.setOnClickListener { mItemClickListener.onItemClick(datalist[position])}

        }

        override fun getItemCount(): Int = datalist.size

        inner class ViewHolder(val binding : ItemHomeFlowerBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(flower: Flower) {
                binding.itemFlowerMainIv.setImageResource(flower.img!!)
                binding.itemFlowerNameTv.text = "[" + flower.store + "] " + flower.name
            }
        }

    }