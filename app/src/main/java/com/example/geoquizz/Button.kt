package com.example.geoquizz

import android.content.Context
import android.widget.TextView
import android.widget.Toast

interface MyCustomButton {

    fun checkAnswer(userAnswer: Boolean): Boolean
    fun showToast(userAnswer: Boolean)
    fun updateQuestion(textView: TextView)

    abstract class ButtonAbs(
        private val viewModel: CustomViewModel,
        private val toast: MakeToast
    ) : MyCustomButton {

        override fun checkAnswer(userAnswer: Boolean) =
            userAnswer == viewModel.getAnswer()

        override fun showToast(userAnswer: Boolean) {
            if (checkAnswer(userAnswer)) {
                toast.makeToast(
                    "WIN!!!!!",
                    Toast.LENGTH_SHORT
                )
            } else {
                toast.makeToast(
                    "LOse!!!!!",
                    Toast.LENGTH_SHORT
                )
            }
        }

        override fun updateQuestion(textView: TextView) {
            val questionTextId = viewModel.getQuestion()
            textView.setText(questionTextId)
        }
    }

    class ButtonConcrete(
        private val viewModel: CustomViewModel,
        private val toast: MakeToast
    ) : ButtonAbs(viewModel, toast)
}

interface MakeToast {
    fun makeToast(message: String, duration: Int)

    class Base(
        private val context: Context
    ) : MakeToast {

        override fun makeToast(message: String, duration: Int) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT)
                .show()
        }
    }
}