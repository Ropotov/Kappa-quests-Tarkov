package com.nvropotov.kappaqueststarkov.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Initial)
    val screenState get() = _screenState.asStateFlow()
}