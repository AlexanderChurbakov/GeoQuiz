package com.example.geoquizz

import androidx.annotation.StringRes

interface Repository {
    fun getAnswer(): Boolean
    fun getQuestion(): Int
    fun moveToNext()

    class Base(
    ) : Repository {

        private val questionBank = listOf<Question>(
            Question(R.string.questionOne, true),
            Question(R.string.questionTwo, false),
            Question(R.string.questionThree, true),
            Question(R.string.questionFour, false)
        )

        private var currentIndex: Int = 0

        private val currentAnswer: Boolean
            get() = questionBank[currentIndex].getAnswer()
        private val currentQuestion: Int
            get() = questionBank[currentIndex].getId()

        override fun getAnswer() = currentAnswer

        override fun moveToNext() {
            currentIndex = (currentIndex + 1) % questionBank.size
        }

        override fun getQuestion() = currentQuestion
    }
}

class Question(
    @StringRes private val questionId: Int,
    private val answer: Boolean
) {
    fun getId() = questionId
    fun getAnswer() = answer
}