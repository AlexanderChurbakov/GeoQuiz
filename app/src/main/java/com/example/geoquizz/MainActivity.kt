package com.example.geoquizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

//big nerd android
class MainActivity : AppCompatActivity() {

    private lateinit var nextButton: Button
    private lateinit var questionText: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var quizViewModel: CustomViewModel
//    private lateinit var button: MyCustomButton
    private lateinit var button: TrueFalseButtons

    private val log: Logging = Logging.Console("chrb")
    private var answer = false
    private val trueButtonCheck = TrueFalseButtons.Abstract
        .TrueButton(this)
    private val falseButtonCheck = TrueFalseButtons.Abstract
        .FalseButton(this)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextButton = findViewById(R.id.button_next)
        questionText = findViewById(R.id.question_text)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        quizViewModel = (application as MyApplication).viewModel
//        button = MyCustomButton.ButtonConcrete(quizViewModel,
//            MakeToast.Base(this))

        val questionTextId = quizViewModel.getQuestion()
        questionText.setText(questionTextId)

        nextButton.setOnClickListener {
            quizViewModel.moveToNext()
//            button.updateQuestion(questionText)
        }

        trueButton.setOnClickListener {
//            answer = true
//            button.showToast(answer)
            trueButtonCheck.checkAnswer()
        }

        falseButton.setOnClickListener {
//            answer = false
//            button.showToast(answer)
                falseButtonCheck.checkAnswer()

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        log.log("pizdec")
    }
}
