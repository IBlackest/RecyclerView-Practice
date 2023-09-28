package com.example.recyclerviewpractice.flags.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpractice.R
import com.example.recyclerviewpractice.flags.model.Flag

class FlagsAdapter(private val flagClickListener: FlagClickListener) : RecyclerView.Adapter<FlagsViewHolder>() {

    var flags: ArrayList<Flag> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagsViewHolder =
        FlagsViewHolder(
            LayoutInflater.from(parent.context).inflate((R.layout.flag_container), parent, false)
        )

    override fun onBindViewHolder(holder: FlagsViewHolder, position: Int) {
        val flag = flags[position]
        holder.onBind(flag)
        holder.itemView.setOnClickListener { flagClickListener.onCLick(flag, it) }
        holder.itemView.setOnLongClickListener { flagClickListener.onLongClick(flag, it) }
    }

    override fun getItemCount(): Int = flags.size

    interface FlagClickListener {
        fun onCLick(flag: Flag, view: View)
        fun onLongClick(flag: Flag, view: View): Boolean
    }
}