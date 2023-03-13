package me.zhiq.chatgpt.ui

import android.app.Application
import me.zhiq.chat.tool.ChatInitializer
import me.zhiq.chat.tool.impl.okhttp.OkHttpNetworkImpl
import me.zhiq.chat.tool.network.DefaultDataParser
import me.zhiq.chatgpt.BuildConfig

/**
 *
 * @author Fish
 * @email kingsfish95@gmail.com
 * @since 2023/3/9 9:58
 */
class ChatApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        val apiKeys = mutableListOf<String>().apply { add(BuildConfig.API_KEY) }
        ChatInitializer.init(apiKeys, this)
            .withNetworkExecutorClass(OkHttpNetworkImpl())
            .withResponseParseClass(DefaultDataParser())
            .done()
    }
}