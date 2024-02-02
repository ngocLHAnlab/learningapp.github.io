package com.example.learningapp.roomDatabase.repository

import com.example.learningapp.roomDatabase.database.NoteDatabase
import com.example.learningapp.roomDatabase.model.Note

class NoteRepository(private var db:NoteDatabase) {
    suspend fun insertNote(note: Note) = db.getNoteDao().insertNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)
    fun getAllNotes() = db.getNoteDao().getAllNotes()
    fun searchNote(query:String?) = db.getNoteDao().searchNote(query)

}