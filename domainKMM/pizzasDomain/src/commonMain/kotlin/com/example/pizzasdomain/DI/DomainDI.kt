package com.example.pizzasdomain.DI

import com.example.pizzasdomain.repository.IPizzaRepository
import com.example.pizzasdomain.repository.PizzaRepository
import org.koin.dsl.module

val DomainDI = module {
    single<IPizzaRepository> { PizzaRepository(get()) }
}