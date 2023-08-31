package com.example.techookku.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("main_activity")
    object LoginScreen : Screen("login_screen")
    object ServiceListingScreen : Screen("service_listing_screen")
    object ServiceDetailScreen : Screen("service_detail_screen")
}
