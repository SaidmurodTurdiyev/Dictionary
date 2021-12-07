package com.example.mynewwords.utils

import com.example.mynewwords.R
import com.example.mynewwords.data.model.DataCountry

class MyCountries {
    private var list = ArrayList<DataCountry>()

    init {
        list.clear()
        list.add(DataCountry("Uzbek", R.drawable.uzb))
        list.add(DataCountry("English", R.drawable.mix))
        list.add(DataCountry("Arabic", R.drawable.arabia))
        list.add(DataCountry("Chinese", R.drawable.china))
        list.add(DataCountry("French", R.drawable.france))
        list.add(DataCountry("German", R.drawable.german))
        list.add(DataCountry("Italian", R.drawable.italy))
        list.add(DataCountry("Japanese", R.drawable.japan))
        list.add(DataCountry("Kazakh", R.drawable.kazakistan))
        list.add(DataCountry("Korean", R.drawable.korea))
        list.add(DataCountry("Portuguese", R.drawable.portugal))
        list.add(DataCountry("Russian", R.drawable.russion))
        list.add(DataCountry("Spanish", R.drawable.spain))
        list.add(DataCountry("Turkish", R.drawable.turkey))
    }

    fun getCountries(): List<DataCountry> {
        return list
    }
}