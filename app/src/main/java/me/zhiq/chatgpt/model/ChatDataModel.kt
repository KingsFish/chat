package me.zhiq.chatgpt.model

import me.zhiq.chat.tool.model.ChatRequest
import me.zhiq.chat.tool.model.ChatResponse
import me.zhiq.chat.tool.model.Message
import me.zhiq.chat.tool.network.RealRequest

/**
 *
 * @author Fish
 * @email kingsfish95@gmail.com
 * @since 2023/3/13 23:09
 */
class ChatDataModel {

    private val dataList: MutableList<ChatResponse> = mutableListOf()

    fun sendNewMsg(str: String): ChatResponse {
        val request = ChatRequest(str)
        val pair = RealRequest().request(request)
        return pair.second!!
    }
}