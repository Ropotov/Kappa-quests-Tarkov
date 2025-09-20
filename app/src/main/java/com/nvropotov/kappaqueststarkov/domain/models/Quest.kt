package com.nvropotov.kappaqueststarkov.domain.models

data class Quest(
    val title: String,
    val url: String,
    val isCompleted: Boolean = false,
)
