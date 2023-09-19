package com.example.bookapp

import android.app.Application
import com.example.bookapp.data.AppContainer
import com.example.bookapp.data.DefaultAppContainer

class BooksApplication : Application() {
    lateinit var container:AppContainer
    override fun onCreate() {
        super.onCreate()
        container=DefaultAppContainer()
    }
}