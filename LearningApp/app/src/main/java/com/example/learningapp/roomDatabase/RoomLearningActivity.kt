package com.example.learningapp.roomDatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.learningapp.R
import com.example.learningapp.roomDatabase.database.NoteDatabase
import com.example.learningapp.roomDatabase.repository.NoteRepository
import com.example.learningapp.roomDatabase.viewmodel.NoteViewModel
import com.example.learningapp.roomDatabase.viewmodel.NoteViewModelFactory

class RoomLearningActivity : AppCompatActivity() {
    lateinit var noteViewModel:NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_learning)
        setupViewModel()
    }
    private fun setupViewModel(){
        val noteRepository = NoteRepository(NoteDatabase.getInstance(this))
        val noteViewModelFactory = NoteViewModelFactory(application, noteRepository)
        noteViewModel = ViewModelProvider(this, noteViewModelFactory)[NoteViewModel::class.java]
    }
}