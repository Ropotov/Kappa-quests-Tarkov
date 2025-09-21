package com.nvropotov.kappaqueststarkov.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nvropotov.kappaqueststarkov.R
import com.nvropotov.kappaqueststarkov.domain.models.Filter
import com.nvropotov.kappaqueststarkov.presentation.theme.KappaQuestsTarkovTheme

@Composable
fun FilterButtons(
    selected: Filter,
    onSelect: (Filter) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(KappaQuestsTarkovTheme.dimens.dp4),
        modifier = Modifier.selectableGroup()
    ) {
        ToggleCircleButton(
            selected = selected == Filter.NOT_COMPLETED,
            onClick = {
                onSelect(
                    if (selected == Filter.NOT_COMPLETED) {
                        Filter.NOT_FILTER
                    } else {
                        Filter.NOT_COMPLETED
                    }
                )
            },
            iconRes = R.drawable.ic_not_completed
        )
        ToggleCircleButton(
            selected = selected == Filter.COMPLETED,
            onClick = {
                onSelect(
                    if (selected == Filter.COMPLETED) {
                        Filter.NOT_FILTER
                    } else {
                        Filter.COMPLETED
                    }
                )
            },
            iconRes = R.drawable.ic_completed
        )
        ToggleCircleButton(
            selected = selected == Filter.NOT_FILTER,
            onClick = { onSelect(Filter.NOT_FILTER) },
            iconRes = R.drawable.ic_filter
        )
    }
}