package com.chuppa.iotta.tempapp.domain.wrapper

import io.reactivex.Observable

interface WrapperHelper {
    fun initialize()
    fun commandsAsObservable(): Observable<String>
    fun sendEvent(eventJson: String)
}