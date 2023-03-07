package me.zhiq.chat.tool

import android.content.Context
import me.zhiq.chat.tool.interfaces.IDataParser
import me.zhiq.chat.tool.interfaces.INetworkInterface

/**
 * initialize base config
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 19:18
 */

object ChatInitializer {

    fun init(apiKey: String, context: Context): ChatInitializer {
        GlobalConfig.init(apiKey, context)
        return this
    }

    fun withResponseParseClass(parser: IDataParser): ChatInitializer {
        GlobalConfig.dataParser = parser
        return this
    }

    fun withNetworkExecutorClass(network: INetworkInterface): ChatInitializer {
        GlobalConfig.networkExecutor = network
        return this
    }

    fun done() {
        GlobalConfig.done()
    }
}