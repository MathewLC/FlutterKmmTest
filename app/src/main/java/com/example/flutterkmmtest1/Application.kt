package com.example.flutterkmmtest1

import com.example.datasource.DI.DatasourceDI
import com.example.domain.DI.DomainDI
import com.example.flutterkmmtest1.DI.AppDI
import org.koin.core.context.startKoin

class Application : android.app.Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(AppDI, DomainDI, DatasourceDI)
            )
        }
    }
}