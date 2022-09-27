package com.qw73.itfactory.testprojectmvp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.qw73.itfactory.testprojectmvp.databinding.LayoutSectionCardsBinding
import com.qw73.itfactory.testprojectmvp.model.Item

class ItemListAdapter(
    private val items: List<Item>?,
) :
    RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {

    private lateinit var cardsBinding: LayoutSectionCardsBinding
    private lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        cardsBinding =
            LayoutSectionCardsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(cardsBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items!![position]
        val url = currentItem.image!!.x2
        holder.cardBind(currentItem, url!!)
    }

    override fun getItemCount(): Int {
        return items!!.size
    }

    inner class ViewHolder(cardsBinding: LayoutSectionCardsBinding) :
        RecyclerView.ViewHolder(cardsBinding.root) {

        fun cardBind(currentItem: Item, picUrl: String) {
            cardsBinding.cardDescription = currentItem.title
            Glide.with(cardsBinding.cardId.context).load(picUrl).into(cardsBinding.cardIcon)
        }

        init {
            cardsBinding.cardId.setOnClickListener {
                listener.onItemClick(cardsBinding.cardId)
            }
        }
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(itemView: View?)
    }
}




