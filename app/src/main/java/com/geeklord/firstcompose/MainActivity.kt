package com.geeklord.firstcompose

import android.os.Bundle
import android.print.PrintAttributes.Margins
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.geeklord.firstcompose.ui.theme.FirstComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            TextFields()
        }
    }
}

//Preview Function
// Default value is always required for @Preview annotation to get rendered
// Therefore we always create a Preview Function
@Preview(showBackground = true, heightDp = 300, widthDp = 300, showSystemUi = false)
@Composable
private fun PreviewFunction() {
//    SayCheezy("Jingalala")
//    DrawImage()
//    ButtonCompose()
    DesignUser()


}


//Text Composable
@Composable
fun SayCheezy(name: String) {
    Text(
        text = "Hello $name",
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        color = Color.Magenta,
        fontSize = 17.sp,
        textAlign = TextAlign.Center
    )
}

/*
@Preview(showBackground = true, name = "Hello Message2")
@Composable
fun SayCheezy2(name :String = "Chirag"){
    Text(text = "Hello $name")
}
 */

//Image Composable
@Composable
fun DrawImage() {
    Image(
        painter = painterResource(id = R.drawable.blue),
        contentDescription = "Dummy Image",         //Helps visually impaired people
        colorFilter = ColorFilter.tint(Color.Gray)
    )
}

//Button Composable
@Composable
fun ButtonCompose() {
    Button(
        onClick = {},
        Modifier.size(4.dp, 4.dp),
        shape = ShapeDefaults.ExtraSmall,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Black          //background is changed to containerColor
        ),
        enabled = false             //Button is disabled
    ) {
        Text(text = "Click here")
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Test"
        )
    }
}


//Edittext Composable - (Edittext in Views)
@Composable
fun TextFields() {
    val state = remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.padding(16.dp)) {       //This is for System preview
        TextField(
            value = state.value,
            onValueChange = {
                state.value = it
                Log.d("FirstComposeLog", "TextFields: $it")
            },
            label = { Text(text = "Name") },
            placeholder = { Text(text = "Enter your name") },
            modifier = Modifier
                .padding(8.dp)
                .size(200.dp, 56.dp) // Adjust the size as needed
        )
    }
}


//Layout Composable
@Composable
fun ColumnLayoutComposable() {
    /*
    Text(
        text = "B",
        fontSize = 24.sp
    )
    Text(
        text = "A",
        fontSize = 24.sp
    )
     */
    //If we write two texts like this, then it'll overlap, there we need layout

    //Column Composable
    Column(
//        verticalArrangement = Arrangement.SpaceBetween      //Maximum Space possible in Y axis will be occupied
//        verticalArrangement = Arrangement.SpaceEvenly       //Maximum Space possible in Y axis will be equally distributed
//        verticalArrangement = Arrangement.Bottom            //Puts both the texts in the bottom of the screen
//        verticalArrangement = Arrangement.Top               //Puts both the texts in the top of the screen
        verticalArrangement = Arrangement.Center,            //Puts both the texts in the center of the screen

        //Now comes horizantal alignment
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "A",
            fontSize = 24.sp
        )
        Text(
            text = "B",
            fontSize = 24.sp
        )
    }
}

@Composable
fun RowLayoutComposable() {
    /*
    Text(
        text = "B",
        fontSize = 24.sp
    )
    Text(
        text = "A",
        fontSize = 24.sp
    )
     */
    //If we write two texts like this, then it'll overlap, there we need layout

    //Column Composable
    Row(
//        verticalArrangement = Arrangement.SpaceBetween      //Maximum Space possible in Y axis will be occupied
//        verticalArrangement = Arrangement.SpaceEvenly       //Maximum Space possible in Y axis will be equally distributed
//        verticalArrangement = Arrangement.Bottom            //Puts both the texts in the bottom of the screen
//        verticalArrangement = Arrangement.Top               //Puts both the texts in the top of the screen
        horizontalArrangement = Arrangement.SpaceAround,            //Puts both the texts in the center of the screen

        //Now comes horizantal alignment
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "A",
            fontSize = 24.sp
        )
        Text(
            text = "B",
            fontSize = 24.sp
        )
    }
}

@Composable
fun BoxLayout() {            //Box is similar to FrameLayout in Android
    Box() {
        Image(painter = painterResource(id = R.drawable.test1), contentDescription = "Test2")
        Image(painter = painterResource(id = R.drawable.test2), contentDescription = "Test3")
    }

}

//Designing a view
@Composable
fun DesignUser() {
    Row() {
        Icon(
            imageVector = Icons.Default.Face,
            contentDescription = "Face icon",
            modifier = Modifier.size(35.dp)
                .padding(8.dp)
        )
        Column {
            Text(
                text = "John Doe",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Software Developer",
                fontWeight = FontWeight.Light
            )
        }
    }
}