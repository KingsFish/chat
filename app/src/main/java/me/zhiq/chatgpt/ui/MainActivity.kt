package me.zhiq.chatgpt.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import me.zhiq.chat.tool.model.Message
import me.zhiq.chatgpt.viewmodel.ChatViewModel
import me.zhiq.chatgpt.ui.ui.theme.ChatTheme

class MainActivity : ComponentActivity() {

    private val model: ChatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatTheme {
                Title(name = "Chat")
                List()
            }
        }
    }

    @Composable
    fun Title(name: String) {
        TopAppBar(title = {
            Text(text = name)
        })
    }

    @Composable
    fun List() {
        LazyColumn {

        }
    }

    @Composable
    fun SingleColumn(msg:Message) {
        Text(text = msg.content)
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ChatTheme {
            Title("Chat")
            List()
        }
    }
}
