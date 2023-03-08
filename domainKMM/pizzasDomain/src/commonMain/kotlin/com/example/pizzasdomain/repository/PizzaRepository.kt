package com.example.pizzasdomain.repository

import com.example.pizzasdomain.datasource.IPizzaRemoteDatasource
import com.example.pizzasdomain.models.PizzaDetailsModel
import com.example.pizzasdomain.models.PizzaModel

class PizzaRepository (
    private val pizzaRemoteDatasource : IPizzaRemoteDatasource
): IPizzaRepository {
    override suspend fun getListOf(): List<PizzaModel> {
        return pizzaRemoteDatasource.getListOf()
    }

    override suspend fun getIngredientsById(id: String): PizzaDetailsModel {
        TODO("Not yet implemented")
    }
}