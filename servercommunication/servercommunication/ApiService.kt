package com.souravpalitrana.androiduicomponents.servercommunication

import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getAllPost(): List<Post>
}