package com.example.recyclerviewpractice.util

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerviewpractice.domain.Model

class ContactsDiffUtilCallback<T: Model>(var oldList: List<T>, var newList: List<T>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        (oldList[oldItemPosition] == newList[newItemPosition])

}