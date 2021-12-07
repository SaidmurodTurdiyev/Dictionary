package com.example.mynewwords.data.source.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mynewwords.data.model.DataSelected

@Entity(tableName = "WordDataBase",ignoredColumns = arrayOf("isSelect"))
data class WordEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var wordOne: String,
    var wordTwo: String,
    var exaple:String,
    var dictionaryId: Long,
    var learnedCount: Int
) : DataSelected()