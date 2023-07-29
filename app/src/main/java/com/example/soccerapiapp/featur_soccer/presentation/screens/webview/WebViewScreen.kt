package com.example.soccerapiapp.featur_soccer.presentation.screens.webview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Composable
fun WebViewScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        val webViewState = rememberWebViewState(url = "https://allsportsapi.com/")
        WebView(
            state = webViewState,
            onCreated = { webView ->
                webView.settings.javaScriptEnabled = true
            },
        )
    }
}
