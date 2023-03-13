package me.zhiq.chat.tool.model

import com.google.gson.annotations.SerializedName
import me.zhiq.chat.tool.GlobalConfig

/**
 *  request model
 * @link https://platform.openai.com/docs/api-reference/chat/create
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 18:54
 */
class ChatRequest(
    @SerializedName("prompt")
    val prompt: String,
    /*
    @SerializedName("max_tokens")
    val maxTokens: Long = 2048,
    @SerializedName("temperature")
    val temperature: Float = 1f,
    @SerializedName("top_p")
    val topP: Float = 1f,
    @SerializedName("n")
    val responseMsgCount: Int = 1,
    @SerializedName("stream")
    val stream: Boolean = false,
    @SerializedName("stop")
    val stop: String? = null,
    @SerializedName("presence_penalty")
    val presencePenalty: Float = 0f,
    @SerializedName("frequency_penalty")
    val frequencyPenalty: Float = 0f,
    @SerializedName("logit_bias")
    val logitBias: Map<String, Any>? = null,
    @SerializedName("user")
    val user: String = "", */
    @SerializedName("model")
    val model: String = GlobalConfig.MODEL,
) {

    internal fun toRealRequest(): String {
        return GlobalConfig.dataParser.parseModelToStr(this)
    }
}