package dev.jakapw.alephnews.compose.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jakapw.alephnews.compose.common.AppBar
import dev.jakapw.alephnews.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

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
                Banner(
                    imgUrl = "https://www.aoc.gov/sites/default/files/styles/social_standard/public/2020-06/U.S._Capitol_Building_%402x.jpg.webp?itok=MIiyTtN1",
                    title = "Stock Prices Surge \n" +
                            "Amids The Fed Aggressive Action\n" +
                            "in Fighting Inflation ",
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
                    modifier = Modifier.padding(AppTheme.size.paddingSmall).fillMaxWidth()
                )
            }
            items(4) {
                NewsCard(
                    imgUrl = "https://sellerplex.com/wp-content/uploads/Amazon-Marketplace.jpg",
                    newsTitle = "Amazon to launch dedicated website for Ireland next year",
                    newsPublisher = "BBC",
                    newsDate = "10/5/2024",
                    modifier = Modifier.padding(AppTheme.size.paddingSmall)
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    AppTheme {
        HomeScreen()
    }
}