package com.ashwinrao.typikode.data

import com.ashwinrao.typikode.network.TypicodeService
import com.ashwinrao.typikode.network.model.Post
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TypicodeRepository @Inject constructor(
    private val service: TypicodeService
) {

    suspend fun fetchPosts(): Flow<List<Post>> = service.fetchPosts()

}
