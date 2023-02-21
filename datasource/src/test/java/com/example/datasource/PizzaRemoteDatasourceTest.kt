package com.example.datasource

import com.example.datasource.client.IPizzaClient
import com.example.datasource.datasource.PizzaRemoteDatasource
import com.example.datasource.dto.PizzaDto
import com.example.datasource.dto.toModelList
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class PizzaRemoteDatasourceTest {
    @Test
    fun `get list of pizzas should return list of pizza`() = runBlocking {
        val mock = mock<IPizzaClient>()
        val pizzaList = listOf(
            PizzaDto("4 queijos",1), PizzaDto("Calabresa",2)
        )

        whenever(mock.getPizzas()).thenReturn(pizzaList)
        val datasource = PizzaRemoteDatasource(mock)
        assertEquals(
            datasource.getListOf(),
            pizzaList.toModelList()
        )
    }
}