package com.example.techookku.navigation

sealed class Screen(val route: String) {
    object WelcomeScreen : Screen("main_activity")
    object LoginScreen : Screen("login_screen")
    object ServiceListing : Screen("service_listing")
}