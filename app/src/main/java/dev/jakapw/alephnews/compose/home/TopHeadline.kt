package dev.jakapw.alephnews.compose.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.jakapw.alephnews.ui.theme.AppTheme

@Composable
fun TopHeadline(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Top Headlines",
            style = AppTheme.typography.titleLarge
        )
        LazyRow(
            modifier = Modifier
                .padding(top = AppTheme.size.paddingSmall)
        ) {
            items(3) {
                NewsCard(
                    imgUrl = "https://www.shrm.org/content/dam/en/shrm/topics-tools/news/employee-relations/iStock-175426710_dteiyx.jpeg",
                    newsTitle = "Why Companies\n" +
                            "Should Be More Concerned \n" +
                            "About The Environtment",
                    newsPublisher = "Reuters",
                    newsDate = "4/5/2024",
                    modifier = Modifier.padding(AppTheme.size.paddingSmall)
                )
            }
        }
    }
}