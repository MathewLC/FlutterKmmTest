package com.example.flutterkmmtest1

import com.example.datasource.DI.DatasourceDI
import com.example.domain.DI.DomainDI
import com.example.flutterkmmtest1.DI.AppDI
import io.flutter.embedding.engine.FlutterEngineGroup
import org.koin.core.context.startKoin

class Application : android.app.Application() {
    lateinit var engines : FlutterEngineGroup

    override fun onCreate() {
        super.onCreate()
        engines = FlutterEngineGroup(this)
        startKoin {
            modules(
                listOf(AppDI, DomainDI, DatasourceDI)
            )
        }
    }
}