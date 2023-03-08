package com.example.flutterkmmtest1.pigeons

import com.example.pizzasdomain.repository.IPizzaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class PizzaHostApi(
    private val repository: com.example.pizzasdomain.repository.IPizzaRepository
) : PizzaPigeon.PizzaHostApi {
    override fun getPizzas(result: PizzaPigeon.Result<MutableList<PizzaPigeon.Pizza>>?) {

    }
}