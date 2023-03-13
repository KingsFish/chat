package me.zhiq.chat.tool.impl.okhttp

import me.zhiq.chat.tool.interfaces.INetworkInterface
import me.zhiq.chat.tool.model.NetworkResponse
import okhttp3.*

/**
 *
 * @author Fish
 * @email kingsfish95@gmail.com
 * @since 2023/3/8 0:02
 */
class OkHttpNetworkImpl: INetworkInterface {
    override fun sendRequest(
        requestUrl: String,
        method: INetworkInterface.METHOD,
        headers: Map<String, String>,
        params: String,
        timeout: Int
    ): NetworkResponse {
        val mediaType = MediaType.parse("application/json; charset=utf-8")
        val requestBody = RequestBody.create(mediaType, params)
        val request = Request.Builder()
            .url(requestUrl)
            .headers(Headers.of(headers))
            .post(requestBody)
            .build()
        val response = client.newCall(request).execute()
        return NetworkResponse(response.code(), response.body()?.string() ?: "")
    }

    companion object {
        val client: OkHttpClient by lazy {
            OkHttpClient.Builder().build()
        }
    }
}