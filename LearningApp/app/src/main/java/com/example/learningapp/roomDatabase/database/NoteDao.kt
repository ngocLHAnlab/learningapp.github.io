package com.example.learningapp.roomDatabase.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.learningapp.roomDatabase.model.Note

@Dao
interface NoteDao {
    @Insert()
    fun insertNote( note:Note)

    @Update
    fun updateNote( note:Note)

    @Delete
    fun deleteNote( note:Note)

    @Query("SELECT * FROM NOTES ORDER BY id DESC")
    fun getAllNotes():LiveData<List<Note>>

    @Query("SELECT * FROM NOTES WHERE noteTitle LIKE :query OR noteDesc LIKE :query")
    fun searchNote(query:String?) : LiveData<List<Note>>
}