package com.example.mynewwords.di

import com.example.mynewwords.utils.MyCountries
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class MyCauntriesListModule {
    @Provides
    fun getMyCountries():MyCountries=MyCountries()
}