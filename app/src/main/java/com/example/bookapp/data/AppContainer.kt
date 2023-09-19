package com.example.bookapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
val booksRepository:BookRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://www.googleapis.com/books/v1/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: BooksService by lazy {
        retrofit.create(BooksService::class.java)
    }
    override val booksRepository: BookRepository by lazy {
        NetworkBooksRepository(retrofitService)
    }
}