package me.zhiq.chat.tool.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.zhiq.chat.tool.GlobalConfig
import me.zhiq.chat.tool.model.ChatRequest
import me.zhiq.chat.tool.model.ChatResponse

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 17:23
 */
class RealRequest {

    fun request(request: ChatRequest, callback: (ChatResponse) -> Unit) {
        checkConfig()
        val headers = mutableMapOf<String, String>()
        headers[KEY_CONTENT_TYPE] = GlobalConfig.CONTENT_TYPE
        headers[KEY_AUTHORIZATION] = "Bearer $GlobalConfig.apiKey"

        val data = mutableMapOf<String, String>()
        data["model"] = GlobalConfig.MODEL

        MainScope().launch {
            withContext(Dispatchers.IO) {
                val dataParse = GlobalConfig.dataParser
//                val connection = GlobalConfig.networkExecutor
//                    .sendRequest(GlobalConfig.API_PATH, INetworkInterface.METHOD.POST,
//                        request.toRealRequest())
            }
        }
    }

    private fun checkConfig() {
        if (!GlobalConfig.isValid())
            throw IllegalArgumentException("module is not correctly configured")
    }

    companion object {
        const val KEY_CONTENT_TYPE = "Content-Type"
        const val KEY_AUTHORIZATION = "Authorization"
    }
}