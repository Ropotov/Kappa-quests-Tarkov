package com.nvropotov.kappaqueststarkov.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quests")
data class QuestEntity (
    @PrimaryKey
    val title: String,
    @ColumnInfo
    val url: String,
    @ColumnInfo
    val isCompleted: Boolean,
)