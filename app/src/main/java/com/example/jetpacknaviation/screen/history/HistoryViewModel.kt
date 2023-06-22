package com.example.jetpacknaviation.screen.history

import androidx.lifecycle.ViewModel
import com.example.jetpacknaviation.navigation.MainRoute
import com.example.jetpacknaviation.navigation.NavigationService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HistoryViewModel  @Inject constructor(
    private val navigationService: NavigationService
): ViewModel() {

    fun navigateToNextScreen() {
        navigationService.navController.navigate(MainRoute.Home.route)
    }

    fun back() {
        navigationService.navController.popBackStack(MainRoute.Home.route, false)
    }

}