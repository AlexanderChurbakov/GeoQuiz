package com.example.geoquizz

import android.util.Log

interface Logging{
    fun log(message: String)

    class Console(
        private val tag: String
    ): Logging{
        override fun log(message: String) {
            Log.d(tag, message)
        }
    }
}