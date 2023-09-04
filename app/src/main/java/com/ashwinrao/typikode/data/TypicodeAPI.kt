package com.ashwinrao.typikode.data

import com.ashwinrao.typikode.data.model.Post
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface TypicodeAPI {

    @GET("posts")
    fun fetchPosts(): Flow<List<Post>>

}