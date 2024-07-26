package com.locus2.mangofzcochat.ui.navigation

sealed class Screen(val route: String) {

    data object LoaderScreen : Screen(route = LOADER_SCREEN)
    data object AuthorizationScreen : Screen(route = AUTHORIZATION_SCREEN)
    data object RegistrationScreen : Screen(route = REGISTRATION_SCREEN)
    data object ChatListScreen : Screen(route = CHAT_LIST_SCREEN)
    data object ChatScreen : Screen(route = CHAT_SCREEN)
    data object ProfileScreen : Screen(route = PROFILE_SCREEN)


    private companion object {

        const val LOADER_SCREEN = "loader_screen"
        const val AUTHORIZATION_SCREEN = "authorization_screen"
        const val REGISTRATION_SCREEN = "registration_screen"
        const val CHAT_LIST_SCREEN = "chat_list_screen"
        const val CHAT_SCREEN = "chat_screen"
        const val PROFILE_SCREEN = "profile_screen"
    }
}
