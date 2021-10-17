package com.on.fsp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.on.fsp.R
import com.on.fsp.data.model.User
import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout

class MainAdapter(private val users: ArrayList<User>) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {
    var userCLickListener: UserCLickListener? = null
    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {
            itemView.apply {
                val textViewUserName = this.findViewById<TextView>(R.id.textViewUserName)
                val textViewUserSpecies = this.findViewById<TextView>(R.id.textViewUserSpecies)
                val imageViewAvatar = this.findViewById<ImageView>(R.id.imageViewAvatar)
                val container = this.findViewById<ConstraintLayout>(R.id.lcontainer)
println("########## $user.name")
                textViewUserName.text = user.name
                textViewUserSpecies.text = user.species
                Glide.with(imageViewAvatar.context)
                    .load(user.avatar)
                    .into(imageViewAvatar)

                container.setOnClickListener {
                    userCLickListener?.onClick(user.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addUsers(users: List<User>) {
        this.users.apply {
            clear()
            addAll(users)
        }
    }

        fun interface UserCLickListener {
            fun onClick(id: String)
        }
}