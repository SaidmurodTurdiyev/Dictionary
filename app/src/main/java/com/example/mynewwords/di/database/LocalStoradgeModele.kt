package com.example.mynewwords.di.database

import android.content.Context
import com.example.mynewwords.data.source.local.shared.SharedDatabese
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext


@Module
@InstallIn(ApplicationComponent::class)
class LocalStoradgeModele {
    @Provides
    fun getLocalStoradge(@ApplicationContext context: Context): SharedDatabese =
        SharedDatabese.getInstaces(context)

}