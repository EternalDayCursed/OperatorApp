package com.example.operatorapplication.model

import android.graphics.Color
import com.example.operatorapplication.BuildConfig

class ClientManager {

    fun getClientState(): ClientState {
        val clientName = BuildConfig.CLIENT_NAME
        val clientColor = Color.parseColor(BuildConfig.CLIENT_COLOR)
        return ClientState(clientName, clientColor)
    }
}