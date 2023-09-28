package com.example.recyclerviewpractice.contacts.ui.adapter

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpractice.R
import com.example.recyclerviewpractice.contacts.model.Contact

class ContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val id: TextView = itemView.findViewById(R.id.contact_id)
    private val name: TextView = itemView.findViewById(R.id.name)
    private val secondName: TextView = itemView.findViewById(R.id.second_name)
    private val phoneNumber: TextView = itemView.findViewById(R.id.phone_number)

    fun onBind(contact: Contact) {
        id.text = contact.id.toString()
        name.text = contact.name
        secondName.text = contact.secondName
        phoneNumber.text = contact.phoneNumber.toString()
        itemView.setBackgroundColor(if (contact.isSelected) Color.CYAN else Color.WHITE)
    }
}