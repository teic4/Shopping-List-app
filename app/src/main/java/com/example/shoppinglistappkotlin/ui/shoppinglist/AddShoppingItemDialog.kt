package com.example.shoppinglistappkotlin.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglistappkotlin.data.db.enitites.ShoppingItem
import com.example.shoppinglistappkotlin.databinding.DialogAddShoppingItemBinding
import com.google.android.material.snackbar.Snackbar

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvAdd.setOnClickListener{
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString()

            if(name.isEmpty() || amount.isEmpty()){
                Snackbar.make(binding.parent, "Please enter all information", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClick(item)
            dismiss()
        }

        binding.tvCancel.setOnClickListener {
            cancel()
        }

    }
}