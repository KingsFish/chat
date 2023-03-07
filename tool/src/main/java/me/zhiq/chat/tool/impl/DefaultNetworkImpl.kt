package me.zhiq.chat.tool.impl

import me.zhiq.chat.tool.interfaces.INetworkInterface

/**
 *
 * @author zhangzhiquan
 * @email zhangzhiquan.0707@bytedance.com
 * @since 2023/3/2 19:41
 */

class DefaultNetworkImpl: INetworkInterface {

    override fun sendRequest(
        url: String,
        method: INetworkInterface.METHOD,
        body: Map<String, String>
    ) {
        TODO("Not yet implemented")
    }
}