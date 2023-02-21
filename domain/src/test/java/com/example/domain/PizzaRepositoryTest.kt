package com.example.domain

import com.example.domain.datasource.IPizzaRemoteDatasource
import com.example.domain.models.PizzaModel
import com.example.domain.repository.PizzaRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class PizzaRepositoryTest {
    @Test
    fun `should return the list of pizzas`() = runBlocking {
        val pizzaDatasourceMock = mock<IPizzaRemoteDatasource>()
        val pizzaList = listOf(
            PizzaModel("4 queijos",1),PizzaModel("Calabresa",2)
        )
        whenever(pizzaDatasourceMock.getListOf())
            .thenReturn(pizzaList)
        val repository = PizzaRepository(
            pizzaDatasourceMock
        )
        assertEquals(pizzaList, repository.getListOf())
    }
}