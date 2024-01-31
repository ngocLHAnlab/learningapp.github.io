package com.example.learningapp.home.model

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.learningapp.databinding.ItemButtonBinding
import com.example.learningapp.Common.Common

class ButtonTypeAdapter (var context: Context, var buttonTypeObjects:List<ButtonTypeObject>, var buttonTypeInterface:ButtonTypeInterface):
    RecyclerView.Adapter<ButtonTypeAdapter.ViewHolder>() {
    inner class ViewHolder (var view: ItemButtonBinding):RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemButtonBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return buttonTypeObjects.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = buttonTypeObjects.get(position)
        val button = holder.view.button
        button.setText(product.text)
        button.setOnClickListener {
            buttonTypeInterface.click(product.type)
        }
    }

}