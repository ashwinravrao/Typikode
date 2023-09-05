package com.ashwinrao.typikode.domain

import com.ashwinrao.typikode.data.TypicodeRepository
import com.ashwinrao.typikode.network.model.Post
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchPostsUseCase @Inject constructor(
    private val repository: TypicodeRepository
) {
    suspend operator fun invoke(): Flow<List<Post>> =
        repository.fetchPosts()
}