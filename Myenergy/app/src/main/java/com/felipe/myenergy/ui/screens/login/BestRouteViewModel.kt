package com.felipe.myenergy.ui.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felipe.myenergy.domain.GetBestRouteUseCase
import com.felipe.myenergy.domain.Car
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BestRouteViewModel(private val userCase: GetBestRouteUseCase) : ViewModel() {

    private val _startDestination = MutableLiveData<String>()
    val email: LiveData<String> = _startDestination

    private val _endDestination = MutableLiveData<String>()
    val password: LiveData<String> = _endDestination

    private val _car = MutableLiveData<Car>()
    val car: LiveData<Car> = _car

    fun paramsChanged(email: String, password: String) {
        _startDestination.value = email
        _endDestination.value = password
    }

    fun getBestRoute() = viewModelScope.launch(Dispatchers.IO) {
        val car = userCase.invoke(email.value!!, password.value!!)
        viewModelScope.launch(Dispatchers.Main) {
            _car.value = car
        }
    }
}