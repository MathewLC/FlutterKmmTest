package com.example.flutterkmmtest1.pigeons

fun com.example.pizzasdomain.models.PizzaModel.toPigeon() : Pigeon.Pizza =
    Pigeon.Pizza.Builder()
        .setName(this.name)
        .setId(this.id.toLong())
        .build()
