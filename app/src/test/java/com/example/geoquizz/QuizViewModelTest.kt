package com.example.geoquizz

import org.junit.Assert.assertEquals
import org.junit.Test

class QuizViewModelTest {

    @Test
    fun `test first launch first item show`() {
        val viewModel = CustomViewModel.MyViewModel(
            Repository
                .Base()
        )
        val expected = true
        val actual = viewModel.getAnswer()
        assertEquals(expected, actual)
        assertEquals(R.string.questionOne,
            viewModel.getQuestion())
    }

    @Test
    fun `launch and click next`() {
        val viewModel = CustomViewModel.MyViewModel(
            Repository
                .Base()
        )
        viewModel.moveToNext()
        val expected = false
        val actual = viewModel.getAnswer()
        assertEquals(expected, actual)
        assertEquals(R.string.questionTwo,
            viewModel.getQuestion())
    }

}

