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
import pavi2410.whatschat.MessageModel

@Composable
fun SentMessageBubble(message: MessageModel) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.fillMaxWidth(0.25f))
        Box(
            Modifier
                .padding(8.dp)
                .background(
                    Color.Blue,
                    shape = RoundedCornerShape(
                        topStartPercent = 50,
                        topEndPercent = 50,
                        bottomStartPercent = 50
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(message.text, Modifier.padding(16.dp), color = Color.White, fontSize = 20.sp)
        }
    }
}