package com.example.recyclerviewpractice.flags.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewpractice.R
import com.example.recyclerviewpractice.flags.model.Flag

class FlagsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val flagImage: ImageView = itemView.findViewById(R.id.flag_image)
    private val countryId: TextView = itemView.findViewById(R.id.country_id)
    private val countryName: TextView = itemView.findViewById(R.id.country_name)

    fun onBind(flag: Flag) {
        countryId.text = flag.id
        countryName.text = flag.name
        Glide.with(itemView)
            .load(flag.flagUri)
            .fitCenter()
            .into(flagImage)
    }
}