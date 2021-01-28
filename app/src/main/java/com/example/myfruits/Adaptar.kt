package com.example.myfruits

import android.icu.number.NumberFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.tampilan.view.*

class Adaptar(
    private val itemList: List<MainModel>,
    private val onItemClick: (MainModel) -> Unit
) : RecyclerView.Adapter<Adaptar.DonasiListItem>() {

    class DonasiListItem constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(item: MainModel, itemClick: (MainModel) -> Unit) {
            itemView.apply {
                this.tv_title.text = item.title
                harga.text = formatRupiahs(item.price.toDouble())
                Glide.with(context).load(item.photo).into(gambarku)
                setOnClickListener { itemClick(item) }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonasiListItem {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.tampilan, parent, false)
        return DonasiListItem(view)
    }


    override fun onBindViewHolder(holder: DonasiListItem, position: Int) {
        holder.bind(itemList[position], onItemClick)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


}
