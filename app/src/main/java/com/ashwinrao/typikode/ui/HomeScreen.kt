package com.ashwinrao.typikode.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ashwinrao.typikode.network.model.Post

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    posts: List<Post>
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        PostList(posts)
    }
}