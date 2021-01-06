package com.example.shoppinglistappkotlin.ui.shoppinglist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistappkotlin.data.db.enitites.ShoppingItem
import com.example.shoppinglistappkotlin.databinding.ShoppingItemBinding

class ShoppingItemAdapter(var items: List<ShoppingItem>, private val viewModel: ShoppingViewModel) : RecyclerView.Adapter<ShoppingItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder { //TODO: MOZE BIT GRESKA
        val binding = ShoppingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val shoppingItem = items[position]
        holder.binding.tvName.text = shoppingItem.name
        holder.binding.tvAmount.text = shoppingItem.amount.toString()

        holder.binding.ivDelete.setOnClickListener{
            viewModel.delete(shoppingItem)
        }

        holder.binding.ivPlus.setOnClickListener{
            shoppingItem.amount ++
            viewModel.upsert(shoppingItem)
        }

        holder.binding.ivMinus.setOnClickListener {
            if (shoppingItem.amount == 1) {
                viewModel.delete(shoppingItem)
            }else{
                shoppingItem.amount --
                viewModel.upsert(shoppingItem)
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ItemViewHolder (var binding: ShoppingItemBinding) : RecyclerView.ViewHolder(binding.root){

    }
}