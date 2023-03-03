package com.example.flutterkmmtest1.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.PizzaModel
import com.example.domain.repository.IPizzaRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val repository: IPizzaRepository
) : ViewModel() {
    private val _pizzaList: MutableLiveData<List<PizzaModel>> =
        MutableLiveData<List<PizzaModel>>()

    val pizzaList: LiveData<List<PizzaModel>>
        get() = _pizzaList

    init {
        viewModelScope.launch(IO){
//            _pizzaList.postValue(
//                repository.getListOf()
//            )
        }
    }
}