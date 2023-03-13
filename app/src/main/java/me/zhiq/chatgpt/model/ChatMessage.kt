package me.zhiq.chatgpt.model

/**
 *
 * @author Fish
 * @email kingsfish95@gmail.com
 * @since 2023/3/13 23:32
 */
class ChatMessage (
    val role: Role,
    val msg: String,
)

enum class Role {
    USER,
    AI
}