package com.example.recyclerviewpractice.ui.contacts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpractice.domain.Model
import com.example.recyclerviewpractice.R
import com.example.recyclerviewpractice.util.ContactsDiffUtilCallback

class ContactsAdapter(private val onClickListener: ContactClickListener) :
    RecyclerView.Adapter<ContactsViewHolder>() {

    var contacts: ArrayList<Model.Contact> = arrayListOf()
    var oldContacts: ArrayList<Model.Contact> = arrayListOf()
    private var checkedContacts: MutableMap<Int, Model.Contact> = mutableMapOf()
    private var diffUtilCallback = ContactsDiffUtilCallback(oldContacts, contacts)

    private var deleteButtonState = MutableLiveData<Boolean>()
    fun observeDeleteButtonState(): LiveData<Boolean> = deleteButtonState

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder =
        ContactsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.contact_container, parent, false)
        )

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val contact = contacts[holder.adapterPosition]
        holder.onBind(contact)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(contact, holder.adapterPosition)
        }

        holder.itemView.setOnLongClickListener {
            val newContact = contact.copy(isSelected = !contact.isSelected)
            contacts[holder.adapterPosition] = newContact
            if (newContact.isSelected) checkedContacts[holder.adapterPosition] =
                newContact else checkedContacts.remove(holder.adapterPosition)
            notifyItemChanged(holder.adapterPosition)
            deleteButtonState.value = checkedContacts.isNotEmpty()
            true
        }
    }

    fun deleteSelectedContacts() {
        oldContacts.apply {
            clear()
            addAll(contacts)
        }
        for (contact in checkedContacts) {
            contacts.remove(contact.value)
        }
        checkedContacts.clear()
        diffUtilCallback.apply {
            oldList = oldContacts
            newList = contacts
        }
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
        diffResult.dispatchUpdatesTo(this)
        deleteButtonState.value = false
    }

    override fun getItemCount(): Int = contacts.size

    fun interface ContactClickListener {
        fun onClick(contact: Model.Contact, position: Int)
    }
}