package com.on.fsp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.on.fsp.R
import com.on.fsp.data.model.Location
import android.content.Context;

class LocationsAdapter(private val locations: ArrayList<Location>) : RecyclerView.Adapter<LocationsAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(locations: Location) {
            itemView.apply {
                val textViewUserName = this.findViewById<TextView>(R.id.textViewUserName)
                val textViewUserSpecies = this.findViewById<TextView>(R.id.textViewUserSpecies)
                val imageViewAvatar = this.findViewById<ImageView>(R.id.imageViewAvatar)
                println("########## ${locations.name}")
                textViewUserName.text = locations.name
                textViewUserSpecies.text = locations.type
                Glide.with(imageViewAvatar.context)
                    .load(locations.avatar)
                    .into(imageViewAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = locations.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(locations[position])
    }

    fun addUsers(locations: List<Location>) {
        this.locations.apply {
            clear()
            addAll(locations)
        }
    }

}