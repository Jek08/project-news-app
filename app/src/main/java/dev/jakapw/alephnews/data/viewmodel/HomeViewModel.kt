package dev.jakapw.alephnews.data.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dev.jakapw.alephnews.data.NewsApi
import dev.jakapw.alephnews.data.model.Article
import dev.jakapw.alephnews.data.model.NewsArticles
import dev.jakapw.alephnews.data.model.NewsListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Objects

class HomeViewModel : ViewModel() {

    // dev only
    private val APIKEY = "1e468240adc342e5bbdeb122db5881e4"

    val newsApi: NewsApi = NewsApi.service
    private val _topHeadlines: MutableStateFlow<List<Article>> by lazy {
        MutableStateFlow(NewsListState().newsList)
    }
    val topHeadlines: StateFlow<List<Article>> = _topHeadlines.asStateFlow()

    fun updateTopHeadlines() {
        newsApi.getTopHeadlines(apiKey = APIKEY)
            .enqueue(object : Callback<NewsArticles> {
                override fun onResponse(p0: Call<NewsArticles>, p1: Response<NewsArticles>) {
                    _topHeadlines.value = p1.body()?.articles.orEmpty()
                }
                override fun onFailure(p0: Call<NewsArticles>, p1: Throwable) {
                    Log.e("retrofit", p1.message.orEmpty())
                    Log.e("retrofit", p1.stackTrace.contentDeepToString())
                }
            })
    }

    companion object {
        val instance: HomeViewModel by lazy {
            HomeViewModel()
        }
    }
}