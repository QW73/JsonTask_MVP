package com.qw73.itfactory.testprojectmvp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qw73.itfactory.testprojectmvp.databinding.LayoutSectionBinding
import com.qw73.itfactory.testprojectmvp.model.Section

class SectionsListAdapter(private val sectionsList: List<Section>, private val context: Context) :
    RecyclerView.Adapter<SectionsListAdapter.MyViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()
    private lateinit var sectionBinding: LayoutSectionBinding
    private var selectedItems: MutableList<View> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        sectionBinding =
            LayoutSectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(sectionBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentSection = sectionsList[position]
        holder.bind(currentSection)
        val cardsRV = sectionBinding.recyclerViewForCards
        val adapter = ItemListAdapter(currentSection.items)
        val itemLayoutManager = LinearLayoutManager(
            cardsRV.context, LinearLayoutManager.HORIZONTAL, false)

        cardsRV.apply {
            layoutManager = itemLayoutManager
            cardsRV.adapter = adapter
            adapter.setOnItemClickListener(object : ItemListAdapter.OnItemClickListener {
                override fun onItemClick(itemView: View?) {
                    if (selectedItems.size < 6) {
                        if (itemView?.isSelected == true) {
                            unselectItem(itemView)
                        } else {
                            selectItem(itemView!!)
                        }
                    } else {
                        clearSelection(selectedItems)
                    }
                }
            })
            setRecycledViewPool(viewPool)
        }
    }

    fun clearSelection(selectedItems: MutableList<View>) {
        for (i in 0 until selectedItems.size) {
            selectedItems[i].isSelected = false
        }
        selectedItems.clear()
        notifyDataSetChanged()
        Toast.makeText(context,
            "More than 6 articles were selected!",
            Toast.LENGTH_SHORT).show()
    }

    fun selectItem(v: View) {
        v.isSelected = true
        selectedItems.add(v)
    }

    fun unselectItem(v: View) {
        v.isSelected = false
        selectedItems.remove(v)
    }

    override fun getItemCount(): Int {
        return sectionsList.size
    }

    inner class MyViewHolder(sectionBinding: LayoutSectionBinding) :
        RecyclerView.ViewHolder(sectionBinding.root) {

        fun bind(currentSection: Section) {
            sectionBinding.title = currentSection.header
        }
    }
}