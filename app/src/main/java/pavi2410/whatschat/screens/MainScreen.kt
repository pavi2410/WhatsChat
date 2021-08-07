package pavi2410.whatschat.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pavi2410.whatschat.R
import pavi2410.whatschat.components.ChatItem
import pavi2410.whatschat.ui.WhatsChatTheme

@Preview
@Composable
fun MainScreenPreview() {
    WhatsChatTheme {
        Surface(color = MaterialTheme.colors.background) {
            MainScreen(onChatOpen = {})
        }
    }
}

@Composable
fun MainScreen(onChatOpen: (Int) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Image(painterResource(R.drawable.whatsapp_logo), null, Modifier.padding(8.dp))
                },
                title = {
                    Text(
                        "Chats",
                        Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.ExtraBold
                    )
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Outlined.Search, null)
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Outlined.Menu, null)
                    }
                },
                elevation = 0.dp,
                modifier = Modifier.height(64.dp)
            )
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(icon = {
                    Icon(Icons.Outlined.Home, null)
                }, selected = true, onClick = {})
                BottomNavigationItem(icon = {
                    Icon(Icons.Outlined.Person, null)
                }, selected = false, onClick = {})
                BottomNavigationItem(icon = {
                    Icon(Icons.Outlined.CheckCircle, null)
                }, selected = false, onClick = {})
                BottomNavigationItem(icon = {
                    Icon(Icons.Outlined.Call, null)
                }, selected = false, onClick = {})
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}, contentColor = Color.White) {
                Icon(Icons.Default.Favorite, null)
            }
        }
    ) {
        Column {
            repeat(6) {
                ChatItem(id = it, onChatOpen = onChatOpen)
            }
        }
    }
}


