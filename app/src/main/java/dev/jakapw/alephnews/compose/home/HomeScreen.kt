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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jakapw.alephnews.compose.common.AppBar
import dev.jakapw.alephnews.data.model.Article
import dev.jakapw.alephnews.data.viewmodel.HomeViewModel
import dev.jakapw.alephnews.ui.theme.AppTheme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    modifier: Modifier = Modifier
) {
    val topHeadlines by viewModel.topHeadlines.collectAsState()
    val newsList = emptyList<Article>()

    Scaffold(
        topBar = { AppBar() },
        modifier = modifier.padding(horizontal = AppTheme.size.paddingLarge)
    ) { innerPadding ->
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = modifier
                .padding(innerPadding)
        ) {
            item(span = StaggeredGridItemSpan.FullLine) {
                SearchNews()
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
                    text = "News This Week",
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