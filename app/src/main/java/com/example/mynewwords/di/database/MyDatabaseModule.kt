package com.example.mynewwords.di.database

import android.content.Context
import com.example.mynewwords.data.source.local.room.MyDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
class MyDatabaseModule {
    @Provides
    fun getDatabase(@ApplicationContext context: Context): MyDataBase =
        MyDataBase.getDatabase(context)

}