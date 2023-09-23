package com.example.jetpacknaviation.screen.history

import android.media.AudioManager
import android.media.MediaPlayer
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen() {

    val mainViewModel = hiltViewModel<HistoryViewModel>()


    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {

        Scaffold(topBar = {
            TopAppBar(title = {
                Text(
                    text = "Custom Toast in Android", modifier = Modifier.fillMaxWidth(),

                    textAlign = TextAlign.Center, color = Color.White
                )
            })
        }) { it ->
            CustomDayFromDate()
//            customToastUI()
        }
    }

}


@Composable
fun CustomDayFromDate() {
    val dates = listOf(
        25, 26, 27, 28, 29, 30, 1, 2, 3, 4, 5, 6, 7, 8, 9,
        10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25
    )

    val firstDate = dates[0]

    val formatter = SimpleDateFormat("d/M/yyyy", Locale.ENGLISH)
    val calendar = Calendar.getInstance()

    val currentYear = calendar.get(Calendar.YEAR)
    val currentMonth = calendar.get(Calendar.MONTH) + 1

    val firstDateFormatted = if (firstDate > calendar.get(Calendar.DAY_OF_MONTH)) {
        // If firstDate is greater than the current day, it belongs to the previous month
        val previousMonth = if (currentMonth == 1) 12 else currentMonth - 1
        "$firstDate/$previousMonth/$currentYear"
    } else {
        "$firstDate/$currentMonth/$currentYear"
    }

    calendar.time = formatter.parse(firstDateFormatted)

    val dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH)



    Log.e("TAG", "First date: $firstDateFormatted ")
    Log.e("TAG", "Day of the week for the first date: $dayOfWeek")/*val currentYear = LocalDate.now().year
    val currentMonth = LocalDate.now().monthValue

    val formatter = DateTimeFormatter.ofPattern("d/M/yyyy")
    val firstDateFormatted = "$firstDate/$currentMonth/$currentYear"

    val date = LocalDate.parse(firstDateFormatted, formatter)
    val dayOfWeek = date.dayOfWeek*/

}

@Composable
fun CustomToastUI() {
    val ctx = LocalContext.current
    val mediaPlayer = MediaPlayer()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .fillMaxSize()

            .padding(6.dp),

        verticalArrangement = Arrangement.Center,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(

            modifier = Modifier.padding(6.dp),

            text = "Play Audio from URL",

            fontWeight = FontWeight.Bold,

            color = Color.Blue,

            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(modifier = Modifier
            .width(300.dp)
            .padding(7.dp),

            onClick = {

                val audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"

                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

                try {
                    mediaPlayer.setDataSource(audioUrl)

                    mediaPlayer.prepare()

                    mediaPlayer.start()

                } catch (e: Exception) {

                    e.printStackTrace()
                }

                Toast.makeText(ctx, "Audio started playing..", Toast.LENGTH_SHORT).show()

            }) {
            Text(text = "Play Audio")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier
                .width(300.dp)
                .padding(7.dp),

            onClick = {
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.stop()
                    mediaPlayer.reset()

                    mediaPlayer.release()

                    Toast.makeText(ctx, "Audio has been  paused..", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(ctx, "Audio not played..", Toast.LENGTH_SHORT).show()
                }


            }) {
            Text(text = "Pause Audio")
        }


    }
}

