package pavi2410.whatschat.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatItem() {
    val padding = 16.dp
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(padding)
    ) {
        Icon(
            Icons.Default.Face, null,
            Modifier
                .size(56.dp)
                .background(MaterialTheme.colors.primary, shape = CircleShape)
        )
        Spacer(Modifier.width(padding))
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            ) {
                Text("Foo Bar", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("12:56 PM", color = MaterialTheme.colors.secondary)
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Text("What are you doing?", fontWeight = FontWeight.Bold)
            }
        }
    }
    Divider(Modifier.padding(horizontal = padding))
}