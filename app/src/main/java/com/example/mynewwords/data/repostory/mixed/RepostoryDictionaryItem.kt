package com.example.mynewwords.data.repostory.mixed

import com.example.mynewwords.contracts.mixed.ContractDictionaryItem
import com.example.mynewwords.data.model.DataCountry
import com.example.mynewwords.data.source.local.room.dao.dictionaries.DictionaryDao
import com.example.mynewwords.data.source.local.room.dao.dictionaries.DictionaryItemDao
import com.example.mynewwords.data.source.local.room.dao.dictionaries.MainDao
import com.example.mynewwords.data.source.local.room.entity.DictionaryEntity
import com.example.mynewwords.utils.MyCountries
import javax.inject.Inject

class RepostoryDictionaryItem @Inject constructor(
    private var countries: MyCountries,
    private var databse: DictionaryItemDao
) :
    ContractDictionaryItem.Model {

    override suspend fun getData(id: Long): DictionaryEntity = databse.getDictionaryById(id)

    override suspend fun getTextInfo(id: Long): String = databse.getDictionaryById(id).dataInfo

    override suspend fun getCountryList(): List<DataCountry> = countries.getCountries()

    override suspend fun getLearnCountText(): String {
        TODO("Not yet implemented")
    }

    override suspend fun updateData(data: DictionaryEntity) = databse.update(data)
}