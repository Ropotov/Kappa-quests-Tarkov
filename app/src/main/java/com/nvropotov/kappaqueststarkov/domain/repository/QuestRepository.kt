package com.nvropotov.kappaqueststarkov.domain.repository

import com.nvropotov.kappaqueststarkov.domain.models.Quest
import kotlinx.coroutines.flow.Flow

interface QuestRepository {
    suspend fun getQuestInApi()
    fun getQuestInDatabase(): Flow<List<Quest>>
    suspend fun updateQuest(quest: Quest)
}