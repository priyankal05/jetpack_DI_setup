package com.example.jetpacknaviation.screen.main

import androidx.lifecycle.ViewModel
import com.example.jetpacknaviation.navigation.MainRoute
import com.example.jetpacknaviation.navigation.NavigationService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val navigationService: NavigationService
) : ViewModel() {

    fun navigateToNextScreen() {
        navigationService.navController.navigate(MainRoute.History.route)
//        navigationService.navController.popBackStack(MainRoute.History.route, true)
    }
}