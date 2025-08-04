package com.robustdev.samplecomposeapp.utils

import com.robustdev.samplecomposeapp.model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<Post>
}