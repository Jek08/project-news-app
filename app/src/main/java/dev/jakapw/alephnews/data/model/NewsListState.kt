package dev.jakapw.alephnews.data.model

data class NewsListState(
    val newsList: MutableList<Article> = mutableListOf()
)
