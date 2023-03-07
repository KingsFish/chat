package me.zhiq.chat.tool

import android.annotation.SuppressLint
import android.content.Context
import me.zhiq.chat.tool.impl.DefaultDataParser
import me.zhiq.chat.tool.impl.DefaultNetworkImpl
import me.zhiq.chat.tool.interfaces.IDataParser
import me.zhiq.chat.tool.interfaces.INetworkInterface

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 18:45
 */

@SuppressLint("StaticFieldLeak")
internal object GlobalConfig {

    const val MODEL = "gpt-3.5-turbo"
    const val CONTENT_TYPE = "application/json"

    const val API_PATH = "https://api.openai.com/v1/chat/completions"

    lateinit var appContext: Context
    lateinit var apiKey: String

    var networkExecutor: INetworkInterface = DefaultNetworkImpl()
    var dataParser: IDataParser = DefaultDataParser()

    fun init(apiKey: String, context: Context) {
        this.appContext = context.applicationContext
        this.apiKey = apiKey
    }

    /**
     * check if config is valid
     */
    fun isValid(): Boolean {
        return !apiKey.isNullOrBlank() && appContext != null
    }

    fun done() {
    }
}