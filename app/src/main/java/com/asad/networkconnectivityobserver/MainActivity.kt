package com.asad.networkconnectivityobserver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.asad.networkconnectivityobserver.ui.theme.NetworkConnectivityObserverTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val networkState = NetworkAppClass.internetConnectivityStatus.observeAsState("")

            NetworkConnectivityObserverTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InternetStatus(
                        networkState.value, modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color(0xFF6AEECF))
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalUnitApi::class)
@Composable
fun InternetStatus(state: String, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Internet Status: $state!",
            fontSize = TextUnit(24f, TextUnitType.Sp),
            modifier = modifier.wrapContentSize(),
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InternetStatusPreview() {
    NetworkConnectivityObserverTheme {
        InternetStatus("Connected")
    }
}