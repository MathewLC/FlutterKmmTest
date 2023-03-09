package com.example.flutterkmmtest1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.core.content.ContextCompat.startActivity
import com.example.flutterkmmtest1.flutter_helper.EngineBindings
import com.example.flutterkmmtest1.pigeons.Pigeon
import com.example.flutterkmmtest1.viewModel.MainActivityViewModel
import com.example.flutterkmmtest1.viewModel.Page2ViewModel
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.plugin.common.BinaryMessenger
import org.koin.android.ext.android.get

class Page2Activity: FlutterActivity() {
    private val engineBindings: EngineBindings by lazy {
        EngineBindings(activity = this, entrypoint = "page2")
    }

    val page2viewModel = get<Page2ViewModel>()

    override fun provideFlutterEngine(context: Context): FlutterEngine {
        val engine = engineBindings.engine
        Pigeon.PizzaHostApi.setup(engine.dartExecutor.binaryMessenger,page2viewModel)
        Pigeon.PizzaNavigationApi.setup(engine.dartExecutor.binaryMessenger,PizzaNavigation(this))
        return engine
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val engineId = 1 //Use an appropriate UUID in real apps
        val engine = provideFlutterEngine(this)

        FlutterEngineCache.getInstance().put(engineId.toString(), engine)

    }

    private class PizzaNavigation(private val context: Context) :Pigeon.PizzaNavigationApi {
        override fun navigateToPage3(result: Pigeon.Result<Void>?) {
            startActivity(context, Intent(context,Page3Activity::class.java),null)
        }

    }

}