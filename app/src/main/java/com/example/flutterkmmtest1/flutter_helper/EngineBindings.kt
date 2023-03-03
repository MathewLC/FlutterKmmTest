package com.example.flutterkmmtest1.flutter_helper

import android.app.Activity
import com.example.flutterkmmtest1.Application
import io.flutter.FlutterInjector
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor

class EngineBindings(activity: Activity, entrypoint: String) {
    val engine: FlutterEngine

    init {
        val app = activity.applicationContext as Application
        val dartEntrypoint =
            DartExecutor.DartEntrypoint(
                FlutterInjector.instance().flutterLoader().findAppBundlePath(), entrypoint
            )
        engine = app.engines.createAndRunEngine(activity, dartEntrypoint)
    }
}