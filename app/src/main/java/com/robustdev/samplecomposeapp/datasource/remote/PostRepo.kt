package com.robustdev.samplecomposeapp.datasource.remote

import com.robustdev.samplecomposeapp.model.Post
import com.robustdev.samplecomposeapp.utils.ApiService
import javax.inject.Inject

interface PostRepo {
    suspend fun getPosts(): List<Post>
}

class PostRepository @Inject constructor(
    private val api: ApiService
) : PostRepo {
    override suspend fun getPosts(): List<Post> {
        return api.getPosts()
    }
}