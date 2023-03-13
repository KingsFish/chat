package me.zhiq.chat.tool.model

import com.google.gson.annotations.SerializedName

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 18:41
 */
class Choices(
    @SerializedName("finish_reason")
    val finishReason: String,
    @SerializedName("index")
    val index: Int,
    @SerializedName("message")
    val message: Message,
)