package com.chuppa.iotta.tempapp.domain.wrapper

import android.content.Context
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import timber.log.Timber

/**
 * Javascript wrapper Helper class
 */
class WrapperHelperImpl(
        private val context: Context,
        private val dmJsWrapper: HoochwoJsWrapper
) : WrapperHelper {

    private val jsCommands: PublishSubject<String> = PublishSubject.create()
    override fun commandsAsObservable(): Observable<String> = jsCommands.hide()

    override fun initialize() {
        val sourceCode = context.assets.open("sample.html").toString()
        dmJsWrapper.initialize(sourceCode)
        dmJsWrapper.registerForCommands { command ->
            jsCommands.onNext(command)
        }
    }

    override fun sendEvent(eventJson: String) {
        Timber.i(eventJson)
        // dmJsWrapper.sendEvent("handleAppCoreEvent($eventJson)")
    }

}
