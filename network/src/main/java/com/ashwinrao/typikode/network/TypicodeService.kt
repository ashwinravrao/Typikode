package com.ashwinrao.typikode.network

import com.ashwinrao.typikode.network.model.Post
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface TypicodeService {

    @GET("/posts")
    suspend fun fetchPosts(): List<Post>

}