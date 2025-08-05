package com.robustdev.samplecomposeapp.usecase

import com.robustdev.samplecomposeapp.datasource.remote.PostRepo
import com.robustdev.samplecomposeapp.model.Post
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repo: PostRepo
) {
    suspend operator fun invoke(): List<Post> = repo.getPosts()
}