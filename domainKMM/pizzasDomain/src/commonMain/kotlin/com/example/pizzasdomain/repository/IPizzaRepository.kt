package com.example.pizzasdomain.repository

import com.example.pizzasdomain.models.PizzaDetailsModel
import com.example.pizzasdomain.models.PizzaModel

interface IPizzaRepository {
    suspend fun getListOf() : List<PizzaModel>
    suspend fun getIngredientsById(id: String): PizzaDetailsModel
}