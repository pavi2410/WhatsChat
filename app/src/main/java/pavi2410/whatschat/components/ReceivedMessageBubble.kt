package pavi2410.whatschat.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pavi2410.whatschat.models.MessageModel

@Composable
fun ReceivedMessageBubble(message: MessageModel) {
    Row(Modifier.fillMaxWidth(0.75f), verticalAlignment = Alignment.CenterVertically) {
        Box(
            Modifier
                .padding(8.dp)
                .widthIn(min = 64.dp)
                .background(
                    Color.LightGray,
                    shape = RoundedCornerShape(
                        topStartPercent = 50,
                        topEndPercent = 50,
                        bottomEndPercent = 50
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(message.text, Modifier.padding(16.dp), fontSize = 20.sp)
        }
    }
}