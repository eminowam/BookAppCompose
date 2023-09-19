package com.example.bookapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookapp.data.Book
import com.example.bookapp.ui.BooksUiState

@Composable
fun HomeScreen(
    booksUiState: BooksUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    onBookClicked:(Book) ->Unit

) {
    when (booksUiState) {
        is BooksUiState.Loading -> loadingScreen(modifier)
        is BooksUiState.Success -> BooksGridScreen(
            books = booksUiState.bookSearch,
            modifier = modifier,
            onBookClicked
        )
        is BooksUiState.Error -> ErrorScreen(retryAction = retryAction, modifier)
    }
}
