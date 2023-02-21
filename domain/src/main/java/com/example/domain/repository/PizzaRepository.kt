package com.example.domain.repository

import com.example.domain.datasource.IPizzaRemoteDatasource
import com.example.domain.models.PizzaDetailsModel
import com.example.domain.models.PizzaModel

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