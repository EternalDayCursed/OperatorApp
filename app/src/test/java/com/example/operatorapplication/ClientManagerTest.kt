package com.example.operatorapplication

import android.graphics.Color
import com.example.operatorapplication.model.ClientManager
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
class ClientManagerTest {

    @Test
    fun testClientStateCreation() {
        val clientManager = ClientManager()
        val clientState = clientManager.getClientState()

        assertEquals(BuildConfig.CLIENT_NAME, clientState.clientName)
        val expectedColor = Color.parseColor(BuildConfig.CLIENT_COLOR)
        assertEquals(expectedColor, clientState.clientColor)
    }
}

