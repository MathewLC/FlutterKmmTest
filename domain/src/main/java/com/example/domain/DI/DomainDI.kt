package com.example.domain.DI

import com.example.domain.repository.IPizzaRepository
import com.example.domain.repository.PizzaRepository
import org.koin.dsl.module

val DomainDI = module {
    single<IPizzaRepository> { PizzaRepository(get()) }
}