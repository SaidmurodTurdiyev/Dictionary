package com.example.mynewwords.di.repostory

import com.example.mynewwords.contracts.dictionary.ContractArxive
import com.example.mynewwords.contracts.dictionary.ContractChooseLanguages
import com.example.mynewwords.contracts.dictionary.ContractMain
import com.example.mynewwords.contracts.mixed.ContractDictionaryItem
import com.example.mynewwords.data.repostory.dictionary.RepostoryArxiv
import com.example.mynewwords.data.repostory.dictionary.RepostoryChooseCountry
import com.example.mynewwords.data.repostory.dictionary.RepostoryMain
import com.example.mynewwords.data.repostory.mixed.RepostoryDictionaryItem
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
interface ContractRepostoryImp {
    @Binds
    fun getMainRepastory(repostory: RepostoryMain): ContractMain.Model

    @Binds
    fun getDictionaryItemRepostory(repostory: RepostoryDictionaryItem): ContractDictionaryItem.Model

    @Binds
    fun getChooseCountryRepostory(repostoryChooseCountry: RepostoryChooseCountry): ContractChooseLanguages.Model

    @Binds
    fun getArxiveDictionary(repostory: RepostoryArxiv): ContractArxive.Model
}