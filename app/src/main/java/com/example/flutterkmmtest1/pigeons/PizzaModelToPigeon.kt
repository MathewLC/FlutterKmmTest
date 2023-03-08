package com.example.flutterkmmtest1.pigeons

import com.example.pizzasdomain.models.PizzaModel

fun com.example.pizzasdomain.models.PizzaModel.toPigeon() : PizzaPigeon.Pizza =
    PizzaPigeon.Pizza.Builder()
        .setName(this.name)
        .setId(this.id.toLong())
        .build()
