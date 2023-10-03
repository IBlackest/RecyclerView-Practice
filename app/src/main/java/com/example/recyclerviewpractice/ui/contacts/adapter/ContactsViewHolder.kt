package com.example.recyclerviewpractice.ui.contacts.adapter

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpractice.domain.Model
import com.example.recyclerviewpractice.R

class ContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val id: TextView = itemView.findViewById(R.id.contact_id)
    private val name: TextView = itemView.findViewById(R.id.name)
    private val secondName: TextView = itemView.findViewById(R.id.second_name)
    private val phoneNumber: TextView = itemView.findViewById(R.id.phone_number)

    fun onBind(contact: Model.Contact) {
        id.text = contact.id
        name.text = contact.name
        secondName.text = contact.secondName
        phoneNumber.text = contact.phoneNumber.toString()
        itemView.setBackgroundColor(if (contact.isSelected) Color.CYAN else Color.WHITE)
    }
}