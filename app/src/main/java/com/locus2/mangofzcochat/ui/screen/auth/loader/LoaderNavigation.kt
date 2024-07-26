package com.locus2.mangofzcochat.ui.screen.auth.loader

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.locus2.mangofzcochat.ui.navigation.Screen

fun NavGraphBuilder.navigateToLoaderScreen(
    navHostController: NavHostController,
) {
    composable(Screen.LoaderScreen.route) {
        LoaderScreen(
            navigateToAuthorization = {
//                navHostController.navigateToAuthorization {
//                    popUpTo(navHostController.graph.id) {
//                        inclusive = true
//                    }
//                }
            },
            navigateToRegistration = {
//                navHostController.navigateToRegistration {
//                    popUpTo(navHostController.graph.id) {
//                        inclusive = true
//                    }
//                }
            },
        )
    }
}
