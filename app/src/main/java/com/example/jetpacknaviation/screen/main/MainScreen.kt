package com.example.jetpacknaviation.screen.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun MainScreen(){

    val mainViewModel =  hiltViewModel<MainViewModel>()

    Box(modifier = Modifier.fillMaxSize()){

        Button(modifier = Modifier.size(120.dp), onClick = {
            mainViewModel.navigateToNextScreen()
        }) {
            Text(text = "Go to History Screen")
        }
    }

}