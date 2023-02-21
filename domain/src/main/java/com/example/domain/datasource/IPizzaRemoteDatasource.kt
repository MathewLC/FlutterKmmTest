package com.example.domain.datasource

import com.example.domain.models.PizzaModel

interface IPizzaRemoteDatasource {
    suspend fun getListOf(): List<PizzaModel>
}