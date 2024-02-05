package com.example.learningapp.roomDatabase.repository

import com.example.learningapp.roomDatabase.database.NoteDatabase
import com.example.learningapp.roomDatabase.model.Note

class NoteRepository(private var db:NoteDatabase) {
    fun insertNote(note: Note) = db.getNoteDao().insertNote(note)
    fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)
    fun updateNote(note: Note) = db.getNoteDao().updateNote(note)
    fun getAllNotes() = db.getNoteDao().getAllNotes()
    fun searchNote(query:String?) = db.getNoteDao().searchNote(query)

}