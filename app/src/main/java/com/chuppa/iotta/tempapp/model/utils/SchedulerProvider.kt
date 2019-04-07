package com.chuppa.iotta.app.model.utils

import io.reactivex.Scheduler

/**
 * Scheduler Provider interface for dagger.
 */
interface SchedulerProvider {

    fun mainThread(): Scheduler

    fun backgroundThread(): Scheduler

    fun someSpecificThread(): Scheduler
}
