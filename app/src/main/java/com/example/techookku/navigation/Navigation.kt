package com.example.techookku.navigation

import ServiceDetailScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.techookku.R
import com.example.techookku.datamodel.GridItemModel
import com.example.techookku.datamodel.ServiceDetailModel
import com.example.techookku.view.LoginScreen
import com.example.techookku.view.ServiceListingScreen
import com.example.techookku.view.SplashScreen
import com.example.techookku.view.getByServiceId

@Composable
@Preview
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.ServiceListingScreen.route) {
            ServiceListingScreen(navController = navController)
        }
        composable("service_detail/{serviceId}") { entry ->
            val serviceId = entry.arguments?.getString("serviceId")
            val service: ServiceDetailModel = getByServiceId(serviceId.toString())
            println(service)
            ServiceDetailScreen(navController = navController, service)
        }

    }
}