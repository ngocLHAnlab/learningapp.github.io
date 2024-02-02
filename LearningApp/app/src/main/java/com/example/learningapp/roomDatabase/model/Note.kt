package com.example.learningapp.roomDatabase.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Entity(tableName = "notes")
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var noteTitle:String,
    var noteDesc:String
):Parcelable
//    :Serializable
//    :Parcelable
