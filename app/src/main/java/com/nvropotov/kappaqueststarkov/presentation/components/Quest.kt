package com.nvropotov.kappaqueststarkov.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import com.nvropotov.kappaqueststarkov.R
import com.nvropotov.kappaqueststarkov.domain.models.Quest
import com.nvropotov.kappaqueststarkov.presentation.theme.KappaQuestsTarkovTheme
import com.nvropotov.kappaqueststarkov.presentation.theme.accent
import com.nvropotov.kappaqueststarkov.presentation.theme.secondary
import com.nvropotov.kappaqueststarkov.presentation.theme.text

@Composable
private fun Quest(
    quest: Quest,
    openLink: (String) -> Unit,
    select: (Quest) -> Unit,
) {
    val dimens = KappaQuestsTarkovTheme.dimens
    Box(
        modifier = Modifier
            .padding(horizontal = dimens.dp24, vertical = dimens.dp4)
            .clip(RoundedCornerShape(dimens.dp20))
            .circleSelectionBorder(quest.isCompleted, accent)
            .fillMaxWidth()
            .wrapContentHeight()
            .background(secondary)
            .clickableNoRipple { openLink(quest.url) }
    ) {
        Row(
            modifier = Modifier.padding(horizontal = dimens.dp16, vertical = dimens.dp8)
        ) {
            val image = if (quest.isCompleted) {
                R.drawable.ic_completed
            } else {
                R.drawable.ic_not_completed
            }

            Text(
                text = quest.title,
                color = text,
                modifier = Modifier.weight(1f),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )

            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .size(dimens.dp24)
                    .clickableNoRipple { select(quest) })
        }
    }
}