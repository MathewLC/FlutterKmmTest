package com.example.domain.repository

import com.example.domain.models.PizzaDetailsModel
import com.example.domain.models.PizzaModel

interface IPizzaRepository {
    suspend fun getListOf() : List<PizzaModel>
    suspend fun getIngredientsById(id: String): PizzaDetailsModel
}