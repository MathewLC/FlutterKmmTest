package com.example.datasource.DI

import com.example.datasource.client.IPizzaClient
import com.example.datasource.datasource.PizzaRemoteDatasource
import com.example.domain.datasource.IPizzaRemoteDatasource
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val DatasourceDI = module {
    single<IPizzaClient> { retrofit().create(IPizzaClient::class.java) }
    single<IPizzaRemoteDatasource> { PizzaRemoteDatasource(get()) }
}

private fun retrofit(): Retrofit = Retrofit
    .Builder()
    .baseUrl("http://10.0.2.2:8080")
    .addConverterFactory(GsonConverterFactory.create())
    .build()