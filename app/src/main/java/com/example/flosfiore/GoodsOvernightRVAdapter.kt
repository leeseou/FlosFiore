package com.example.flosfiore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.data.entities.GoodsOvernight
import com.example.flosfiore.databinding.FragmentCartBinding
import com.example.flosfiore.databinding.ItemCartOvernightGoodsBinding

class GoodsOvernightRVAdapter(private val goodsOvernightList: ArrayList<GoodsOvernight>) : RecyclerView.Adapter<GoodsOvernightRVAdapter.ViewHolder>() {

    interface MyItemClickListener{
        fun onItemClick()
        fun onRemoveGoodsOvernight(position: Int)
        fun onDownBtnClick(goodsOvernight: GoodsOvernight)
        fun onUpBtnClick(goodsOvernight: GoodsOvernight)
        fun onSelectClick(goodsOvernight: GoodsOvernight)
    }

    private lateinit var mItemClickListener: MyItemClickListener
    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }


    fun removeGoods(position: Int){
        goodsOvernightList.removeAt(position)
        notifyDataSetChanged()
    }

    fun addNum(goodsOvernight: GoodsOvernight){
        goodsOvernight.count++
        goodsOvernight.total += goodsOvernight.price
        notifyDataSetChanged()
    }

    fun abstractNum(goodsOvernight: GoodsOvernight){
        if(goodsOvernight.count > 1){
            goodsOvernight.count--
            goodsOvernight.total -= goodsOvernight.price
        }
        notifyDataSetChanged()
    }

    fun selectGoods(goodsOvernight: GoodsOvernight){
        if(goodsOvernight.choose){
            goodsOvernight.select = R.drawable.ic_cart_not_select
            goodsOvernight.choose=false
        }
        else{
            goodsOvernight.select = R.drawable.ic_cart_select
            goodsOvernight.choose=true
        }
        notifyDataSetChanged()
    }

    fun setCheckAll(boolean: Boolean){
        for(goodsOvernight in goodsOvernightList){
            if(boolean) {
                goodsOvernight.select = R.drawable.ic_cart_select
                goodsOvernight.choose = true
            }
            else{
                goodsOvernight.select = R.drawable.ic_cart_not_select
                goodsOvernight.choose=false
            }
        }
        notifyDataSetChanged()
    }

    fun countSelect(): Boolean{
        notifyDataSetChanged()
        for(goodsOvernight in goodsOvernightList){
            if(goodsOvernight.choose){ continue }
            else{ return false }
        }
        return true

    }


    fun sumPrice(): Int{
        var sum : Int = 0
        for(goodsOvernight in goodsOvernightList){
            if(goodsOvernight.choose) {sum += goodsOvernight.total}
        }
        return sum
    }

    fun countGoods(): Int{
        var count : Int = 0
        for(goodsOvernight in goodsOvernightList){
            if(goodsOvernight.choose) {count += goodsOvernight.count}
        }
        return count
    }

    fun removeSelected() {
        for(i in goodsOvernightList.size - 1 downTo(0)) {
            if(goodsOvernightList[i].choose) {
                removeGoods(i)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): GoodsOvernightRVAdapter.ViewHolder {
        val binding : ItemCartOvernightGoodsBinding = ItemCartOvernightGoodsBinding.inflate(
            LayoutInflater.from(viewGroup.context),viewGroup,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(goodsOvernightList[position])
        holder.binding.itemCartOvernightGoodsDeleteIv.setOnClickListener { mItemClickListener.onRemoveGoodsOvernight(position) }
        holder.binding.itemCartOvernightGoodsDownBn.setOnClickListener { mItemClickListener.onDownBtnClick(goodsOvernightList[position]) }
        holder.binding.itemCartOvernightGoodsUpBn.setOnClickListener { mItemClickListener.onUpBtnClick(goodsOvernightList[position]) }
        holder.binding.itemCartOvernightGoodsSelectIv.setOnClickListener { mItemClickListener.onSelectClick(goodsOvernightList[position]) }

    }

    override fun getItemCount(): Int = goodsOvernightList.size


    inner class ViewHolder(val binding: ItemCartOvernightGoodsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(goodsOvernight: GoodsOvernight) {
            binding.itemCartOvernightGoodsSelectIv.setImageResource(goodsOvernight.select!!)
            binding.itemCartOvernightGoodsImgIv.setImageResource(goodsOvernight.img!!)
            binding.itemCartOvernightGoodsPlaceTv.text = goodsOvernight.place
            binding.itemCartOvernightGoodsNameTv.text = goodsOvernight.name
            binding.itemCartOvernightGoodsColorTv.text = goodsOvernight.color
            binding.itemCartOvernightGoodsCenterBn.text = "${goodsOvernight.count}"
            binding.itemCartOvernightGoodsPriceTv.text = "${goodsOvernight.total}원"

        }

    }
}