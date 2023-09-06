package com.ashwinrao.typikode.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashwinrao.typikode.domain.FetchPostsUseCase
import com.ashwinrao.typikode.network.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchPostsUseCase: FetchPostsUseCase
) : ViewModel() {

    private val _typicodePosts: MutableStateFlow<List<Post>?> = MutableStateFlow(null)
    val typicodePosts: StateFlow<List<Post>?>
        get() {
            fetchPosts()
            return _typicodePosts.asStateFlow()
        }

    fun fetchPosts() {
        viewModelScope.launch {
            fetchPostsUseCase().collectLatest {
                _typicodePosts.emit(it)
            }
        }
    }

}