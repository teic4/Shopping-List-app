package com.example.shoppinglistappkotlin.ui.shoppinglist

import com.example.shoppinglistappkotlin.data.db.enitites.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClick(item: ShoppingItem)
}