package com.example.jetpacknaviation.screen.main

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpacknaviation.screen.history.customDayFromDate


@Composable
fun MainScreen() {

    val mainViewModel = hiltViewModel<MainViewModel>()

    Column(modifier = Modifier.fillMaxSize()) {

         Button(modifier = Modifier.fillMaxWidth()
             .padding(horizontal = 20.dp), onClick = {
             mainViewModel.navigateToNextScreen()
         }) {
             Text(text = "Go to History Screen")
         }

            customDayFromDate()

        /* textfields()

         Spacer(modifier = Modifier.height(20.dp))

         Box(modifier = Modifier.padding(20.dp)) {

             textfields()
         }
         Spacer(modifier = Modifier.height(20.dp))

         val url = "https://www.geeksforgeeks.org"


         val loaderDialogScreen = remember { mutableStateOf(true) }

         if(loaderDialogScreen.value){

             Box(modifier = Modifier.fillMaxWidth()){

                 CircularProgressIndicator(
                     color = Color.Green,
                     strokeWidth = 5.dp,
                     modifier = Modifier.align(Alignment.Center)
                 )
             }
         }

         AndroidView(
             factory = {
                 WebView(it).apply {
                     layoutParams = ViewGroup.LayoutParams(
                         ViewGroup.LayoutParams.MATCH_PARENT,
                         ViewGroup.LayoutParams.MATCH_PARENT
                     )
                     webViewClient = WebViewClient()

                     // to play video on a web view
                     settings.javaScriptEnabled = true

                     webViewClient = object : WebViewClient() {

                         override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                             super.onPageStarted(view, url, favicon)
                             // show dialog
                             loaderDialogScreen.value = true
                         }

                         override fun onPageFinished(view: WebView?, url: String?) {
                             super.onPageFinished(view, url)
                             // hide dialog
                             loaderDialogScreen.value = false
                         }
                     }

                     loadUrl(url)
                 }
             }, update = {
                 it.loadUrl(url)
             })*/

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textfields() {
    var text = ""

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val IndicatorUnfocusedWidth = 1.dp
    val IndicatorFocusedWidth = 2.dp
    val TextFieldPadding = 16.dp

    val indicatorColor = if (isFocused) Color.Red else Color.Gray
    val indicatorWidth = if (isFocused) IndicatorFocusedWidth else IndicatorUnfocusedWidth

    TextField(
        value = text,
        onValueChange = {
            text = it },
        label={Text("Label")},
        interactionSource = interactionSource,
        modifier = Modifier.fillMaxWidth()
            .drawBehind {
                val strokeWidth = indicatorWidth.value * density
                val y = size.height - strokeWidth / 2
                drawLine(
                    indicatorColor,
                    Offset(TextFieldPadding.toPx(), y),
                    Offset(size.width - TextFieldPadding.toPx(), y),
                    strokeWidth
                )
            },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Transparent,
            focusedIndicatorColor =  Transparent,
            unfocusedIndicatorColor = Transparent,
            disabledIndicatorColor = Transparent
        )
    )



}
