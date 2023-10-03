package com.example.recyclerviewpractice.ui.flags.adapter

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewpractice.domain.Model
import com.example.recyclerviewpractice.R

class FlagsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val flagImage: ImageView = itemView.findViewById(R.id.flag_image)
    private val countryId: TextView = itemView.findViewById(R.id.country_id)
    private val countryName: TextView = itemView.findViewById(R.id.country_name)

    fun onBind(flag: Model.Flag) {
        countryId.text = flag.id
        countryName.text = flag.name
        Glide.with(itemView)
            .load(flag.flagUri)
            .fitCenter()
            .into(flagImage)
        itemView.setBackgroundColor(if (flag.isSelected) Color.CYAN else Color.WHITE)
    }
}