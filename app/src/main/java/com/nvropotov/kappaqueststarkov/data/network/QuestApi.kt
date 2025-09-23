package com.nvropotov.kappaqueststarkov.data.network

import com.nvropotov.kappaqueststarkov.domain.models.Quest
import retrofit2.http.GET

interface QuestApi {
    @GET("Ropotov/tarkov-quests-json/master/quests.json")
    suspend fun getQuests(): List<Quest>
}