package com.nvropotov.kappaqueststarkov.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.clickableNoRipple(onClick: () -> Unit): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}

fun Modifier.circleSelectionBorder(
    selected: Boolean,
    borderColor: Color,
    borderWidth: Dp = 2.dp,
): Modifier {
    return if (selected) {
        this.then(Modifier.border(borderWidth, borderColor, CircleShape))
    } else {
        this
    }
}