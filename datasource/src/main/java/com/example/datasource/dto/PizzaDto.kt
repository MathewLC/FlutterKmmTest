package com.example.datasource.dto

import com.example.domain.models.PizzaModel

data class PizzaDto(
    val name: String,
    val id: Int
)

fun PizzaDto.toModel() = PizzaModel(
    name,
    id
)

fun List<PizzaDto>.toModelList() =
    this.map { dto -> dto.toModel() }