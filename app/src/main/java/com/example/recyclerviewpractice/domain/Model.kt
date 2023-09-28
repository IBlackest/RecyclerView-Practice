package com.example.recyclerviewpractice.domain

sealed class Model(open val id: String) {

    data class Contact(
        override val id: String = "",
        val name: String = "",
        val secondName: String = "",
        val phoneNumber: Long = 0L,
        val isSelected: Boolean = false
    ) : Model(id)

    data class Flag(
        override val id: String,
        val name: String,
        val flagUri: String,
        val isSelected: Boolean
    ) : Model(id)

}
