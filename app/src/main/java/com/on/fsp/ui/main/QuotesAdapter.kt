package com.on.fsp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.on.fsp.R
import com.on.fsp.data.model.Quote
import android.content.Context;

class QuotesAdapter(private val quotes: ArrayList<Quote>) : RecyclerView.Adapter<QuotesAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(quotes: Quote) {
            itemView.apply {
                val textViewUserName = this.findViewById<TextView>(R.id.textViewUserName)
                val textViewUserSpecies = this.findViewById<TextView>(R.id.textViewUserSpecies)
                val imageViewAvatar = this.findViewById<ImageView>(R.id.imageViewAvatar)
                println("########## ${quotes.quote}")
                textViewUserName.text = quotes.quote
                textViewUserSpecies.text = quotes.by
                Glide.with(imageViewAvatar.context)
                    .load(quotes.avatar)
                    .into(imageViewAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = quotes.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(quotes[position])
    }

    fun addUsers(quotes: List<Quote>) {
        this.quotes.apply {
            clear()
            addAll(quotes)
        }
    }

}