package com.example.mynewwords.contracts.mixed

import com.example.mynewwords.data.model.DataCountry
import com.example.mynewwords.data.source.local.room.entity.DictionaryEntity

interface ContractDictionaryItem {
    interface Model {
        suspend fun getData(id: Long): DictionaryEntity
        suspend fun getTextInfo(id: Long): String
        suspend fun updateData(data: DictionaryEntity)
        suspend fun getCountryList(): List<DataCountry>
        suspend fun getLearnCountText(): String
    }

    interface View {
        fun loadData(data: DictionaryEntity)
        fun loadCountryOne(dataCountry: DataCountry)
        fun loadCountryTwo(dataCountry: DataCountry)
        fun loadDataLearnPracent(text: String)
        fun openChangeLangugeDialogOne(countryId: Int)
        fun openChangeLangugeDialogTwo(countryDismis: Int, countryId: Int)
        fun openInfoText(textInfo: String)
        fun openList(id: Long)
        fun closeWindow()
    }

    interface ViwModel {
        fun openInfo(id: Long)
        fun openList()
        fun openCountryDilog(isCountryOne: Boolean, id: Long)
        fun setCountryOne(countryId: Int, id: Long)
        fun setCountryTwo(countryId: Int, id: Long)
        fun loadItem(id: Long)
        fun close()
    }
}