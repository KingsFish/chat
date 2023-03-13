package me.zhiq.chat.tool.interfaces

import me.zhiq.chat.tool.model.ChatRequest
import me.zhiq.chat.tool.model.ChatResponse

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 19:16
 */
interface IDataParser {
    fun parseResponse(jsonStr: String): ChatResponse?
    fun parseModelToStr(instance: ChatRequest): String
}

