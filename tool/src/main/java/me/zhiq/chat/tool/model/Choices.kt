package me.zhiq.chat.tool.model

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 18:41
 */
class Choices(
    val finishReason: String,
    val index: Int,
    val message: Message,
)