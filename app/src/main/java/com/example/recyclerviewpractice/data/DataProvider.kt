package com.example.recyclerviewpractice.data

import com.example.recyclerviewpractice.domain.Model

object DataProvider {
    fun getFlags(): ArrayList<Model.Flag> {
        return arrayListOf(
            Model.Flag("AD", "Andorra", "https://flagsapi.com/AD/shiny/64.png", false),
            Model.Flag("AM", "Armenia", "https://flagsapi.com/AM/shiny/64.png", false),
            Model.Flag("AR", "Argentina", "https://flagsapi.com/AR/shiny/64.png", false),
            Model.Flag("AT", "Austria", "https://flagsapi.com/AT/shiny/64.png", false),
            Model.Flag("AU", "Australia", "https://flagsapi.com/AU/shiny/64.png", false),
            Model.Flag("BB", "Barbados", "https://flagsapi.com/BB/shiny/64.png", false),
            Model.Flag("BE", "Belgium", "https://flagsapi.com/BE/shiny/64.png", false),
            Model.Flag("BO", "Bolivia", "https://flagsapi.com/BO/shiny/64.png", false),
            Model.Flag("BR", "Brazil", "https://flagsapi.com/BR/shiny/64.png", false),
            Model.Flag("CA", "Canada", "https://flagsapi.com/CA/shiny/64.png", false),
            Model.Flag("CH", "Switzerland", "https://flagsapi.com/CH/shiny/64.png", false),
            Model.Flag("CO", "Colombia", "https://flagsapi.com/CO/shiny/64.png", false),
            Model.Flag("CU", "Cuba", "https://flagsapi.com/CU/shiny/64.png", false),
            Model.Flag("CY", "Cyprus", "https://flagsapi.com/CY/shiny/64.png", false),
            Model.Flag("DE", "Germany", "https://flagsapi.com/DE/shiny/64.png", false),
            Model.Flag("DK", "Denmark", "https://flagsapi.com/DK/shiny/64.png", false),
            Model.Flag("FI", "Finland", "https://flagsapi.com/FI/shiny/64.png", false),
            Model.Flag("FR", "France", "https://flagsapi.com/FR/shiny/64.png", false),
            Model.Flag("GB", "United Kingdom", "https://flagsapi.com/GB/shiny/64.png", false),
            Model.Flag("GE", "Georgia", "https://flagsapi.com/GE/shiny/64.png", false),
            Model.Flag("GR", "Greece", "https://flagsapi.com/GR/shiny/64.png", false),
            Model.Flag("IE", "Ireland", "https://flagsapi.com/IE/shiny/64.png", false),
            Model.Flag("IT", "Italy", "https://flagsapi.com/IT/shiny/64.png", false),
            Model.Flag("MC", "Monaco", "https://flagsapi.com/MC/shiny/64.png", false),
            Model.Flag("MX", "Mexico", "https://flagsapi.com/MX/shiny/64.png", false),
            Model.Flag("NP", "Nepal", "https://flagsapi.com/NP/shiny/64.png", false),
            Model.Flag("NG", "Nigeria", "https://flagsapi.com/NG/shiny/64.png", false),
            Model.Flag("NO", "Norway", "https://flagsapi.com/NO/shiny/64.png", false),
            Model.Flag("RU", "Russia", "https://flagsapi.com/RU/shiny/64.png", false),
            Model.Flag("PA", "Panama", "https://flagsapi.com/PA/shiny/64.png", false),
        )
    }

    fun getContacts(): ArrayList<Model.Contact> {
        val contacts: ArrayList<Model.Contact> = arrayListOf()
        for (i in 1..100) {
            contacts.add(
                Model.Contact(
                    i.toString(),
                    "Name$i",
                    "SecondName$i",
                    89990002200 + i,
                    false
                )
            )
        }
        return contacts
    }
}