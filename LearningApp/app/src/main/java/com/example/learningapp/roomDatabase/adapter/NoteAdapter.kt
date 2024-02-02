package com.example.learningapp.roomDatabase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.learningapp.R
import com.example.learningapp.databinding.ItemPersonBinding
import com.example.learningapp.databinding.NoteLayoutBinding
import com.example.learningapp.roomDatabase.fragment.HomeFragmentDirections
import com.example.learningapp.roomDatabase.model.Note

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    class ViewHolder(var binding: NoteLayoutBinding):RecyclerView.ViewHolder(binding.root)

    private var differCallback = object : DiffUtil.ItemCallback<Note>(){
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.noteDesc == newItem.noteDesc &&
                    oldItem.noteTitle == newItem.noteTitle
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NoteLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNote = differ.currentList[position]
        holder.binding.noteTitle.text = currentNote.noteTitle
        holder.binding.noteDesc.text = currentNote.noteDesc
        holder.itemView.setOnClickListener{
            val direction = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(currentNote)
            it.findNavController().navigate(direction)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}