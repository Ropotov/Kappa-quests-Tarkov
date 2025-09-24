package com.nvropotov.kappaqueststarkov.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import com.nvropotov.kappaqueststarkov.R
import com.nvropotov.kappaqueststarkov.domain.models.Filter
import com.nvropotov.kappaqueststarkov.presentation.theme.KappaQuestsTarkovTheme
import com.nvropotov.kappaqueststarkov.presentation.theme.primary
import com.nvropotov.kappaqueststarkov.presentation.theme.secondary
import com.nvropotov.kappaqueststarkov.presentation.theme.text

@Composable
fun ToolBar(
    selected: Filter,
    onSelect: (Filter) -> Unit,
    onSearchClick: () -> Unit,
) {
    val dimens = KappaQuestsTarkovTheme.dimens
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(primary)
            .systemBarsPadding()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.dp60)
        ) {
            Text(
                text = "TarkovKappaQuests",
                fontSize = dimens.sp24,
                color = text,
                textAlign = TextAlign.Center,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimens.dp24)
        ) {
            Row(
                modifier = Modifier
                    .height(dimens.dp36)
                    .clip(RoundedCornerShape(dimens.dp18))
                    .background(secondary),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                    tint = Color.White,
                    contentDescription = null,
                    modifier = Modifier.padding(start = dimens.dp16, end = dimens.dp8)
                )
                Text(
                    text = stringResource(R.string.search),
                    color = Color.White,
                    modifier = Modifier
                        .padding(end = dimens.dp16)
                        .clickableNoRipple { onSearchClick() }
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            FilterButtons(selected = selected, onSelect = onSelect)
        }
    }
}