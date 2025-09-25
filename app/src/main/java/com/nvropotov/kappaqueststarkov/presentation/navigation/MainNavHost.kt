package com.nvropotov.kappaqueststarkov.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.nvropotov.kappaqueststarkov.presentation.MainViewModel
import com.nvropotov.kappaqueststarkov.presentation.QuestsScreen
import com.nvropotov.kappaqueststarkov.presentation.components.WebView

@Composable
fun MainNavHost(viewModel: MainViewModel = viewModel()) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.Home) {
        composable<Route.Home> {
            QuestsScreen(viewModel, navController)
        }
        composable<Route.WebView> { backStackEntry ->
            val route = backStackEntry.savedStateHandle.toRoute<Route.WebView>()
            WebView(route.link, navController)
        }
    }
}