package com.nvropotov.kappaqueststarkov.data

import com.nvropotov.kappaqueststarkov.data.database.QuestDao
import com.nvropotov.kappaqueststarkov.data.database.QuestEntity
import com.nvropotov.kappaqueststarkov.data.network.QuestApi
import com.nvropotov.kappaqueststarkov.domain.models.Quest
import com.nvropotov.kappaqueststarkov.domain.repository.QuestRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuestRepositoryImpl(
    private val questApi: QuestApi,
    private val questDao: QuestDao,
) : QuestRepository {

    override suspend fun getQuestInApi() {
        runCatching {
            questApi.getQuests()
        }.onSuccess {
            val questsEntity = it.map { quest -> quest.toQuestEntity() }
            questDao.insertAll(*questsEntity.toTypedArray())
        }.onFailure {
            throw IllegalStateException(it)
        }
    }

    override fun getQuestInDatabase(): Flow<List<Quest>> {
        return questDao.getAllQuests().map { it.toListQuest() }
    }

    override suspend fun updateQuest(quest: Quest) {
        questDao.insertQuest(quest.toQuestEntity().copy(isCompleted = !quest.isCompleted))
    }
}

private fun List<QuestEntity>.toListQuest(): List<Quest> =
    map { Quest(it.title, it.url, it.isCompleted) }

private fun Quest.toQuestEntity(): QuestEntity =
    QuestEntity(this.title, this.url, this.isCompleted)