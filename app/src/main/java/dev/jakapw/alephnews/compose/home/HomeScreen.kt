package dev.jakapw.alephnews.compose.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.jakapw.alephnews.compose.common.CustomAppBar
import dev.jakapw.alephnews.data.model.HotTopics
import dev.jakapw.alephnews.data.viewmodel.HomeViewModel
import dev.jakapw.alephnews.ui.theme.AppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: HomeViewModel = HomeViewModel.instance
    val topHeadlines by viewModel.topHeadlines.collectAsState()
    val newsList by viewModel.newsList.collectAsState()

    var hotTopic by remember {
        mutableStateOf(HotTopics.topics[0])
    }

    viewModel.updateTopHeadlines()
    viewModel.updateNewsList(hotTopic, 4)

    Scaffold(
        topBar = { CustomAppBar() },
        modifier = modifier.padding(horizontal = AppTheme.size.paddingLarge)
    ) { innerPadding ->
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = modifier
                .padding(innerPadding)
        ) {
            item(span = StaggeredGridItemSpan.FullLine) {
                SearchNews(
                    onButtonClick = { hotTopic = it },
                    currentTopic = hotTopic
                )
            }
            item(span = StaggeredGridItemSpan.FullLine) {
                Divider(
                    thickness = 3.dp,
                    color = AppTheme.colorScheme.surface,
                    modifier = Modifier.padding(bottom = AppTheme.size.paddingLarge)
                )
            }
            item(span = StaggeredGridItemSpan.FullLine) {
                val article = topHeadlines.getOrNull(0)
                Banner(
                    imgUrl = article?.urlToImage ?: "",
                    title = article?.title ?: "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(AppTheme.shape.banner)
                )
            }
            item(span = StaggeredGridItemSpan.FullLine) {
                Spacer(modifier = Modifier.height(20.dp))
            }
            item(span = StaggeredGridItemSpan.FullLine) {
                Text(
                    text = "Top Headlines",
                    style = AppTheme.typography.titleLarge,
                    modifier = Modifier.padding(AppTheme.size.paddingSmall)
                )
            }
            item(span = StaggeredGridItemSpan.FullLine) {
                TopHeadline(
                    topHeadlines,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }
            item(span = StaggeredGridItemSpan.FullLine) {
                Spacer(modifier = Modifier.height(20.dp))
            }
            item(span = StaggeredGridItemSpan.FullLine) {
                Text(
                    text = "News This Month",
                    style = AppTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(AppTheme.size.paddingSmall)
                        .fillMaxWidth()
                )
            }
            if (newsList.isNotEmpty()) {
                items(newsList) { news ->
                    NewsCard(
                        imgUrl = news.urlToImage,
                        newsTitle = news.title,
                        newsPublisher = news.source.name,
                        newsDate = news.publishedAt,
                        modifier = Modifier.padding(AppTheme.size.paddingSmall)
                    )
                }
            }
        }
    }
}