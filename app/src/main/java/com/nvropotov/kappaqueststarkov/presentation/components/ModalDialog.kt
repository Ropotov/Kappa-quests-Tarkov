package com.nvropotov.kappaqueststarkov.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.DialogProperties
import com.nvropotov.kappaqueststarkov.presentation.theme.KappaQuestsTarkovTheme
import com.nvropotov.kappaqueststarkov.presentation.theme.accent
import com.nvropotov.kappaqueststarkov.presentation.theme.secondary
import com.nvropotov.kappaqueststarkov.presentation.theme.text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalDialog(
    @StringRes title: Int,
    @StringRes description: Int,
    onDismiss: () -> Unit,
) {
    val dimens = KappaQuestsTarkovTheme.dimens
    BasicAlertDialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = dimens.dp140)
                .clickableNoRipple(onDismiss)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(dimens.dp8),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = dimens.dp27)
                    .dropShadow(
                        shape = RoundedCornerShape(dimens.dp16),
                    ) {
                        color = accent
                        radius = 40f
                        spread = 2f
                    }
                    .background(secondary, RoundedCornerShape(dimens.dp16))

            ) {
                Text(
                    text = stringResource(title),
                    fontSize = dimens.sp24,
                    color = text,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(
                        start = dimens.dp16,
                        end = dimens.dp16,
                        top = dimens.dp16
                    )
                )
                Text(
                    text = stringResource(description),
                    fontSize = dimens.sp16,
                    color = text,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(
                        start = dimens.dp16,
                        end = dimens.dp16,
                        bottom = dimens.dp16
                    )
                )
            }
        }
    }
}