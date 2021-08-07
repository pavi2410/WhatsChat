package pavi2410.whatschat.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pavi2410.whatschat.R
import pavi2410.whatschat.components.ReceivedMessageBubble
import pavi2410.whatschat.components.SentMessageBubble
import pavi2410.whatschat.db.messagesDb
import pavi2410.whatschat.ui.WhatsChatTheme

@Preview
@Composable
fun ChatScreenPreview() {
    WhatsChatTheme {
        Surface(color = MaterialTheme.colors.background) {
            Column {
                ChatScreen(id = 1234, onNavUp = { true })
            }
        }
    }
}

@Composable
fun ChatScreen(id: Int, onNavUp: () -> Boolean) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { onNavUp() }) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                },
                title = {
                    Image(
                        painterResource(R.drawable.detective), null,
                        Modifier.size(36.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text("Foo Bar for id = $id")
                }
            )
        },
        bottomBar = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                TextField(
                    value = "",
                    onValueChange = {},
                    placeholder = {
                        Text("Type your message...")
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    shape = CircleShape
                )
                Button(
                    onClick = {},
                    shape = CircleShape,
//                    backgroundColor = MaterialTheme.colors.secondary,
//                    contentColor = Color.White,
                    modifier = Modifier
                        .padding(4.dp)
                        .width(56.dp)
                        .aspectRatio(1f)
                ) {
                    Icon(Icons.Default.Send, null)
                }
            }
        }
    ) {
        Column {
            for (message in messagesDb) {
                if (message.sender) {
                    SentMessageBubble(message)
                } else {
                    ReceivedMessageBubble(message)
                }
            }
        }
    }
}
