package com.example.bookapp.data

import com.example.bookshelf.Items


interface BookRepository {
    suspend fun getBooks(query: String, maxResult: Int): List<Book>
}

class NetworkBooksRepository(
    private val bookService: BooksService
) : BookRepository {
    override suspend fun getBooks(
        query: String,
        maxResult: Int
    ): List<Book> =
        bookService.bookSearch(query, maxResult).items.map { items: Items ->
            Book(
                title = items.volumeInfo?.title,
                previewLink = items.volumeInfo?.previewLink,
                imageLink = items.volumeInfo?.imageLinks?.thumbnail
            )
        }
}