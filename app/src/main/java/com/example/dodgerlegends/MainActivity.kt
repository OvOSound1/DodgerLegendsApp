package com.example.dodgerlegends

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dodgerlegends.ui.theme.DodgerLegendsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DodgerLegendsTheme {
                DodgerLegendsApp()
            }
        }
    }
}
@Preview
@Composable
fun DodgerLegendsApp() {
    var index by remember { mutableStateOf(0) }

    val images = listOf(
        R.drawable.mookie,
        R.drawable.kershaw,
        R.drawable.freeman
    )

    val titles = listOf("Mookie Betts", "Clayton Kershaw", "Freddie Freeman")
    val positions = listOf("Right Fielder", "Pitcher", "First Baseman")
    val years = listOf("Joined: 2020", "Joined: 2008", "Joined: 2022")

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF2196F3)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = titles[index],
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFFFFFFFF),
                fontSize = 35.sp
            )

            Image(
                painter = painterResource(id = images[index]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = titles[index],
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 34.sp,
                    color = Color(0xFFFFFFFF)
                )
                Text(
                    text = positions[index],
                    fontSize = 24.sp,
                    color = Color(0xFFFFFFFF)
                )
                Text(
                    text = years[index],
                    fontSize = 24.sp,
                    color = Color(0xFFFFFFFF)
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { index = if (index == 0) 2 else index - 1 },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF0000),
                        contentColor = Color(0xFFFFFFFF)
                    )
                ) {
                    Text("Previous")
                }
                Button(
                    onClick = { index = (index + 1) % 3 },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF0000),
                        contentColor = Color(0xFFFFFFFF)
                    )
                ) {
                    Text("Next")
                }
            }
        }
    }
}