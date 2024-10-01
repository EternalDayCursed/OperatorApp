package com.example.operatorapplication

import android.graphics.Color
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.`is`
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testClientNameDisplayed() {
        onView(withId(R.id.clientNameTextView))
            .check(matches(isDisplayed()))
            .check(matches(withText(BuildConfig.CLIENT_NAME)))
    }

    @Test
    fun testClientColorDisplayed() {
        onView(withId(R.id.clientNameTextView))
            .check(matches(isDisplayed()))
            .check { view, _ ->
                val textView = view as TextView
                val expectedColor = Color.parseColor(BuildConfig.CLIENT_COLOR)
                assertThat(textView.currentTextColor, `is`(expectedColor))
            }
    }
}
