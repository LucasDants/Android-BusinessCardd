package com.example.businesscard

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                        color = Color(0xFF073042)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(modifier = Modifier.fillMaxSize()) {
        Header(modifier = Modifier.weight(0.7F))
        Contacts(modifier = Modifier.weight(0.3F))
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    val androidImage = painterResource(id = R.drawable.android_logo)

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight(align = Alignment.CenterVertically)) {
        Image(painter = androidImage, contentDescription = "Android logo", modifier = Modifier.fillMaxWidth(0.25F))
        Text(text = "Lucas Dantas", color = Color.White, fontSize = 40.sp)
        Text(text = "Mobile Developer Extraordinaire", color = Color(0xFF3ddc84), fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Contacts(modifier: Modifier = Modifier) {
    Column(modifier = modifier.wrapContentHeight(align = Alignment.Bottom)) {
        Contact(contact = "+55 (99) 99999-9999", icon = Icons.Rounded.Phone)
        Contact(contact = "@LucasDants", icon = Icons.Rounded.Share)
        Contact(contact = "in/lucasdants", icon = Icons.Rounded.Email)
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Composable
fun Contact(contact: String, icon: ImageVector) {
    Divider(color = Color.White, modifier = Modifier.fillMaxWidth(), thickness = 1.dp)
    Row (modifier = Modifier.padding(vertical = 8.dp)) {
        Spacer(modifier = Modifier.fillMaxWidth(0.15F))
        Icon(icon, contentDescription = icon.name, tint = Color(0xFF3ddc84))
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = contact, color = Color.White)
    }
 
}

@Preview(showBackground = false)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}