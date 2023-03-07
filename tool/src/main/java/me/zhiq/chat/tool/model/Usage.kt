package me.zhiq.chat.tool.model

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 18:40
 */
class Usage(
    val promptTokens: Long,
    val completionTokens: Long,
    val total: Long,
)