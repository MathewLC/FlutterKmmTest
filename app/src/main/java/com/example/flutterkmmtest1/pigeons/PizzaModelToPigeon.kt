package com.example.flutterkmmtest1.pigeons

import com.example.domain.models.PizzaModel

fun PizzaModel.toPigeon() : PizzaPigeon.Pizza =
    PizzaPigeon.Pizza.Builder()
        .setName(this.name)
        .setId(this.id.toLong())
        .build()
