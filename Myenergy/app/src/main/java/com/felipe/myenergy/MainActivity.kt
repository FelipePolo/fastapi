package com.felipe.myenergy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.felipe.myenergy.data.Repository
import com.felipe.myenergy.domain.GetBestRouteUseCase
import com.felipe.myenergy.ui.Routes
import com.felipe.myenergy.ui.screens.house.HouseEnergy
import com.felipe.myenergy.ui.screens.login.LoginScreen
import com.felipe.myenergy.ui.screens.login.BestRouteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navigationController = rememberNavController()
            NavHost(
                navController = navigationController,
                startDestination = Routes.Login.route,
                builder = {
                    composable(Routes.Login.route) { LoginScreen(bestRouteViewModel = BestRouteViewModel(
                        GetBestRouteUseCase(Repository())
                    )) }
                    composable(Routes.HouseEnergy.route) { HouseEnergy() }
                })
        }
    }
}