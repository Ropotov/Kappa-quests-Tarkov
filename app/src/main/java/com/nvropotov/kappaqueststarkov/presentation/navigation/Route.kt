package com.nvropotov.kappaqueststarkov.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Home : Route
    @Serializable
    data class WebView(val link: String): Route
}