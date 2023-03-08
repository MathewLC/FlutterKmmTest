package com.example.datasource.dto

import com.example.pizzasdomain.models.PizzaModel

data class PizzaDto(
    val name: String,
    val id: Int
)

fun PizzaDto.toModel() = com.example.pizzasdomain.models.PizzaModel(
    name,
    id
)

fun List<PizzaDto>.toModelList() =
    this.map { dto -> dto.toModel() }