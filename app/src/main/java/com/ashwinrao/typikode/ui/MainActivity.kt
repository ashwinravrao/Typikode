package com.ashwinrao.typikode.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.ashwinrao.typikode.navigation.TypikodeNavigationHost
import com.ashwinrao.typikode.network.model.Post
import com.ashwinrao.typikode.ui.theme.TypikodeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TypikodeTheme {
                TypikodeNavigationHost()
            }
        }
    }
}

@Composable
fun PostList(
    posts: List<Post>
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(posts.size) { index ->
            PostRow(posts[index])
        }
    }
}

@Composable
fun PostRow(
    post: Post
) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Text(post.title)
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PHONE
)
@Composable
fun PostListPreview() {
    TypikodeTheme {
        Surface {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Greeting(name = "Android")
            }
        }
    }
}
