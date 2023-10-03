package com.example.recyclerviewpractice.ui.flags.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpractice.domain.Model
import com.example.recyclerviewpractice.R

class FlagsAdapter() : RecyclerView.Adapter<FlagsViewHolder>() {

    var flags: ArrayList<Model.Flag> = arrayListOf()
    private var positionSelected: Int? = null
    private var oldFlags: ArrayList<Model.Flag> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagsViewHolder =
        FlagsViewHolder(
            LayoutInflater.from(parent.context).inflate((R.layout.flag_container), parent, false)
        )

    override fun onBindViewHolder(
        holder: FlagsViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val flag = flags[position]
        holder.onBind(flag)
        holder.itemView.setOnClickListener {
            if (positionSelected == null) {
                val newFlag = flag.copy(isSelected = true)
                flags[position] = newFlag
                notifyItemChanged(position)
                positionSelected = position
            } else {
                oldFlags.apply {
                    clear()
                    addAll(flags)
                }
                flags[positionSelected!!] = oldFlags[position].copy(isSelected = false)
                flags[position] = oldFlags[positionSelected!!].copy(isSelected = false)
                notifyItemChanged(position)
                notifyItemChanged(positionSelected!!)
                positionSelected = null
            }
        }
    }

    override fun getItemCount(): Int = flags.size
}