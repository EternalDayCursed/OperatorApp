package com.example.operatorapplication.view

import com.example.operatorapplication.model.ClientState

interface ClientView {
    fun render(clientState: ClientState)
}
