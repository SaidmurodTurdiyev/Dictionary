package com.example.mynewwords.contracts.dictionary

import com.example.mynewwords.data.model.DataCountry

interface ContractChooseLanguages {
    interface Model {
        suspend fun getCountryList():List<DataCountry>
        suspend fun setCountryOne(countryId:Int)
        suspend fun setCountryTwo(countryId: Int)
        suspend fun getCountryOne():Int
        suspend fun getCountryTwo():Int
        suspend fun setFirstEnter()
        suspend fun getIsFirstCountry():Boolean
    }
    interface ViewModel{
        fun clickOneCountry()
        fun setCauntryOne(countryId: Int)
        fun clickTwoCountry()
        fun setCauntryTwo(countryId: Int)
        fun done()
    }
}