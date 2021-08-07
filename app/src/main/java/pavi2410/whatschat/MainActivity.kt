package pavi2410.whatschat

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pavi2410.whatschat.screens.ChatScreen
import pavi2410.whatschat.screens.MainScreen
import pavi2410.whatschat.ui.WhatsChatTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatsChatTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    NavHost(navController, startDestination = "main") {
                        composable("main") { MainScreen(onChatOpen = { navController.navigate("chat/$it")}) }
                        composable("chat/{id}") { backStackEntry ->
                            val chatId = backStackEntry.arguments?.getString("id")?.toInt() ?: 0
                            ChatScreen(id = chatId, onNavUp = { navController.navigateUp() })
                        }
                    }
                }
            }
        }
    }
}