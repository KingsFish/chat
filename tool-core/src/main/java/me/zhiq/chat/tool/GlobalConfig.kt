package me.zhiq.chat.tool

import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.RestrictTo
import me.zhiq.chat.tool.interfaces.IDataParser
import me.zhiq.chat.tool.interfaces.INetworkInterface
import java.util.*

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 18:45
 */

@SuppressLint("StaticFieldLeak")
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
internal object GlobalConfig {

    const val MODEL = "gpt-3.5-turbo"
    const val CONTENT_TYPE = "application/json"

    val uid = UUID.randomUUID()

    const val API_PATH = "https://api.openai.com/v1/chat/completions"

    lateinit var appContext: Context
    lateinit var apiKeys: List<String>

    lateinit var networkExecutor: INetworkInterface
    lateinit var dataParser: IDataParser

    fun init(apiKeys: List<String>, context: Context) {
        this.appContext = context.applicationContext
        this.apiKeys = apiKeys
    }

    /**
     * check if config is valid
     */
    fun isValid(): Boolean {
        return apiKeys.isNotEmpty() && appContext != null
    }

    fun done() {
    }
}