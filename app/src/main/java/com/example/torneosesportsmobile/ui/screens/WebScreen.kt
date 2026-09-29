package com.example.torneosesportsmobile.ui.screens

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebScreen(modifier: Modifier = Modifier) {
    var urlInput by remember { mutableStateOf("https://lolesports.com/") }
    var currentUrl by remember { mutableStateOf("https://lolesports.com/") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = urlInput,
                onValueChange = { urlInput = it },
                label = { Text("URL del Portal") },
                modifier = Modifier.weight(1f),
                singleLine = true
            )
            
            Spacer(modifier = Modifier.width(8.dp))
            
            Button(onClick = {
                // Validación básica de URL
                val urlToLoad = if (!urlInput.startsWith("http://") && !urlInput.startsWith("https://")) {
                    "https://$urlInput"
                } else {
                    urlInput
                }
                currentUrl = urlToLoad
            }) {
                Text("Ir")
            }
        }

        AndroidView(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            factory = { context ->
                WebView(context).apply {
                    webViewClient = WebViewClient()
                    settings.javaScriptEnabled = true
                    loadUrl(currentUrl)
                }
            },
            update = { webView ->
                webView.loadUrl(currentUrl)
            }
        )
    }
}
