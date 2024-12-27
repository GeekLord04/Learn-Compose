package com.geeklord.firstcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(heightDp = 500)
@Composable
fun PreviewItem(){
//    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {     //remeberScrollState() is used to scroll the column the renders all the items
//        getCategoryList().map { item ->
//            BlogCategory(img = item.img, title = item.title, subtitle = item.subtitle)
//        }
//    }

    LazyColumn(content = {
        items(getCategoryList()){ item ->
            BlogCategory(img = item.img, title = item.title, subtitle = item.subtitle)
        }
    })
}
@Composable
fun BlogCategory(img : ImageVector, title : String, subtitle : String) {     //Implement the UI for the Lazy Column
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(8.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                imageVector = img,
                contentDescription = "Face icon",
                modifier = Modifier
                    .padding(end = 5.dp)
                    .size(33.dp)
                    .weight(.2f)
            )
            ItemDescription(title, subtitle, Modifier.Companion.weight(.8f))
        }
    }
}

@Composable
private fun ItemDescription(title : String, subtitle : String, modifier : Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontSize = 20.sp
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Thin,
            fontSize = 12.sp
        )
    }
}

data class Category(val img : ImageVector, val title : String, val subtitle : String)

fun getCategoryList() : MutableList<Category> {
    val list = mutableListOf<Category>()

    list.add(Category(Icons.Default.Face, "Rikhav Dutta", "Tester"))
    list.add(Category(Icons.Default.Face, "Urmi Dey", "HR"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Soumitra", "Mota"))
    list.add(Category(Icons.Default.Face, "Rajdeep", "Gopal Bhaar"))
    list.add(Category(Icons.Default.Face, "Rajdeep", "Gopal Bhaar"))
    list.add(Category(Icons.Default.Face, "Rajdeep", "Gopal Bhaar"))
    list.add(Category(Icons.Default.Face, "Rajdeep", "Gopal Bhaar"))
    list.add(Category(Icons.Default.Face, "Rajdeep", "Gopal Bhaar"))
    list.add(Category(Icons.Default.Face, "Rajdeep", "Gopal Bhaar"))
    list.add(Category(Icons.Default.Face, "Rajdeep", "Gopal Bhaar"))

    return list
}