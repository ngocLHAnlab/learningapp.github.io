package com.example.learningapp.roomDatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.learningapp.roomDatabase.model.Note

//@Database(entities = [Note::class], version = 1)
//abstract class NoteDatabase:RoomDatabase() {
//    abstract fun getNoteDao():NoteDao
//    companion object{
//        @Volatile
//        private var instance:NoteDatabase? = null
//        private var LOCK = Any()
//        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
//            instance ?: createDatabase(context).also{ instance = it }
//        }
//        private fun createDatabase(context: Context) =
//            Room.databaseBuilder(context.applicationContext, NoteDatabase::class.java, "note.db")
//                .createFromAsset("database/myapp.db")
//                .build()
//          //Room.databaseBuilder(context.applicationContext, NoteDatabase::class.java, "note_db").build()
//    }
//}
@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNoteDao():NoteDao
    companion object{
        private val DATABASE_NAME = "note.db"
        private var instance: NoteDatabase? = null
//        @Synchronized
//        fun getInstance(context: Context): NoteDatabase{
//            if (instance == null){
//                instance = Room.databaseBuilder(context.applicationContext, NoteDatabase::class.java, DATABASE_NAME).allowMainThreadQueries().build()
//            }
//            return instance as NoteDatabase
//        }
        fun getInstance(context: Context): NoteDatabase {
            if (instance == null) {
                synchronized(NoteDatabase::class.java) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(context.applicationContext,
                            NoteDatabase::class.java, "abc_db")
                            .fallbackToDestructiveMigration()
//                            .addCallback(sRoomDatabaseCallback)
                            .build()
                    }
                }
            }
            return instance!!
        }
    }
}
