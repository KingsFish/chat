package me.zhiq.chat.tool.impl

import me.zhiq.chat.tool.interfaces.IDataParser
import me.zhiq.chat.tool.model.ChatRequest
import me.zhiq.chat.tool.model.ChatResponse
import org.json.JSONObject

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 19:44
 */
class DefaultDataParser: IDataParser {
    override fun parseResponse(json: JSONObject): ChatResponse {
        TODO("Not yet implemented")
    }

    override fun parseRequest(request: ChatRequest): String {
        TODO("Not yet implemented")
    }
}