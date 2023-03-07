package me.zhiq.chat.tool.interfaces

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 19:04
 */
interface INetworkInterface {

    fun sendRequest(url: String, method: METHOD, body: Map<String, String>)

    enum class METHOD {
        GET,
        POST;

        fun getString() =
            when(this) {
                GET -> "GET"
                POST -> "POST"
            }
    }
}