package dev.jakapw.alephnews.compose.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.jakapw.alephnews.data.model.Article
import dev.jakapw.alephnews.ui.theme.AppTheme

@Composable
fun TopHeadline(
    headlines: List<Article>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        LazyRow(
            modifier = Modifier
                .padding(top = AppTheme.size.paddingSmall)
        ) {
            if (headlines.isNotEmpty()) {
                items(headlines.subList(1, headlines.size)) {article ->
                    NewsCard(
                        imgUrl = article.urlToImage,
                        newsTitle = article.title,
                        newsPublisher = article.source.name,
                        newsDate = article.publishedAt,
                        modifier = Modifier.padding(AppTheme.size.paddingSmall).fillParentMaxWidth(0.5f)
                    )
                }
            }
        }
    }
}