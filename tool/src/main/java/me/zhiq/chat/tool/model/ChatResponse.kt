package me.zhiq.chat.tool.model

import org.json.JSONObject

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 18:35
 */
class ChatResponse(
    val id: String,
    val objectStr: String,
    val createTs: Long,
    val model: String,
    val usage: Usage,
    val choice: List<Choices>,
    val rawData: JSONObject
)