package com.chuppa.iotta.tempapp.dependency

import com.chuppa.iotta.app.model.utils.AppSchedulerProvider
import com.chuppa.iotta.app.model.utils.SchedulerProvider
import com.chuppa.iotta.tempapp.domain.network.ApiService
import org.koin.dsl.module


val appModule = module {
    single { AppSchedulerProvider() as SchedulerProvider }
}

val networkModule = module {
    factory { ApiService.create() }
}
