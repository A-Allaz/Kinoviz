package com.example.kinoviz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kinoviz.ui.theme.KinovizTheme
import kotlinx.coroutines.delay
import androidx.compose.material.icons.filled.FitnessCenter



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KinovizTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "splash"
                ) {
                    composable("splash") { SplashScreen(navController) }
                    composable("main") { MainScreen() }
                }
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000L) // 2 seconds
        navController.navigate("main") {
            popUpTo("splash") { inclusive = true } // remove splash from back stack
        }
    }

    // Centered logo
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "KINOVIZ",
            style = MaterialTheme.typography.headlineLarge
        )
        // You can use Image(...) here if you want to show a logo instead
    }
}


@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // 1. Logo Section (0–10%)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f),
            contentAlignment = Alignment.Center
        ) {
            Text("Kinoviz", style = MaterialTheme.typography.headlineSmall)
            // Or use Image(...) if you have a logo
        }

        // 2. First Image Card (12–40%)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.38f)
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.exercise_correction),
                contentDescription = "Correction d'exercice",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(20.dp))
            )
            Text(
                text = "Correction d’exercice",
                fontSize = 30.sp,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            )

            // Bottom-right button
            Button(
                onClick = { /* handle click */ },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text("Choisissez votre mouvement")
            }
        }

        // 3. Second Image Card (42–80%)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.38f)
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.exercise_of_day),
                contentDescription = "Exercice du jour",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(20.dp))
            )
            Text(
                text = "Exercice du jour",
                fontSize = 30.sp,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            )

            // Bottom-right button
            Button(
                onClick = { /* handle click */ },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text("VOIR")
            }

        }

        // 4. Bottom Navigation (80–100%)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.10f)
                .background(Color(0xFF00BFCB))
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Filled.FitnessCenter, contentDescription = null, tint = Color.White)
                Text("Musculation", color = Color.White, style = MaterialTheme.typography.labelSmall)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.Add, contentDescription = null, tint = Color.White)
                Text("RÉÉDUCATION", color = Color.White, style = MaterialTheme.typography.labelSmall)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.Person, contentDescription = null, tint = Color.White)
                Text("MON COMPTE", color = Color.White, style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    KinovizTheme {
        MainScreen()
    }
}
