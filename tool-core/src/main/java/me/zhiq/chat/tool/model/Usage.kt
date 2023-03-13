package me.zhiq.chat.tool.model

import com.google.gson.annotations.SerializedName

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 18:40
 */
class Usage(
    @SerializedName("prompt_tokens")
    val promptTokens: Long,
    @SerializedName("completion_tokens")
    val completionTokens: Long,
    @SerializedName("total_tokens")
    val total: Long,
)