package com.example.operatorapplication

import android.graphics.Color
import org.junit.Assert.assertEquals
import org.junit.Test
import org.robolectric.RobolectricTestRunner
import org.junit.runner.RunWith

@RunWith(RobolectricTestRunner::class)
class ClientStateTest {

    @Test
    fun testClientStateCreation() {
        val clientColor = Color.parseColor("#FF5733")

        val red = Color.red(clientColor)
        val green = Color.green(clientColor)
        val blue = Color.blue(clientColor)
        val alpha = Color.alpha(clientColor)

        assertEquals(255, alpha)
        assertEquals(255, red)
        assertEquals(87, green)
        assertEquals(51, blue)
    }
}
