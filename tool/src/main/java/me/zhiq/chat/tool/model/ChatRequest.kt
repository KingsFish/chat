package me.zhiq.chat.tool.model

import me.zhiq.chat.tool.GlobalConfig

/**
 *  request model
 * @link https://platform.openai.com/docs/api-reference/chat/create
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 18:54
 */
class ChatRequest(
    val messages: List<Message>,
    val temperature: Float = 1f,
    val topP: Float = 1f,
    val responseMsgCount: Int = 1,
    val stream: Boolean = false,
    val stop: String? = null,
    val maxTokens: Long = Long.MAX_VALUE,
    val presencePenalty: Float = 0f,
    val frequencyPenalty: Float = 0f,
    val logitBias: Map<String, Any>? = null,
    val user: String = "",
    val extra: Map<String, Any>? = null,
    val model: String = GlobalConfig.MODEL
) {

    internal fun toRealRequest(): String {
        TODO()
    }
}