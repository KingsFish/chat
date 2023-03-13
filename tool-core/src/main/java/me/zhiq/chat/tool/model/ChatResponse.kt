package me.zhiq.chat.tool.model

import com.google.gson.annotations.SerializedName

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 18:35
 */
class ChatResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("object")
    val objectStr: String,
    @SerializedName("created")
    val createTs: Long,
    @SerializedName("model")
    val model: String,
    @SerializedName("usage")
    val usage: Usage,
    @SerializedName("choices")
    val choice: List<Choices>,
) {
    lateinit var rawData: String
        internal set
    var responseCode: Int = -1
        internal set
}