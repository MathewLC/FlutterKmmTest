package com.example.flutterkmmtest1.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.PizzaModel
import com.example.domain.repository.IPizzaRepository
import com.example.flutterkmmtest1.pigeons.PizzaPigeon
import com.example.flutterkmmtest1.pigeons.toPigeon
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class Page2ViewModel(
    private val repository: IPizzaRepository
) : ViewModel(), PizzaPigeon.PizzaHostApi  {

    override fun getPizzas(result: PizzaPigeon.Result<MutableList<PizzaPigeon.Pizza>>?) {
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