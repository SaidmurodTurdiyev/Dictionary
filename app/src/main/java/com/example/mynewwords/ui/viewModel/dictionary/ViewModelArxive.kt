package com.example.mynewwords.ui.viewModel.dictionary

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewwords.contracts.dictionary.ContractArxive
import com.example.mynewwords.data.model.Event
import com.example.mynewwords.data.source.local.room.entity.DictionaryEntity
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewModelArxive @ViewModelInject constructor(private var repostory: ContractArxive.Model) :
    ContractArxive.ViewModel, ViewModel() {

    private val _loadingLiveData = MediatorLiveData<Event<List<DictionaryEntity>>>()
    val loadingLiveData get() = _loadingLiveData

    private val _itemTouchLiveData = MediatorLiveData<Event<DictionaryEntity>>()
    val itemTouchLiveData get() = _itemTouchLiveData

    private val _backLiveData = MediatorLiveData<Event<Unit>>()
    val backLiveData get() = _backLiveData

    private val _openDialogDeleteAllLiveData = MediatorLiveData<Event<Int>>()
    val openDialogDeleteAllLiveData get() = _openDialogDeleteAllLiveData

    override fun itemTouch(data: DictionaryEntity) {
        itemTouchLiveData.postValue(Event(data))
    }

    override fun delete(data: DictionaryEntity) {
        viewModelScope.launch {
            repostory.delete(data)
            loadingLiveData.postValue(Event(repostory.getAllRemovedItems()))
        }
    }

    override fun update(data: DictionaryEntity) {
        viewModelScope.launch {
            repostory.update(data)
            loadingLiveData.postValue(Event(repostory.getAllRemovedItems()))
        }
    }

    override fun deleteAll() {
        viewModelScope.launch {
            repostory.deleteAll()
            loadingLiveData.postValue(Event(repostory.getAllRemovedItems()))
        }
    }

    override fun back() {
        _backLiveData.postValue(Event(Unit))
    }

    override fun openDialogDeleteAll() {
        _openDialogDeleteAllLiveData.postValue(Event(repostory.getItemCount()))
    }
}