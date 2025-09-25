package com.nvropotov.kappaqueststarkov.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.nvropotov.kappaqueststarkov.R
import com.nvropotov.kappaqueststarkov.presentation.theme.KappaQuestsTarkovTheme
import com.nvropotov.kappaqueststarkov.presentation.theme.accent
import com.nvropotov.kappaqueststarkov.presentation.theme.primary
import com.nvropotov.kappaqueststarkov.presentation.theme.text

@Composable
fun ErrorScreen(refresh: () -> Unit) {
    val dimens = KappaQuestsTarkovTheme.dimens
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(primary)
    ) {
        Text(
            text = stringResource(R.string.error_title),
            fontSize = dimens.sp96,
            color = accent,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = stringResource(R.string.error_description),
            fontSize = dimens.sp20,
            color = text,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(dimens.dp24))
        Button(
            onClick = refresh,
            colors = ButtonDefaults.buttonColors().copy(containerColor = accent),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimens.dp24)
        ) {
            Text(
                text = stringResource(R.string.refresh),
                fontSize = dimens.sp24,
                color = text,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    KappaQuestsTarkovTheme {
        ErrorScreen {}
    }
}