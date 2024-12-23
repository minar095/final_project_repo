package com.souravpalitrana.androiduicomponents.servercommunication

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostRepository {
    private val apiService: ApiService = RetrofitClient.apiService

    suspend fun getAllPosts(): List<Post> {
        return withContext(Dispatchers.IO) {
            apiService.getAllPost()
        }
    }
}