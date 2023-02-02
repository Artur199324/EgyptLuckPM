package com.pikpok.hrc.data

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "user_table", indices = [Index(value = ["firstName"], unique = true)])
@Parcelize
@Keep
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "firstName")
    val firstName: String,
    @ColumnInfo(name = "games")
    var games: Int,
    @ColumnInfo(name = "points")
    var points: Int,
    @ColumnInfo(name = "skinChoose")
    var skinChoose: Int,
    @ColumnInfo(name = "firstBuy")
    var firstBuy: Boolean,
    @ColumnInfo(name = "secondBuy")
    var secondBuy: Boolean,
    @ColumnInfo(name = "thirdBuy")
    var thirdBuy: Boolean,
    @ColumnInfo(name = "fourthBuy")
    var fourthBuy: Boolean,
    @ColumnInfo(name = "fifthBuy")
    var fifthBuy: Boolean,
    @ColumnInfo(name = "sixthBuy")
    var sixthBuy: Boolean,
) : Parcelable