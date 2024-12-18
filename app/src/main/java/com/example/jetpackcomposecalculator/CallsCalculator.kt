package com.example.jetpackcomposecalculator

sealed class CallsCalculator{
    data class Number(val Number : Int) : CallsCalculator()
    object Clear : CallsCalculator()
    object Delete : CallsCalculator()
    object Decimals : CallsCalculator()
    object Calculates : CallsCalculator()
    data class Operations(val operations: CalculatorOperations) : CallsCalculator()
}
