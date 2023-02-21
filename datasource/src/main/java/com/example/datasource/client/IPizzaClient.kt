package com.example.datasource.client

import com.example.datasource.dto.PizzaDto
import retrofit2.http.GET

interface IPizzaClient {
    @GET("/pizzas/getPizzas/")
    suspend fun getPizzas() : List<PizzaDto>
}