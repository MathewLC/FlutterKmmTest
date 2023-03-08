package com.example.datasource.datasource

import com.example.datasource.client.IPizzaClient
import com.example.datasource.dto.toModelList
import com.example.pizzasdomain.datasource.IPizzaRemoteDatasource
import com.example.pizzasdomain.models.PizzaModel

class PizzaRemoteDatasource(private val pizzaClient: IPizzaClient) :
    IPizzaRemoteDatasource {
    override suspend fun getListOf(): List<PizzaModel> {
        return pizzaClient.getPizzas().toModelList()
    }
}
