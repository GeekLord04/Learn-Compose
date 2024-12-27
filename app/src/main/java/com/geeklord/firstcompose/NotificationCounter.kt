package com.geeklord.firstcompose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable                     //Stateful composable as there is state defined here
fun NotificationScreen() {

    var counter = rememberSaveable {
        mutableStateOf(0)           //State hoisting
    }

    Column(

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(color = Color.White)
    ) {
        NotificationCounter(counter, {counter.value++})
        MessageBar(counter)
    }
}

@Composable                       //Stateless composable as there is no state defined here
fun NotificationCounter(count: MutableState<Int>, increment: () -> Unit) {
//    var count : MutableState<Int> = rememberSaveable {              //remember Saveable stores data into bundle so on rotation, it persists
//        mutableStateOf(0)
//    }

    /*
    Column(verticalArrangement = Arrangement.Center) {
        Text(text = "You have sent ${count.value} notifications")
        Button(onClick = {
            count.value++
            Log.d("CODERSTAG", "Button Clicked")
        }) {
            Text(text = "Send Notification")
        }
    } */

    Column(verticalArrangement = Arrangement.Center) {
        Text(text = "You have sent ${count.value} notifications")
        Button(onClick = {
            increment()
        }) {
            Text(text = "Send Notification")
        }
    }
}

@Composable                 //Stateless composable as there is no state defined here
fun MessageBar(count: MutableState<Int>){
    Card (
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(18.dp)
    ) {
        Row (
            Modifier.padding(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = "",
                Modifier.padding(4.dp)
            )
            Text(text = "Message Sent so far - ${count.value}")
        }

    }
}