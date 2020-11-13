package pavi2410.whatsappclone

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import pavi2410.whatsappclone.ui.WhatsAppCloneTheme

@Preview
@Composable
fun MainScreenPreview() {
    WhatsAppCloneTheme {
        Surface(color = MaterialTheme.colors.background) {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Image(vectorResource(R.drawable.whatsapp_logo), Modifier.padding(4.dp))
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
                        Icon(asset = Icons.Outlined.Search)
                    }
                    IconButton(onClick = {}) {
                        Icon(asset = Icons.Outlined.Menu)
                    }
                },
                elevation = 0.dp,
                modifier = Modifier.height(64.dp)
            )
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(icon = {
                    Icon(Icons.Outlined.Home)
                }, selected = true, onClick = {})
                BottomNavigationItem(icon = {
                    Icon(Icons.Outlined.Person)
                }, selected = false, onClick = {})
                BottomNavigationItem(icon = {
                    Icon(Icons.Outlined.CheckCircle)
                }, selected = false, onClick = {})
                BottomNavigationItem(icon = {
                    Icon(Icons.Outlined.Call)
                }, selected = false, onClick = {})
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}, contentColor = Color.White) {
                Icon(Icons.Default.Favorite)
            }
        }
    ) {
        Column {
            repeat(6) {
                ChatItem()
            }
        }
    }
}


@Composable
fun ChatItem() {
    val padding = 16.dp
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().height(72.dp).padding(padding)
    ) {
        Icon(
            asset = Icons.Default.Face,
            Modifier.size(56.dp)
                .background(MaterialTheme.colors.primary, shape = CircleShape)
        )
        Spacer(Modifier.width(padding))
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f)
            ) {
                Text("Foo Bar", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("12:56 PM", color = MaterialTheme.colors.secondary)
            }
            Row(Modifier.fillMaxWidth().fillMaxHeight()) {
                ProvideEmphasis(emphasis = EmphasisAmbient.current.medium) {
                    Text("What are you doing?")
                }
            }
        }
    }
    Divider(Modifier.padding(horizontal = padding))
}