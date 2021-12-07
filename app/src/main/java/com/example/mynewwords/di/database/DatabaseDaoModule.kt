package com.example.mynewwords.di.database

import com.example.mynewwords.data.source.local.room.MyDataBase
import com.example.mynewwords.data.source.local.room.dao.dictionaries.DictionaryDao
import com.example.mynewwords.data.source.local.room.dao.WordDao
import com.example.mynewwords.data.source.local.room.dao.dictionaries.ArxiveDao
import com.example.mynewwords.data.source.local.room.dao.dictionaries.DictionaryItemDao
import com.example.mynewwords.data.source.local.room.dao.dictionaries.MainDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseDaoModule {

    @Provides
    fun getDatabaseDaoWord(dataBase: MyDataBase): WordDao = dataBase.getWordsDataBase()

    @Provides
    fun getDatabaseDaoDictionaryMain(dataBase: MyDataBase): MainDao =
        dataBase.getDictionaryDataBaseForMain()

    @Provides
    fun getDatabaseDaoDictionaryArxive(dataBase: MyDataBase): ArxiveDao =
        dataBase.getDictionaryDataBaseForArxive()

    @Provides
    fun getDatabaseDaoDictionaryForItems(dataBase: MyDataBase): DictionaryItemDao =
        dataBase.getDictionoryItemDatabase()
}