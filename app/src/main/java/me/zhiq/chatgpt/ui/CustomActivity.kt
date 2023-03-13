package me.zhiq.chatgpt.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.zhiq.chatgpt.R
import me.zhiq.chatgpt.adapter.ChatAdapter
import me.zhiq.chatgpt.viewmodel.ChatViewModel

class CustomActivity : AppCompatActivity() {

    lateinit var rv: RecyclerView
    lateinit var edt: EditText
    lateinit var btn: Button

    private lateinit var viewModel: ChatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)
        viewModel = ViewModelProvider(this)[ChatViewModel::class.java]

        initRecyclerView()

        observeViewModel()

        edt = findViewById(R.id.edt)
        btn = findViewById(R.id.btn)

        btn.setOnClickListener {
            val text = edt.text.toString()
            if (text.isBlank()) return@setOnClickListener
            viewModel.sendRequest(text)
        }
    }

    private fun initRecyclerView() {
        rv = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv.adapter = ChatAdapter()
    }

    private fun observeViewModel() {
        lifecycleScope.launchWhenResumed {
            viewModel.chatData.collect {
                (rv.adapter as ChatAdapter).updateData(it)
            }
        }
    }
}