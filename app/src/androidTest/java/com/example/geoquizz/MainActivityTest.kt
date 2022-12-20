package com.example.geoquizz

import androidx.core.app.ActivityCompat.recreate
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        scenario = launch(MainActivity::class.java)
    }
    @Test
    fun show_first_question_on_launch() {
        onView(withId(R.id.question_text))
            .check(matches(withText(R.string.questionOne)))

    }

    @Test
    fun showsSecondQuestionAfterNextPress() {
        onView(withId(R.id.button_next))
            .perform(click())
        onView(withId(R.id.question_text))
            .check(matches(withText(R.string.questionTwo)))
    }

    @Test
    fun recreate_activity_after_death() {
        onView(withId(R.id.button_next))
            .perform(click())
        onView(withId(R.id.question_text))
            .check(matches(withText(R.string.questionTwo)))
        scenario.recreate()
        onView(withId(R.id.question_text))
            .check(matches(withText(R.string.questionTwo)))

    }

    @After
    fun tearDown() {
        scenario.close()
    }
}