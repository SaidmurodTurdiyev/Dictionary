package com.example.mynewwords.ui.screens.dictionary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.mynewwords.R
import com.example.mynewwords.data.model.DataCountry
import com.example.mynewwords.data.model.DataMoveCountry
import com.example.mynewwords.data.model.Event
import com.example.mynewwords.databinding.FragmentSelectLanguageBinding
import com.example.mynewwords.ui.dialogs.DialogCountry
import com.example.mynewwords.ui.viewModel.dictionary.ViewModelChooseCountry
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentChooseLanguages :
    Fragment(R.layout.fragment_select_language) {
    /*
    * Null objects
    * */
    private var binding: FragmentSelectLanguageBinding? = null

    /*
    * ViewModel is created
    * */
    private val viewModel: ViewModelChooseCountry by viewModels()

    /*
    * Observers is created
    * */
    private val _setCountryOneObserver = Observer<Event<DataCountry>> {
        setCountryOne(it.peekContent())
    }

    private val _setCountryTwoObserver = Observer<Event<DataCountry>> {
        setCauntryTwo(it.peekContent())
    }

    private val _openNextObserver = Observer<Event<Unit>> {
        val data = it.getContentIfNotHandled()
        if (data != null)
            findNavController().navigate(FragmentChooseLanguagesDirections.actionOpenfragmentMainInChooselangiages())
    }
    private val _closeObserver = Observer<Event<Unit>> {
        val data = it.getContentIfNotHandled()
        if (data != null)
            findNavController().navigateUp()
    }

    private val _openCountryDialogOneObserver = Observer<Event<DataMoveCountry>> {
        val data = it.getContentIfNotHandled()
        if (data != null) {
            val d = DialogCountry(requireActivity(), data.countryId)
            d.submitListener {
                viewModel.setCauntryOne(it)
            }
            d.show()
        }
    }

    private val _openCountryDialogTwoObserver = Observer<Event<DataMoveCountry>> {
        val data = it.getContentIfNotHandled()
        if (data != null) {
            val notCountry = data.notCountry
            if (notCountry != null) {
                val d = DialogCountry(requireActivity(), data.countryId, notCountry)
                d.submitListener {
                    viewModel.setCauntryTwo(it)
                }
                d.show()
            }
        }
    }

    /*
    * Override methods
    * */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentSelectLanguageBinding.bind(view)
        registerObserver()
        loading()
    }

    override fun onDetach() {
        super.onDetach()
        binding = null
    }

    /*
    * Private Methods
    * */
    private fun loading() {
        binding?.countryOne?.setOnClickListener { viewModel.clickOneCountry() }
        binding?.countryTwo?.setOnClickListener { viewModel.clickTwoCountry() }
        binding?.done?.setOnClickListener { viewModel.done() }
    }

    private fun setCountryOne(data: DataCountry) {
        binding?.countryOneFlag?.setBackgroundResource(data.flag)
        binding?.countryOneText?.text = data.country
    }

    private fun setCauntryTwo(data: DataCountry) {
        binding?.countryTwoFlag?.setBackgroundResource(data.flag)
        binding?.countryTwoText?.text = data.country

    }

    private fun registerObserver() {
        val owner: LifecycleOwner = this
        viewModel.loadCountryOneLiveData.observe(owner, _setCountryOneObserver)

        viewModel.loadCountryTwoLiveData.observe(owner, _setCountryTwoObserver)

        viewModel.openNextLiveData.observe(owner, _openNextObserver)

        viewModel.closeLiveData.observe(owner, _closeObserver)

        viewModel.openCountryDialogOneLiveData.observe(owner, _openCountryDialogOneObserver)

        viewModel.openCountryDialogTwoLiveData.observe(owner, _openCountryDialogTwoObserver)
    }
}