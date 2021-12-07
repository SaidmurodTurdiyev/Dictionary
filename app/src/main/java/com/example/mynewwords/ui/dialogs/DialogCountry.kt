package com.example.mynewwords.ui.dialogs

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynewwords.R
import com.example.mynewwords.databinding.FragmentRecyclerviewBinding
import com.example.mynewwords.ui.adapter.AdapterCountry
import com.example.mynewwords.utils.MyCountries

class DialogCountry(
    private var context: Context,
    private val countryId: Int,
    private var isNotCountry: Int? = null
) {
    @SuppressLint("InflateParams")
    private var view =
        LayoutInflater.from(context).inflate(R.layout.fragment_recyclerview, null, false)
    private var dialog: AlertDialog =
        AlertDialog.Builder(context).setView(view).create()

    private var mylist: MyCountries = MyCountries()


    private var listenerChoose: ((Int) -> Unit)? = null
    private var binding = FragmentRecyclerviewBinding.bind(view)

    private var adapter: AdapterCountry

    init {
        binding.apply {
            adapter = AdapterCountry(context, mylist.getCountries(),isNotCountry)
            actionBarBackImage.setBackgroundResource(mylist.getCountries()[countryId].flag)
            adapter.submitlistener {
                listenerChoose?.invoke(it)
                dialog.dismiss()
            }
            list.layoutManager = LinearLayoutManager(context)
            list.adapter = adapter
            actionBarBack.setOnClickListener {
                dialog.dismiss()
            }
            toolbar.title = "Cauntries"
        }
    }

    fun submitListener(block: ((Int) -> Unit)) {
        listenerChoose = block
    }

    fun show() {
        dialog.show()
    }


}