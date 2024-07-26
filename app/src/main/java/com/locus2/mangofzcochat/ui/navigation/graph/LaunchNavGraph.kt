package com.locus2.mangofzcochat.ui.navigation.graph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.locus2.mangofzcochat.ui.navigation.Screen
import com.locus2.mangofzcochat.ui.screen.auth.loader.navigateToLoaderScreen

@Composable
fun LaunchNavGraph(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.LoaderScreen.route,
    ) {
        navigateToLoaderScreen(navHostController)
    }
}
