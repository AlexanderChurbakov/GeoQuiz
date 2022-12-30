package com.example.geoquizz

import android.content.Context
import android.widget.Toast

interface TrueFalseButtons {

    fun checkAnswer()

    abstract class Abstract(
        private val context: Context,
        private val toast: ShowToast
    ) : TrueFalseButtons {
        override fun checkAnswer() {
            toast.showToast()
        }
        class TrueButton(
            private val context: Context
        ) : Abstract(context, ShowToast.WinToast(context))

        class FalseButton(
            private val context: Context
        ) : Abstract(context, ShowToast.LoseToast(context))
    }
}

interface ShowToast {

    fun showToast()

    abstract class Abstract(
        private val context: Context,
        private val message: String,
        private val duration: Int
    ) : ShowToast {
        override fun showToast() {
            Toast.makeText(context, message, duration)
                .show()
        }
    }

    class WinToast(
        private val context: Context
    ) : Abstract(context, "WIN!", Toast.LENGTH_SHORT)

    class LoseToast(
        private val context: Context
    ) : Abstract(context, "LOSE!", Toast.LENGTH_SHORT)
}