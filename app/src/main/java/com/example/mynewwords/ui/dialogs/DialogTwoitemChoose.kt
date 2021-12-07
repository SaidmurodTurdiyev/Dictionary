package com.example.mynewwords.ui.dialogs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import androidx.lifecycle.MutableLiveData
import com.example.mynewwords.R
import com.example.mynewwords.data.model.Event
import com.example.mynewwords.data.source.local.room.entity.DictionaryEntity
import com.example.mynewwords.databinding.DialogChooceBinding

class DialogTwoitemChoose(
    context: Context,
    textActionBar: String
) {
    private var view =
        LayoutInflater.from(context).inflate(R.layout.dialog_chooce, null, false)
    private var binding = DialogChooceBinding.bind(view)
    private var _listenerFirstChoose: (() -> Unit)? = null
    private var _listenerSecondChoose: (() -> Unit)? = null
    private var dialog = AlertDialog.Builder(context).setView(view).create()

    fun submitFirstChoose(f: () -> Unit, textButton: String? = null) {
        _listenerFirstChoose = f
        if (textButton != null) {
            binding.firstButtonText.text = textButton
        }
    }

    fun submitSecondChoose(f: () -> Unit, textButton: String? = null) {
        _listenerSecondChoose = f
        if (textButton != null) {
            binding.secondButtonText.text = textButton
        }
    }

    init {
        binding.actionBarText.text = textActionBar
        binding.actionBarBack.setOnClickListener {
            dialog.dismiss()
        }
        binding.firstButtonDialog.setOnClickListener {
            _listenerFirstChoose?.invoke()
        }
        binding.secondButtonDialog.setOnClickListener {
            _listenerSecondChoose?.invoke()
        }
    }

    fun show(textMessage: String) {
        binding.text.text = textMessage
        dialog.show()
    }
}