package com.example.operatorapplication.model

data class ClientState(
    val clientName: String,
    val clientColor: Int,
    val latitude: Double? = null,
    val longitude: Double? = null
)
