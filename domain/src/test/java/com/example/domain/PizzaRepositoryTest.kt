package com.example.domain

import com.example.pizzasdomain.datasource.IPizzaRemoteDatasource
import com.example.pizzasdomain.models.PizzaModel
import com.example.pizzasdomain.repository.PizzaRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class PizzaRepositoryTest {
    @Test
    fun `should return the list of pizzas`() = runBlocking {
        val pizzaDatasourceMock = mock<com.example.pizzasdomain.datasource.IPizzaRemoteDatasource>()
        val pizzaList = listOf(
            com.example.pizzasdomain.models.PizzaModel("4 queijos", 1),
            com.example.pizzasdomain.models.PizzaModel("Calabresa", 2)
        )
        whenever(pizzaDatasourceMock.getListOf())
            .thenReturn(pizzaList)
        val repository = com.example.pizzasdomain.repository.PizzaRepository(
            pizzaDatasourceMock
        )
        assertEquals(pizzaList, repository.getListOf())
    }
}