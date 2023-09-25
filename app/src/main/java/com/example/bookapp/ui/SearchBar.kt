@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.bookapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ContentAlpha
import com.example.bookapp.R


@Composable
fun MainAppBar(
    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onTextChanged: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchedClicked: (String) -> Unit,
    onSearchedTriggered: () -> Unit
) {

    when (searchWidgetState) {
        SearchWidgetState.CLOSED -> {
            ClosedAppBar(
                onSearchedClicked = onSearchedTriggered
            )
        }

        SearchWidgetState.OPENED -> {
            OpenedAppBar(
                text = searchTextState,
                onTextChanged = onTextChanged,
                onCloseClicked = onCloseClicked,
                onSearchedClicked = onSearchedClicked
            )
        }
    }
}

@Composable
fun ClosedAppBar(onSearchedClicked: () -> Unit) {
    TopAppBar(
        title = {
        Text(
            text = stringResource(id = R.string.app_name)
        )
    },
        actions = {
            IconButton(
                onClick = { onSearchedClicked() })
            {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "SearchIcon",
                    tint = Color.Black
                )
            }
        }
    )
}


@Composable
fun OpenedAppBar(
    text: String,
    onTextChanged: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchedClicked: (String) -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .height(56.dp),
        color = MaterialTheme.colorScheme.primary
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            onValueChange = { onTextChanged(it) },
            placeholder = {
                Text(
                    modifier = Modifier,
                    text = "Search here...",
                    color = Color.White
                )
            },
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    onClick = { onSearchedClicked(text) }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon ",
                        tint = Color.Black,
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    if (text.isNotEmpty()) {
                        onTextChanged("")
                    } else {
                        onCloseClicked()
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Icon",
                        tint = Color.Black
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchedClicked(text)
                }
            )
        )

    }
}



















