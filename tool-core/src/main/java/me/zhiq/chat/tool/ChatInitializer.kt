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
    private var inited = false

    fun init(apiKeys: List<String>, context: Context): ChatInitializer {
        if (inited) return this
        GlobalConfig.init(apiKeys, context)
        return this
    }

    fun withResponseParseClass(parser: IDataParser): ChatInitializer {
        if (inited) return this
        GlobalConfig.dataParser = parser
        return this
    }

    fun withNetworkExecutorClass(network: INetworkInterface): ChatInitializer {
        if (inited) return this
        GlobalConfig.networkExecutor = network
        return this
    }

    fun done() {
        if (inited) return
        GlobalConfig.done()
        inited = true
    }
}