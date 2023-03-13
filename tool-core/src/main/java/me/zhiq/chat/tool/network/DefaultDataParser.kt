package me.zhiq.chat.tool.network

import com.google.gson.Gson
import me.zhiq.chat.tool.interfaces.IDataParser
import me.zhiq.chat.tool.model.ChatRequest
import me.zhiq.chat.tool.model.ChatResponse

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 19:44
 */
class DefaultDataParser: IDataParser {

    private val gson = Gson()
    override fun parseResponse(jsonStr: String): ChatResponse {
        return gson.fromJson(jsonStr, ChatResponse::class.java)
    }

    override fun parseModelToStr(instance: ChatRequest): String {
        return gson.toJson(instance)
    }
}