package com.example.operatorapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ClientView {

    private lateinit var clientNameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clientNameTextView = findViewById(R.id.clientNameTextView)

        handleIntent(ClientIntent.LoadClientData)
    }

    override fun render(clientState: ClientState) {
        clientNameTextView.text = clientState.clientName
        clientNameTextView.setTextColor(clientState.clientColor)
    }

    private fun handleIntent(intent: ClientIntent) {
        when (intent) {
            is ClientIntent.LoadClientData -> {
                val clientName = BuildConfig.CLIENT_NAME
                val clientColor = Color.parseColor(BuildConfig.CLIENT_COLOR)

                render(ClientState(clientName, clientColor))
            }
        }
    }
}