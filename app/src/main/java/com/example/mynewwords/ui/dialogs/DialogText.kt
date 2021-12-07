package com.example.mynewwords.ui.dialogs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.example.mynewwords.R
import com.example.mynewwords.data.source.local.room.entity.DictionaryEntity
import com.example.mynewwords.databinding.DialogTextBinding

class DialogText(context: Context, name: String) {
    private var view =
        LayoutInflater.from(context).inflate(R.layout.dialog_text, null, false)
    private var listener: (() -> Unit)? = null
    private val dialog: AlertDialog =
        AlertDialog.Builder(context).setView(view).create()
    private val binding = DialogTextBinding.bind(view)

    fun submit(f: (() -> Unit)) {
        listener = f
    }

    init {
        binding.addButtonDictionaryDialog.setOnClickListener {
            listener?.invoke()
            dialog.dismiss()
        }
        binding.actionBarBack.setOnClickListener { dialog.dismiss() }
        binding.actionBarText.text=name
    }

    fun show(text: String) {
        binding.text.text = text
        dialog.show()
    }
}