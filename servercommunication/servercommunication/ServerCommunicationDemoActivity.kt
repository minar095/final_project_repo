package com.souravpalitrana.androiduicomponents.servercommunication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.souravpalitrana.androiduicomponents.R

class ServerCommunicationDemoActivity : AppCompatActivity() {
    private val postViewModel: PostViewModel by viewModels {
        PostViewModel.factory
    }
    private lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server_communication_demo)
        tvResult = findViewById(R.id.tvTitle)
        val observer = Observer<List<Post>>() { posts ->
            if (posts.isNotEmpty()) {
                tvResult.text = posts.first().title
            } else {
                tvResult.text = "No Data Found"
            }
        }
        postViewModel.posts.observe(this, observer)
        postViewModel.getAllPosts()
    }
}