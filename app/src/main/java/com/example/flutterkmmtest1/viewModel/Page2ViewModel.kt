package com.example.flutterkmmtest1.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flutterkmmtest1.pigeons.Pigeon
import com.example.pizzasdomain.repository.IPizzaRepository
import com.example.flutterkmmtest1.pigeons.toPigeon
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class Page2ViewModel(
    private val repository: IPizzaRepository
) : ViewModel(), Pigeon.PizzaHostApi  {

    override fun getPizzas(result: Pigeon.Result<MutableList<Pigeon.Pizza>>?) {
        viewModelScope.launch(IO) {
            try {
                result?.success(
                    repository.getListOf()
                        .map { it.toPigeon() }.toMutableList()
                )
            } catch(ex: Exception) {
                result?.error(ex)
            }
        }
    }
}