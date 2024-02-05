package com.example.learningapp.roomDatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.example.learningapp.roomDatabase.model.Note
import com.example.learningapp.roomDatabase.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app:Application, private val noteRepository: NoteRepository):AndroidViewModel(app) {
    fun insertNote(note:Note) = /*viewModelScope.launch { */noteRepository.insertNote(note) /*}*/
    fun updateNote(note:Note) = /*viewModelScope.launch {*/ noteRepository.updateNote(note) /*}*/
    fun deleteNote(note:Note) = /*viewModelScope.launch {*/ noteRepository.deleteNote(note)/* }*/
    fun getAllNotes() = noteRepository.getAllNotes()
    fun searchNote(query: String?) = noteRepository.searchNote(query)


}