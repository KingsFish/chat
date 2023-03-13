package me.zhiq.chat.tool.network

import android.util.Log
import me.zhiq.chat.tool.GlobalConfig
import me.zhiq.chat.tool.interfaces.INetworkInterface
import me.zhiq.chat.tool.model.ChatRequest
import me.zhiq.chat.tool.model.ChatResponse
import kotlin.random.Random

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 17:23
 */
class RealRequest {

    fun request(request: ChatRequest): Pair<Int, ChatResponse?> {
        checkConfig()
        val headers = mutableMapOf<String, String>()
        headers[KEY_CONTENT_TYPE] = GlobalConfig.CONTENT_TYPE
        headers[KEY_AUTHORIZATION] = "Bearer ${getApiKey()}"

        val dataParse = GlobalConfig.dataParser
        val result = GlobalConfig.networkExecutor
            .sendRequest(GlobalConfig.API_PATH, INetworkInterface.METHOD.POST, headers,
                request.toRealRequest(), 5000)
        val code = result.code
         Log.d(TAG, "response: $result")
        val response = dataParse.parseResponse(result.response)
        response?.responseCode = code
        response?.rawData = result.response
        return Pair(code, response)
    }

    private fun getApiKey(): String {
        val size = GlobalConfig.apiKeys.size
        if (size == 1) return GlobalConfig.apiKeys[0]
        val random = Random.nextInt(size)
        return GlobalConfig.apiKeys[random]
    }

    private fun checkConfig() {
        if (!GlobalConfig.isValid())
            throw IllegalArgumentException("module is not correctly configured")
    }

    companion object {
        const val KEY_CONTENT_TYPE = "Content-Type"
        const val KEY_AUTHORIZATION = "Authorization"
        const val TAG = "RealRequest"
    }
}