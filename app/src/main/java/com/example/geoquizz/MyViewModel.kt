package com.example.geoquizz

import androidx.lifecycle.ViewModel

interface CustomViewModel {

    fun getQuestion(): Int
    fun getAnswer(): Boolean
    fun moveToNext()

    class MyViewModel(
        private val repository: Repository,
    ) : ViewModel(), CustomViewModel {

        override fun getQuestion(): Int {
            return repository.getQuestion()
        }

        override fun getAnswer(): Boolean {
            return repository.getAnswer()
        }

        override fun moveToNext() = repository.moveToNext()
    }
}