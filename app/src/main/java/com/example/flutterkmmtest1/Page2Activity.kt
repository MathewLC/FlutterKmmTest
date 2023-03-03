package com.example.flutterkmmtest1

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import com.example.flutterkmmtest1.flutter_helper.EngineBindings
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache

class Page2Activity: FlutterActivity() {
    private val engineBindings: EngineBindings by lazy {
        EngineBindings(activity = this, entrypoint = "page2")
    }

    override fun provideFlutterEngine(context: Context): FlutterEngine {
        return engineBindings.engine
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val engineId = 1 //Use an appropriate UUID in real apps
        val engine = provideFlutterEngine(this)

        FlutterEngineCache.getInstance().put(engineId.toString(), engine)


    }

}