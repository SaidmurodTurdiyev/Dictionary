package com.example.mynewwords.ui.menu

import android.content.Context
import android.os.Build
import android.view.Gravity
import android.view.View
import android.widget.PopupMenu
import com.example.mynewwords.R

class MenuItemDictionary(
    var context: Context,
    view: View,
    listenerOpenDictionary: (() -> Unit)?,
    listenerSelect: (() -> Unit)?,
    listenerUpdate: (() -> Unit)?,
    listenerDelete: (() -> Unit)?
) {
    private val popupMenu: PopupMenu = PopupMenu(context, view)

    init {
        popupMenu.menuInflater.inflate(R.menu.menu_item_dictionary, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.openItem -> {
                    listenerOpenDictionary?.invoke()
                }
                R.id.menuItemcheck -> {
                    listenerSelect?.invoke()
                }
                R.id.menuItemUpdate -> {
                    listenerUpdate?.invoke()
                }
                R.id.menuItemDalate -> {
                    listenerDelete?.invoke()
                }
            }
            true
        }
    }

    fun show() {
        if (Build.VERSION.SDK_INT >= 23)
            popupMenu.gravity = Gravity.END
        popupMenu.show()
    }
}