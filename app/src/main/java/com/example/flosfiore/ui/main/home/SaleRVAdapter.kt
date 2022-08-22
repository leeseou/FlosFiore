package com.example.flosfiore.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.data.entities.Flower
import com.example.flosfiore.databinding.ItemHomeSaleBinding

class SaleRVAdapter (private val datalist : ArrayList<Flower>) :
        RecyclerView.Adapter<SaleRVAdapter.ViewHolder>() {

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
            val binding : ItemHomeSaleBinding = ItemHomeSaleBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datalist[position])
            holder.itemView.setOnClickListener { mItemClickListener.onItemClick(datalist[position])}

        }

        override fun getItemCount(): Int = datalist.size

        inner class ViewHolder(val binding : ItemHomeSaleBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(flower: Flower) {
                binding.itemSaleMainIv.setImageResource(flower.img!!)
                binding.itemSalePercentTv.text = flower.sale.toString() + "%"
                binding.itemSalePriceTv.text = flower.price.toString()
                binding.itemSaleNameTv.text = "[" + flower.store + "] " + flower.name
            }
        }

    }