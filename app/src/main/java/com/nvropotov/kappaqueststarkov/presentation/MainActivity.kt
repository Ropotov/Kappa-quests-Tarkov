package com.nvropotov.kappaqueststarkov.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.nvropotov.kappaqueststarkov.presentation.components.WebView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainNavHost()
        }
    }
}

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
sealed interface Route {
    @Serializable
    data object Home : Route
    @Serializable
    data class WebView(val link: String): Route
}