package com.example.techookku.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.techookku.view.*

@Composable
@Preview
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route
    ) {
        composable(Screen.WelcomeScreen.route) {
            WelcomeScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.ServiceListing.route) {
            ServiceListing()
        }

    }
}

@Composable
@Preview(showBackground = true)
fun NavPreview() {
    ServiceListing()
}