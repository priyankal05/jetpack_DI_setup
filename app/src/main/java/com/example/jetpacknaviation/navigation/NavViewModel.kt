package com.example.jetpacknaviation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.DialogNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpacknaviation.screen.history.HistoryScreen
import com.example.jetpacknaviation.screen.main.MainScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@HiltViewModel
class NavViewModel @Inject constructor(
    navigationService: NavigationService,
) : ViewModel() {
    val controller = navigationService.navController
}

@Composable
fun NavigationView() {
    NavHost(
        navController = hiltViewModel<NavViewModel>().controller,
        startDestination = MainRoute.Home.route
    ) {
        composable(MainRoute.Home.route) {
            MainScreen()
        }
        composable(MainRoute.History.route) {
            HistoryScreen()
        }
        composable(MainRoute.Detail.route) {
        }
    }
}


@Singleton
class NavigationService @Inject constructor(
    @ApplicationContext context: Context,
) {
    val navController = NavHostController(context).apply {
        navigatorProvider.addNavigator(ComposeNavigator())
        navigatorProvider.addNavigator(DialogNavigator())
    }
}

sealed class MainRoute(val route: String) {
    object Home : MainRoute("home")
    object Detail : MainRoute("detail")
    object History : MainRoute("history")
}
