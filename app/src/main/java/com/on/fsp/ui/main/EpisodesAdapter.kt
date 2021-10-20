package com.on.fsp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.on.fsp.R
import com.on.fsp.data.model.Episode

class EpisodesAdapter(private val episodes: ArrayList<Episode>) : RecyclerView.Adapter<EpisodesAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(episodes: Episode) {
            itemView.apply {
                val textViewUserName = this.findViewById<TextView>(R.id.textViewUserName)
                val textViewUserSpecies = this.findViewById<TextView>(R.id.textViewUserSpecies)
                val imageViewAvatar = this.findViewById<ImageView>(R.id.imageViewAvatar)
                println("########## ${episodes.name}")
                textViewUserName.text = episodes.name
                textViewUserSpecies.text = episodes.air_date
                Glide.with(imageViewAvatar.context)
                    .load(episodes.avatar)
                    .into(imageViewAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = episodes.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(episodes[position])
    }

    fun addUsers(episodes: List<Episode>) {
        this.episodes.apply {
            clear()
            addAll(episodes)
        }
    }

}