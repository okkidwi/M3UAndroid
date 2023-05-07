package com.m3u.androidApp.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.m3u.androidApp.components.BottomNavigationSheet
import com.m3u.androidApp.components.OptimizeBanner
import com.m3u.androidApp.components.PostDialog
import com.m3u.androidApp.components.PostDialogStatus
import com.m3u.androidApp.navigation.Destination
import com.m3u.androidApp.navigation.M3UNavHost
import com.m3u.androidApp.navigation.notDestinationTo
import com.m3u.androidApp.navigation.safeDestinationTo
import com.m3u.data.database.entity.Post
import com.m3u.ui.components.AppTopBar
import com.m3u.ui.components.Background
import com.m3u.ui.components.IconButton

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun App(
    appState: AppState = rememberAppState(),
    viewModel: RootViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val posts by viewModel.posts.collectAsStateWithLifecycle()
    val post = state.post
    val onPost: (Post?) -> Unit = { viewModel.onEvent(RootEvent.OnPost(it)) }

    val topLevelDestinations = appState.topLevelDestinations
    val currentDestination = appState.currentComposableNavDestination
    val currentTopLevelDestination = appState.currentComposableTopLevelDestination
    val currentTopLevelDestinationTitle = currentTopLevelDestination
        ?.titleTextId
        ?.let { stringResource(it) }
    val title by viewModel.title.collectAsStateWithLifecycle()
    val text by remember(currentTopLevelDestinationTitle) {
        derivedStateOf { currentTopLevelDestinationTitle ?: title }
    }
    var postDialogStatus = remember(post, posts) {
        if (post == null || post.temporal) PostDialogStatus.Idle
        else {
            val index = posts.indexOf(post)
            val total = posts.size
            if (index != -1 && total > 0) {
                PostDialogStatus.Visible(
                    post = post,
                    index = index,
                    total = total
                )
            } else {
                onPost(null)
                PostDialogStatus.Idle
            }
        }
    }
    val isSystemBarVisible =
        currentDestination notDestinationTo Destination.Live::class.java &&
                currentDestination notDestinationTo Destination.LivePlayList::class.java
    val isBackPressedVisible = currentDestination.safeDestinationTo<Destination.Root>(true)

    LaunchedEffect(Unit) {
        viewModel.onEvent(RootEvent.OnInitialTab)
    }
    LaunchedEffect(state.navigateTopLevelDestination) {
        state.navigateTopLevelDestination.handle {
            appState.navigateToTopLevelDestination(it)
        }
    }
    Background {
        AppTopBar(
            text = text,
            visible = isSystemBarVisible,
            scrollable = currentDestination notDestinationTo Destination.Root::class.java,
            actions = {
                val actions by viewModel.actions.collectAsStateWithLifecycle()
                actions.forEach { action ->
                    IconButton(
                        icon = action.icon,
                        contentDescription = action.contentDescription,
                        onClick = action.onClick
                    )
                }
            },
            onBackPressed = if (isBackPressedVisible) null else appState::onBackClick
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                M3UNavHost(
                    navController = appState.navController,
                    pagerState = appState.pagerState,
                    destinations = topLevelDestinations,
                    navigateToDestination = appState::navigateToDestination,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                AnimatedVisibility(isSystemBarVisible) {
                    Column {
                        OptimizeBanner(
                            post = posts.firstOrNull(),
                            onPost = onPost,
                            modifier = Modifier.fillMaxWidth()
                        )
                        BottomNavigationSheet(
                            destinations = topLevelDestinations,
                            currentTopLevelDestination = currentTopLevelDestination,
                            navigateToTopLevelDestination = appState::navigateToTopLevelDestination,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
        PostDialog(
            status = postDialogStatus,
            onDismiss = { onPost(null) },
            onNext = { viewModel.onEvent(RootEvent.OnNext) },
            onPrevious = { viewModel.onEvent(RootEvent.OnPrevious) },
            onRead = { viewModel.onEvent(RootEvent.OnRead) }
        )
        BackHandler(postDialogStatus != PostDialogStatus.Idle) {
            postDialogStatus = PostDialogStatus.Idle
        }
    }
}

