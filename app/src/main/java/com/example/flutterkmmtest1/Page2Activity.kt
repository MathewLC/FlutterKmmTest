package com.example.flutterkmmtest1

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import com.example.flutterkmmtest1.flutter_helper.EngineBindings
import com.example.flutterkmmtest1.pigeons.PizzaPigeon
import com.example.flutterkmmtest1.viewModel.Page2ViewModel
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import org.koin.android.ext.android.get

class Page2Activity: FlutterActivity() {
    private val engineBindings: EngineBindings by lazy {
        EngineBindings(activity = this, entrypoint = "page2")
    }

    private val myViewModel = get<Page2ViewModel>()

    override fun provideFlutterEngine(context: Context): FlutterEngine {
        val engine = engineBindings.engine
        PizzaPigeon.PizzaHostApi.setup(engine.dartExecutor.binaryMessenger,myViewModel)
        return engine
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val engineId = 1 //Use an appropriate UUID in real apps
        val engine = provideFlutterEngine(this)

        FlutterEngineCache.getInstance().put(engineId.toString(), engine)

    }

}