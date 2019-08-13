package com.chuppa.iotta.tempapp.domain.wrapper

interface HoochwoJsWrapper {
    fun initialize(sourceCode: String)
    fun sendEvent(script: String)
    fun registerForCommands(callback: (command: String) -> Unit)
}