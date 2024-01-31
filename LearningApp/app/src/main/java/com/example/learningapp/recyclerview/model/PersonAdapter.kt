package com.example.learningapp.recyclerview.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learningapp.R
import com.example.learningapp.databinding.ItemPersonBinding

class PersonAdapter(var context: Context, var personObjects: List<PersonObject>, var interfaces:PersonInterface) :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {
    class ViewHolder(var binding:ItemPersonBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPersonBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personObject = personObjects.get(position)
        if (personObject.isMan){
            holder.binding.imgAvatar.setImageResource(R.drawable.ic_baseline_person_24)
        }else{
            holder.binding.imgAvatar.setImageResource(R.drawable.ic_baseline_person_women)
        }
        holder.binding.txtName.setText(personObject.name)
        holder.binding.imgAvatar.setOnClickListener {
            interfaces.click(personObject)
        }
        holder.binding.txtName.setOnClickListener {
            interfaces.click(personObject)
        }
    }

    override fun getItemCount(): Int {
        return personObjects.size
    }
}