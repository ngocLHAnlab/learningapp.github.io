package com.example.learningapp.recyclerview.model

import android.os.Parcel
import android.os.Parcelable

data class PersonObject(var isMan:Boolean, var name:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (isMan) 1 else 0)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PersonObject> {
        override fun createFromParcel(parcel: Parcel): PersonObject {
            return PersonObject(parcel)
        }

        override fun newArray(size: Int): Array<PersonObject?> {
            return arrayOfNulls(size)
        }
    }
}