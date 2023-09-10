package com.ashwinrao.typikode.data

import com.ashwinrao.typikode.network.TypicodeService
import com.ashwinrao.typikode.network.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TypikodeRepository @Inject constructor(
    private val service: TypicodeService
) : TypikodePostRepository {

    override fun fetchPosts(): Flow<List<Post>> = flow {
        emit(service.fetchPosts())
    }

}

interface TypikodePostRepository {
    fun fetchPosts(): Flow<List<Post>>
}
