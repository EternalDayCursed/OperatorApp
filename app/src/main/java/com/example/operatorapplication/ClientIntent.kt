package com.example.operatorapplication

sealed class ClientIntent {
    object LoadClientData : ClientIntent()
}
