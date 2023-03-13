package me.zhiq.chat.tool.model

import com.google.gson.annotations.SerializedName
import me.zhiq.chat.tool.GlobalConfig

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 18:42
 */
class Message(
    @SerializedName("content")
    val content: String,
    @SerializedName("role")
    internal val role: String = GlobalConfig.uid.toString(),
)