package com.example.learningapp.roomDatabase.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Entity(tableName = "notes")
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @ColumnInfo(name = "noteTitle")
    var noteTitle:String,
    @ColumnInfo(name = "noteDesc")
    var noteDesc:String
):Parcelable
//    :Serializable
//    :Parcelable
