package me.zhiq.chat.tool.impl.defaults

import me.zhiq.chat.tool.interfaces.INetworkInterface
import me.zhiq.chat.tool.model.NetworkResponse

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 19:41
 */

class DefaultNetworkImpl: INetworkInterface {

    override fun sendRequest(
        requestUrl: String,
        method: INetworkInterface.METHOD,
        headers: Map<String, String>,
        params: String,
        timeout: Int
    ): NetworkResponse {
        return NetworkResponse(200, "")
//        val url = URL(requestUrl)
//        val connection = url.openConnection() as HttpURLConnection
//        connection.requestMethod = method.getString()
//        connection.connectTimeout = timeOut
//        for ((key, value) in headers) {
//            if (key.isNotBlank() && value.isNotBlank()) {
//                connection.addRequestProperty(key, value)
//            }
//        }
//        connection.connect()
//        val writer = BufferedWriter(OutputStreamWriter(connection.outputStream, "UTF-8"))
//        writer.write(params)
//        writer.close()
//        val responseCode = connection.responseCode
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//
//        }
    }
}