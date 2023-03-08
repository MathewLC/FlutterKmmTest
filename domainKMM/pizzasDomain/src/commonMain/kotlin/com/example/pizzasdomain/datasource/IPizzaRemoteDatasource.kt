package com.example.pizzasdomain.datasource

import com.example.pizzasdomain.models.PizzaModel

interface IPizzaRemoteDatasource {
    suspend fun getListOf(): List<PizzaModel>
}