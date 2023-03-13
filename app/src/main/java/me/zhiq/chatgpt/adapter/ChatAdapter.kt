package me.zhiq.chatgpt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.zhiq.chatgpt.R
import me.zhiq.chatgpt.model.ChatMessage
import me.zhiq.chatgpt.model.Role

/**
 *
 * @author Fish
 * @email kingsfish95@gmail.com
 * @since 2023/3/14 0:38
 */
class ChatAdapter: RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    private val dataLists = mutableListOf<ChatMessage>()


    class ChatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val content: TextView = itemView.findViewById(R.id.content)
        val header: ImageView = itemView.findViewById(R.id.header)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_view_chat, parent, false)
        return ChatViewHolder(v)
    }

    override fun getItemCount() = dataLists.size

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chatMsg = dataLists[position]
        holder.content.text = chatMsg.msg
        when (chatMsg.role) {
            Role.AI -> holder.header.setImageResource(R.mipmap.ic_launcher_round)
            Role.USER -> holder.header.setImageResource(R.mipmap.ic_launcher_round)
        }
    }

    fun updateData(lists: ChatMessage) {
        dataLists.add(lists)
        notifyItemChanged(dataLists.size - 1)
    }
}