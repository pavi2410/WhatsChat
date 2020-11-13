package pavi2410.whatsappclone

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import pavi2410.whatsappclone.ui.WhatsAppCloneTheme

data class MessageModel(
    val text: String,
    val sender: Boolean = false
)

val messagesDb = listOf(
    MessageModel("Hi"),
    MessageModel("Hi", true),
    MessageModel("I'm Foo Bar"),
    MessageModel("You are so genius!!! 😍"),
    MessageModel("Foo", true),
    MessageModel("Bar"),
    MessageModel("LOL 😂", true),
    MessageModel("Bye 👋 See you again!")
)

@Preview
@Composable
fun ChatScreenPreview() {
    WhatsAppCloneTheme {
        Column {
            ChatScreen()
        }
    }
}

@Composable
fun ChatScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Icon(Icons.Default.ArrowBack)
                },
                title = {
                    Image(
                        imageResource(R.drawable.detective),
                        Modifier.size(36.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text("Foo Bar")
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
                    modifier = Modifier.weight(1f).padding(4.dp),
                    shape = CircleShape
                )
                Button(
                    onClick = {},
                    shape = CircleShape,
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = Color.White,
                    modifier = Modifier.padding(4.dp).width(56.dp).aspectRatio(1f)
                ) {
                    Icon(Icons.Default.Send)
                }
            }
        }
    ) {
        Column {
            for (message in messagesDb) {
                MessageBubble(message)
            }
        }
    }
}

@Composable
fun MessageBubble(message: MessageModel) {
    if (message.sender) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.fillMaxWidth(0.25f))
            Box(
                Modifier.padding(8.dp).background(
                    Color.Blue,
                    shape = RoundedCornerShape(
                        topLeftPercent = 50,
                        topRightPercent = 50,
                        bottomLeftPercent = 50
                    )
                ),
                alignment = Alignment.Center
            ) {
                Text(message.text, Modifier.padding(16.dp), color = Color.White, fontSize = 20.sp)
            }
        }
    } else {
        Row(Modifier.fillMaxWidth(0.75f), verticalAlignment = Alignment.CenterVertically) {
            Box(
                Modifier.padding(8.dp).background(
                    Color.LightGray,
                    shape = RoundedCornerShape(
                        topLeftPercent = 50,
                        topRightPercent = 50,
                        bottomRightPercent = 50
                    )
                ),
                alignment = Alignment.Center
            ) {
                Text(message.text, Modifier.padding(16.dp), fontSize = 20.sp)
            }
        }
    }
}
