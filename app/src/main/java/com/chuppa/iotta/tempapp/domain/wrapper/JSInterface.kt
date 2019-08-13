package com.chuppa.iotta.tempapp.domain.wrapper

import org.liquidplayer.javascript.JSException
import org.liquidplayer.javascript.JSObject

/**
 * JS interface
 */
interface JSInterface {

    @Throws(JSException::class)
    fun executeAppCoreCommand(jsCommand: JSObject)
}
