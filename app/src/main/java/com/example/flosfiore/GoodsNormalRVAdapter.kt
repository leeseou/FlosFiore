package com.example.flosfiore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.data.entities.GoodsNormal
import com.example.flosfiore.databinding.ItemCartNormalGoodsBinding

class GoodsNormalRVAdapter(private val goodsNormalList: ArrayList<GoodsNormal>) : RecyclerView.Adapter<GoodsNormalRVAdapter.ViewHolder>() {

    interface MyItemClickListener{
        fun onItemClick()
        fun onRemoveGoodsNormal(position: Int)
        fun onDownBtnClick(goodsNormal: GoodsNormal)
        fun onUpBtnClick(goodsNormal: GoodsNormal)
        fun onSelectClick(goodsNormal: GoodsNormal)
    }

    private lateinit var mItemClickListener: MyItemClickListener
    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }

    fun addGoods(goodsNormal: GoodsNormal){
        goodsNormalList.add(goodsNormal)
        notifyDataSetChanged()
    }

    fun removeGoods(position: Int){
        goodsNormalList.removeAt(position)
        notifyDataSetChanged()
    }

    fun addNum(goodsNormal: GoodsNormal){
        goodsNormal.count++
        goodsNormal.total += goodsNormal.price
        notifyDataSetChanged()
    }

    fun abstractNum(goodsNormal: GoodsNormal){
        if(goodsNormal.count > 1){
            goodsNormal.count--
            goodsNormal.total -= goodsNormal.price
        }
        notifyDataSetChanged()
    }

    fun selectGoods(goodsNormal: GoodsNormal){
        if(goodsNormal.choose){
            goodsNormal.select = R.drawable.ic_cart_not_select
            goodsNormal.choose=false
        }
        else{
            goodsNormal.select = R.drawable.ic_cart_select
            goodsNormal.choose=true
        }
        notifyDataSetChanged()
    }

    fun setCheckAll(boolean: Boolean){
        for(goodsNormal in goodsNormalList){
            if(boolean) {
                goodsNormal.select = R.drawable.ic_cart_select
                goodsNormal.choose = true
            }
            else{
                goodsNormal.select = R.drawable.ic_cart_not_select
                goodsNormal.choose=false
            }
        }

        notifyDataSetChanged()
    }

    fun countSelect(): Boolean{
        notifyDataSetChanged()
        for(goodsNormal in goodsNormalList){
            if(goodsNormal.choose){ continue }
            else{ return false }
        }
        return true
    }

    fun sumPrice(): Int{
        var sum : Int = 0
        for(goodsNormal in goodsNormalList){
            if(goodsNormal.choose) {sum += goodsNormal.total}
        }
        notifyDataSetChanged()
        return sum
    }

    fun countGoods(): Int{
        var count : Int = 0
        for(goodsNormal in goodsNormalList){
            if(goodsNormal.choose) {count += goodsNormal.count}
        }
        return count
    }

    fun removeSelected() {
        for(i in goodsNormalList.size - 1 downTo(0)) {
            if(goodsNormalList[i].choose) {
                removeGoods(i)
            }
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): GoodsNormalRVAdapter.ViewHolder {
        val binding : ItemCartNormalGoodsBinding = ItemCartNormalGoodsBinding.inflate(
            LayoutInflater.from(viewGroup.context),viewGroup,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(goodsNormalList[position])
        holder.binding.itemCartNormalGoodsDeleteIv.setOnClickListener { mItemClickListener.onRemoveGoodsNormal(position) }
        holder.binding.itemCartNormalGoodsDownBn.setOnClickListener { mItemClickListener.onDownBtnClick(goodsNormalList[position]) }
        holder.binding.itemCartNormalGoodsUpBn.setOnClickListener { mItemClickListener.onUpBtnClick(goodsNormalList[position]) }
        holder.binding.itemCartNormalGoodsSelectIv.setOnClickListener { mItemClickListener.onSelectClick(goodsNormalList[position]) }
    }

    override fun getItemCount(): Int = goodsNormalList.size


    inner class ViewHolder(val binding: ItemCartNormalGoodsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(goodsNormal: GoodsNormal) {
            binding.itemCartNormalGoodsSelectIv.setImageResource(goodsNormal.select!!)
            binding.itemCartNormalGoodsImgIv.setImageResource(goodsNormal.img!!)
            binding.itemCartNormalGoodsPlaceTv.text = goodsNormal.place
            binding.itemCartNormalGoodsNameTv.text = goodsNormal.name
            binding.itemCartNormalGoodsColorTv.text = goodsNormal.color
            binding.itemCartNormalGoodsCenterBn.text = "${goodsNormal.count}"
            binding.itemCartNormalGoodsPriceTv.text = "${goodsNormal.total}원"

        }

    }
}