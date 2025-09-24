package com.nvropotov.kappaqueststarkov.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.request.ImageRequest
import com.nvropotov.kappaqueststarkov.R
import com.nvropotov.kappaqueststarkov.presentation.theme.primary

@Composable
fun LoaderScreen() {
    val context = LocalContext.current
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(primary),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(R.drawable.loader)
                .decoderFactory(GifDecoder.Factory())
                .build(),
            contentDescription = null
        )
    }
}