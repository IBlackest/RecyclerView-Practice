package com.example.recyclerviewpractice

import com.example.recyclerviewpractice.contacts.model.Contact
import com.example.recyclerviewpractice.flags.model.Flag

object DataProvider {
    fun getFlags(): ArrayList<Flag> {
        return arrayListOf(
            Flag("AD", "Andorra", "https://flagsapi.com/AD/shiny/64.png"),
            Flag("AM", "Armenia", "https://flagsapi.com/AM/shiny/64.png"),
            Flag("AR", "Argentina", "https://flagsapi.com/AR/shiny/64.png"),
            Flag("AT", "Austria", "https://flagsapi.com/AT/shiny/64.png"),
            Flag("AU", "Australia", "https://flagsapi.com/AU/shiny/64.png"),
            Flag("BB", "Barbados", "https://flagsapi.com/BB/shiny/64.png"),
            Flag("BE", "Belgium", "https://flagsapi.com/BE/shiny/64.png"),
            Flag("BO", "Bolivia", "https://flagsapi.com/BO/shiny/64.png"),
            Flag("BR", "Brazil", "https://flagsapi.com/BR/shiny/64.png"),
            Flag("CA", "Canada", "https://flagsapi.com/CA/shiny/64.png"),
            Flag("CH", "Switzerland", "https://flagsapi.com/CH/shiny/64.png"),
            Flag("CO", "Colombia", "https://flagsapi.com/CO/shiny/64.png"),
            Flag("CU", "Cuba", "https://flagsapi.com/CU/shiny/64.png"),
            Flag("CY", "Cyprus", "https://flagsapi.com/CY/shiny/64.png"),
            Flag("DE", "Germany", "https://flagsapi.com/DE/shiny/64.png"),
            Flag("DK", "Denmark", "https://flagsapi.com/DK/shiny/64.png"),
            Flag("FI", "Finland", "https://flagsapi.com/FI/shiny/64.png"),
            Flag("FR", "France", "https://flagsapi.com/FR/shiny/64.png"),
            Flag("GB", "United Kingdom", "https://flagsapi.com/GB/shiny/64.png"),
            Flag("GE", "Georgia", "https://flagsapi.com/GE/shiny/64.png"),
            Flag("GR", "Greece", "https://flagsapi.com/GR/shiny/64.png"),
            Flag("IE", "Ireland", "https://flagsapi.com/IE/shiny/64.png"),
            Flag("IT", "Italy", "https://flagsapi.com/IT/shiny/64.png"),
            Flag("MC", "Monaco", "https://flagsapi.com/MC/shiny/64.png"),
            Flag("MX", "Mexico", "https://flagsapi.com/MX/shiny/64.png"),
            Flag("NP", "Nepal", "https://flagsapi.com/NP/shiny/64.png"),
            Flag("NG", "Nigeria", "https://flagsapi.com/NG/shiny/64.png"),
            Flag("NO", "Norway", "https://flagsapi.com/NO/shiny/64.png"),
            Flag("RU", "Russia", "https://flagsapi.com/RU/shiny/64.png"),
            Flag("PA", "Panama", "https://flagsapi.com/PA/shiny/64.png"),
        )
    }

    fun getContacts(): ArrayList<Contact> {
        val contacts: ArrayList<Contact> = arrayListOf()
        for (i in 1..100) {
            contacts.add(Contact(i, "Name$i", "SecondName$i", 89990002200 + i, false))
        }
        return contacts
    }
}