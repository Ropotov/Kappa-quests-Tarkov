package com.nvropotov.kappaqueststarkov.presentation

import com.nvropotov.kappaqueststarkov.domain.models.Quest
import kotlinx.collections.immutable.PersistentList

sealed interface ScreenState {
    data object Loading : ScreenState
    data object ErrorLoaded : ScreenState
    data class SuccessLoaded(val quests: PersistentList<Quest>) : ScreenState
}