package me.zhiq.chatgpt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.zhiq.chatgpt.model.ChatDataModel
import me.zhiq.chatgpt.model.ChatMessage
import me.zhiq.chatgpt.model.Role

/**
 *
 * @author Fish
 * @email kingsfish95@gmail.com
 * @since 2023/3/12 1:46
 */
class ChatViewModel: ViewModel() {
    private val model = ChatDataModel()
    private val _chatDataState = MutableStateFlow<ChatMessage>(ChatMessage(Role.AI, "hello~"))
    val chatData: StateFlow<ChatMessage> get() = _chatDataState
    fun sendRequest(str: String) {
        val userMsg = ChatMessage(Role.USER, str)
        _chatDataState.value = userMsg
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                model.sendNewMsg(str)
            }
            val choices = response.choice
            val netMsg = choices[0].message.content
            val aiMsg = ChatMessage(Role.AI, netMsg)
            _chatDataState.value = aiMsg
        }
    }
}