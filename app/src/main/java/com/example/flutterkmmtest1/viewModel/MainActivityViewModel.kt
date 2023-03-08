package com.example.flutterkmmtest1.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzasdomain.models.PizzaModel
import com.example.pizzasdomain.repository.IPizzaRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val repository: com.example.pizzasdomain.repository.IPizzaRepository
) : ViewModel() {
    private val _pizzaList: MutableLiveData<List<com.example.pizzasdomain.models.PizzaModel>> =
        MutableLiveData<List<com.example.pizzasdomain.models.PizzaModel>>()

    val pizzaList: LiveData<List<com.example.pizzasdomain.models.PizzaModel>>
        get() = _pizzaList

    init {
        viewModelScope.launch(IO){
            _pizzaList.postValue(
                repository.getListOf()
            )
        }
    }
}