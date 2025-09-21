package com.nvropotov.kappaqueststarkov.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.zIndex
import com.nvropotov.kappaqueststarkov.R
import com.nvropotov.kappaqueststarkov.presentation.theme.KappaQuestsTarkovTheme
import com.nvropotov.kappaqueststarkov.presentation.theme.primary
import com.nvropotov.kappaqueststarkov.presentation.theme.secondary

@Composable
fun CustomSearchBar(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    onClearSearch: () -> Unit,
    onSearchToggle: () -> Unit,
    content: @Composable () -> Unit,
) {
    val dimens = KappaQuestsTarkovTheme.dimens
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .zIndex(1f)
            .padding(top = dimens.dp60)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(primary.copy(alpha = 0.9f))
                .height(dimens.dp44)
                .padding(horizontal = dimens.dp24, vertical = dimens.dp4)
        ) {
            BasicTextField(
                value = searchText,
                singleLine = true,
                textStyle = TextStyle.Default.copy(color = Color.White),
                cursorBrush = SolidColor(Color.White),
                onValueChange = { text -> onSearchTextChange(text) },
                decorationBox = { innerTextField ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(dimens.dp36)
                            .clip(RoundedCornerShape(dimens.dp20))
                            .background(secondary)
                            .padding(start = dimens.dp16, end = dimens.dp8)
                    ) {
                        Icon(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                            tint = Color.White,
                            contentDescription = null,
                        )
                        Spacer(modifier = Modifier.width(dimens.dp4))
                        Box(
                            modifier = Modifier.weight(1f)
                        ) {
                            if (searchText.isEmpty()) {
                                Text(
                                    text = stringResource(R.string.search),
                                    color = Color.White.copy(alpha = 0.5f),
                                    textAlign = TextAlign.Center
                                )
                            }
                            innerTextField()
                        }
                        if (searchText.isNotEmpty()) {
                            Icon(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .clickableNoRipple(onClearSearch),
                                imageVector = Icons.Default.Clear,
                                tint = Color.White,
                                contentDescription = null,
                            )
                        }
                    }

                },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(dimens.dp8))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(dimens.dp36)
                    .clip(RoundedCornerShape(dimens.dp18))
                    .background(secondary)
            ) {
                Text(
                    text = stringResource(R.string.cancel),
                    color = Color.White,
                    modifier = Modifier
                        .padding(horizontal = dimens.dp8)
                        .clickableNoRipple { onSearchToggle() }
                )
            }
        }
        content()
    }
}