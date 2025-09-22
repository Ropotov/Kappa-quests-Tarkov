package com.nvropotov.kappaqueststarkov.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nvropotov.kappaqueststarkov.presentation.components.QuestsContent

@Composable
fun QuestsScreen(viewModel: MainViewModel = viewModel()) {
    val screenState by viewModel.screenState.collectAsStateWithLifecycle()
    when (val localState = screenState) {
        //TODO
        ScreenState.ErrorLoaded -> {}
        ScreenState.Initial -> {}
        ScreenState.Loading -> {}
        is ScreenState.SuccessLoaded -> QuestsContent(
            viewModel,
            localState.quests
        )
    }
}