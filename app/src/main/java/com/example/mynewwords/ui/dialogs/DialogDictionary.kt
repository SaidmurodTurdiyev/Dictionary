package com.example.mynewwords.ui.dialogs

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.example.mynewwords.R
import com.example.mynewwords.data.source.local.room.entity.DictionaryEntity
import com.example.mynewwords.databinding.DialogDictionaryBinding

class DialogDictionary(context: Context, name: String = "Add") {
    @SuppressLint("InflateParams")
    private var view =
        LayoutInflater.from(context).inflate(R.layout.dialog_dictionary, null, false)
    private var listener: ((DictionaryEntity) -> Unit)? = null
    private val dialog: AlertDialog =
        AlertDialog.Builder(context).setView(view).create()
    private val binding = DialogDictionaryBinding.bind(view)
    private var data: DictionaryEntity = DictionaryEntity(0, "Dictioanary", "Info", 0, 0, 0, 0)

    fun submit(f: ((DictionaryEntity) -> Unit)) {
        listener = f
    }

    init {
        binding.addButtonDictionaryDialog.setOnClickListener {
            done()
        }
        binding.dictionaryInfo.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    done()
                    return true
                }
                return false
            }

        })
        binding.actionBarBack.setOnClickListener { dialog.dismiss() }
        binding.actionBarText.text = name
    }

    fun show(data: DictionaryEntity? = null) {
        if (data != null) {
            binding.dictionaryName.setText(data.name)
            binding.dictionaryInfo.setText(data.dataInfo)
            this.data.apply {
                id = data.id
                learnPracent = data.learnPracent
                languageIdOne = data.languageIdOne
                languageIdTwo = data.languageIdTwo
                isDelete = data.isDelete
            }
            binding.actionBarText.text = "Update"
        }
        dialog.show()
    }

    private fun done() {
        val text = binding.dictionaryName.text.toString()
        if (text != "") {
            data.name = text
            listener?.invoke(data)
            dialog.dismiss()
        } else
            binding.dictionaryName.error = "Please,Enter dictionary name"
    }
}