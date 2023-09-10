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
                val posts = listOf(
                    Post(
                        id = 0,
                        userId = 0,
                        title = "Ea debitis aperiam",
                        body = "Lorem ipsum dolor sit amet. Sed doloribus consectetur id rerum tenetur id odit natus qui voluptatibus nihil non provident illo? Sed quas molestiae quo nostrum consectetur et cumque iste.",
                    ),
                    Post(
                        id = 1,
                        userId = 1,
                        title = "Ea repellendus alias",
                        body = "Et sunt odio quo soluta dolorem aut reiciendis repellat a error sunt sit harum rerum et nulla itaque.",
                    ),
                    Post(
                        id = 2,
                        userId = 1,
                        title = "Aut quae tenetur",
                        body = "Nam voluptatem alias aut voluptatum ducimus id omnis fugit sed autem molestiae et veniam earum eos blanditiis mollitia.",
                    )
                )

                PostList(posts)
            }
        }
    }
}
