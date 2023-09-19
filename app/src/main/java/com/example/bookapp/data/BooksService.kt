package com.example.bookapp.data

import com.example.bookshelf.BookShelf
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksService {
    @GET("volumes")
    suspend fun bookSearch(
        @Query("q") searchQuery: String,
        @Query("maxResults") maxResults: Int
    ): BookShelf
}