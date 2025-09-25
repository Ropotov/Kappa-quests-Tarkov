package com.nvropotov.kappaqueststarkov.presentation.components

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.nvropotov.kappaqueststarkov.presentation.theme.KappaQuestsTarkovTheme

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebView(url: String, navController: NavController) {
    KappaQuestsTarkovTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
                .statusBarsPadding()
        ) {
            var webView: WebView? by remember { mutableStateOf(null) }

            AndroidView(factory = { context ->
                WebView(context).apply {
                    webViewClient = WebViewClient()
                    settings.javaScriptEnabled = true
                    settings.domStorageEnabled = true
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    loadUrl(url)
                    webView = this
                }
            })
            BackHandler {
                if (webView?.canGoBack() == true) {
                    webView?.goBack()
                } else {
                    navController.popBackStack()
                }
            }
        }
    }
}