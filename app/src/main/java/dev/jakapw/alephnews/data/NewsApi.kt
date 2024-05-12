package dev.jakapw.alephnews.data

import dev.jakapw.alephnews.data.model.NewsArticles
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    abstract fun getTopHeadlines(
        @Query(value = "country") country: String = "us",
        @Query(value = "category") category: String = "business",
        @Query(value = "apiKey") apiKey: String,
        @Query(value = "pageSize") pageSize: Int = 10
    ) : Call<NewsArticles>

    @GET("everything")
    abstract fun getNewsByCategory(
        @Query(value = "apiKey") apiKey: String,
        @Query(value = "pageSize") pageSize: Int = 15,
        @Query(value = "q") searchQuery: String = "",
        @Query(value = "searchIn") searchIn: String = "title",
        @Query(value = "from") from: String,
        @Query(value = "to") to: String,
        @Query(value = "sortBy") sortBy: String = "publishedAt"
    ) : Call<NewsArticles>

    companion object {
        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val service: NewsApi by lazy {
            retrofit.create()
        }
    }
}