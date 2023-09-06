package com.ashwinrao.typikode.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ashwinrao.typikode.ui.HomeScreen
import com.ashwinrao.typikode.ui.MainViewModel

const val homeNavigationRoute = "home_navigation_route"

fun NavGraphBuilder.homeScreen() {
    composable(route = homeNavigationRoute) {
        val viewModel: MainViewModel = hiltViewModel()
        val posts by viewModel.typicodePosts.collectAsStateWithLifecycle()

        posts?.let {
            HomeScreen(posts = it)
        }
    }
}
