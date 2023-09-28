package com.example.recyclerviewpractice.contacts.model

data class Contact(
    val id: Int,
    val name: String,
    val secondName: String,
    val phoneNumber: Long,
    val isSelected: Boolean
)