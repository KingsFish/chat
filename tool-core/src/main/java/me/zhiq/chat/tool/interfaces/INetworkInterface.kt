package me.zhiq.chat.tool.interfaces

import androidx.annotation.WorkerThread
import me.zhiq.chat.tool.model.NetworkResponse

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 19:04
 */
interface INetworkInterface {

    @WorkerThread
    fun sendRequest(requestUrl: String, method: METHOD,
                    headers: Map<String, String>,
                    params: String, timeout: Int): NetworkResponse

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