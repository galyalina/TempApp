package com.chuppa.iotta.tempapp.domain.wrapper

import com.chuppa.iotta.app.model.utils.SchedulerProvider
import org.liquidplayer.javascript.JSContext
import org.liquidplayer.javascript.JSObject
import timber.log.Timber

class HoochwoJsWrapperImpl(
        private val jsContext: JSContext = JSContext(),
        private val scheduler: SchedulerProvider
) : HoochwoJsWrapper,
        JSObject(jsContext, JSInterface::class.java),
        JSInterface {

    private var commandsCallback: (command: String) -> Unit = {}

    override fun initialize(sourceCode: String) {
        setExceptionHandler(JSContext.IJSExceptionHandler { jsException ->
            Timber.e(
                    jsException.cause,
                    "JS Exception - Message: " +
                            "${jsException?.message}\nStack: " +
                            "${jsException?.stack()}\nError: ${jsException?.error}"
            )
            jsException?.cause?.let { exception ->
                throw exception
            } ?: throw RuntimeException(jsException.message)
        })
        jsContext.evaluateScript(sourceCode)
    }

    private fun setExceptionHandler(exceptionHandler: JSContext.IJSExceptionHandler) {
        jsContext.setExceptionHandler(exceptionHandler)
    }

    override fun sendEvent(script: String) {
        jsContext.evaluateScript(script)
    }

    override fun executeAppCoreCommand(jsCommand: JSObject) {
        commandsCallback(jsCommand.toJSON())
    }

    override fun registerForCommands(callback: (command: String) -> Unit) {
        this.commandsCallback = callback
    }
}