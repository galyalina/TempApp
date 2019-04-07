package com.chuppa.iotta.app.model.utils

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Android Scheduler provided used by RxJava.
 */
class AppSchedulerProvider : SchedulerProvider {

    override fun mainThread(): Scheduler = AndroidSchedulers.mainThread()

    override fun backgroundThread(): Scheduler = Schedulers.io()

    override fun someSpecificThread(): Scheduler = specificScheduler

    companion object {
        private val specificScheduler: Scheduler by lazy { Schedulers.single() }
    }
}
