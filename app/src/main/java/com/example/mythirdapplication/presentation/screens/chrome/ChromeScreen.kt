package com.example.mythirdapplication.presentation.screens.chrome

import android.content.ComponentName
import android.graphics.Color
import android.net.Uri
import androidx.browser.customtabs.CustomTabsClient
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabsServiceConnection
import androidx.browser.customtabs.CustomTabsSession
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun ChromeScreen(
    navController: NavHostController,
    viewModel: ChromeViewModel = hiltViewModel()
) {
    val urlResponse by viewModel.linkResponse.collectAsState()

    val currentContext = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        var mCustomTabsServiceConnection: CustomTabsServiceConnection? = null
        var mClient: CustomTabsClient? = null
        var mCustomTabsSession: CustomTabsSession? = null
        mCustomTabsServiceConnection = object : CustomTabsServiceConnection() {
            override fun onCustomTabsServiceConnected(
                componentName: ComponentName,
                customTabsClient: CustomTabsClient
            ) {
                //Pre-warming
                mClient = customTabsClient
                mClient?.warmup(0L)
                mCustomTabsSession = mClient?.newSession(null)
            }

            override fun onServiceDisconnected(name: ComponentName) {
                navController.popBackStack()
                mClient = null
            }

        }
        CustomTabsClient.bindCustomTabsService(
            currentContext,
            "com.android.chrome",
            mCustomTabsServiceConnection
        )
        val customTabsIntent = CustomTabsIntent.Builder(mCustomTabsSession)
            .setToolbarColor(Color.WHITE)
            .setShowTitle(true)
            .build()
        if (urlResponse != null) {
            customTabsIntent.launchUrl(currentContext, Uri.parse(urlResponse))
        }
    }
}