package com.felipe.myenergy.ui

sealed class Routes(val route: String) {
    data object Login:Routes("LOGIN")
    data object HouseEnergy:Routes("HOME")
}
