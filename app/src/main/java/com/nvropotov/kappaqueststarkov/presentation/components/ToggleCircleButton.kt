package com.nvropotov.kappaqueststarkov.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.nvropotov.kappaqueststarkov.presentation.theme.KappaQuestsTarkovTheme
import com.nvropotov.kappaqueststarkov.presentation.theme.accent
import com.nvropotov.kappaqueststarkov.presentation.theme.secondary

@Composable
fun ToggleCircleButton(
    selected: Boolean,
    onClick: () -> Unit,
    @DrawableRes iconRes: Int,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(KappaQuestsTarkovTheme.dimens.dp36)
            .clip(CircleShape)
            .circleSelectionBorder(selected, accent)
            .background(secondary)
            .clickableNoRipple { onClick() }
    ) {
        Image(
            painter = painterResource(iconRes),
            contentDescription = null,
            modifier = Modifier.size(KappaQuestsTarkovTheme.dimens.dp16)
        )
    }
}