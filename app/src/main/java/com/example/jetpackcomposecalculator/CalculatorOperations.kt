package com.example.jetpackcomposecalculator

sealed class CalculatorOperations(val symbols : String){
    object Add : CalculatorOperations("+")
    object Subtract : CalculatorOperations("-")
    object Multiply : CalculatorOperations("*")
    object Devide : CalculatorOperations("/")

}
