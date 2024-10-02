package com.example.operatorapplication.intent

sealed class ClientIntent {
    object LoadClientData : ClientIntent()
}
