package com.example.bookapp.data

import com.example.bookshelf.BookShelf
import com.lembergsolutions.retrofitretry.api.RetryOnError
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksService {
    @GET("volumes")
    suspend fun bookSearch(
        @Query("q") searchQuery: String,
        @Query("maxResults") maxResults: Int
    ): BookShelf

    interface ApiInterface {
        @RetryOnError
        @GET("/news")
        suspend fun fetchNews(): Response<BookShelf>
    }
}