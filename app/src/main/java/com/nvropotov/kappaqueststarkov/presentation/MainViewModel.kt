package com.nvropotov.kappaqueststarkov.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvropotov.kappaqueststarkov.domain.models.Quest
import com.nvropotov.kappaqueststarkov.domain.repository.QuestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val questRepository: QuestRepository,
) : ViewModel() {
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Initial)
    val screenState get() = _screenState.asStateFlow()

    init {
        loadQuest()
    }

    private fun loadQuest() {
        viewModelScope.launch {
            questRepository.getQuestInApi()
        }
        questRepository.getQuestInDatabase()
            .map { ScreenState.SuccessLoaded(it.toPersistentList()) }
            .onEach { _screenState.tryEmit(it) }
            .launchIn(viewModelScope)
    }

    fun selected(quest: Quest) {
        viewModelScope.launch {
            questRepository.updateQuest(quest)
        }
    }
}