package com.example.jetpackcomposecalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set



    fun onAction(action: CallsCalculator){
        when(action){
            is CallsCalculator.Number -> enterNumber(action.Number)
            is CallsCalculator.Decimals -> enterDecimal()
            is CallsCalculator.Clear -> state = CalculatorState()
            is CallsCalculator.Operations -> enterOperation(action.operations)
            is CallsCalculator.Calculates -> performCalculation()
            is CallsCalculator.Delete -> performDelete()
        }
    }

    private fun performDelete() {
        when{
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operations !=null -> state = state.copy(
                operations = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 =  state.number1.dropLast(1)
            )
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 !=null && number2 !=null){
            val result = when(state.operations){
                is CalculatorOperations.Add -> number1 + number2
                is CalculatorOperations.Subtract-> number1 - number2
                is CalculatorOperations.Devide-> number1/number2
                is CalculatorOperations.Multiply->number1*number2
                null -> return
            }
            state = state.copy(
                number1=result.toString().take(15),
                number2 = "",
                operations = null

            )
        }
    }

    private fun enterOperation(operations: CalculatorOperations) {
       if (state.number1.isNotBlank()){
           state = state.copy(operations = operations)
       }
    }

    private fun enterDecimal() {
       if (state.operations==null && !state.number1.contains(".") && state.number1.isNotBlank()){
           state = state.copy(
               number1 = state.number1 + "."
           )
           return
       }

        if ( !state.number2.contains(".") && state.number2.isNotBlank()){
            state = state.copy(
                number1 = state.number2 + "."
            )
            return
        }
    }

    private fun enterNumber(number: Int) {
       if (state.operations==null){
           if (state.number1.length >= MAX_NUM_LENGTH){
               return
           }
           state = state.copy(
               number1 = state.number1 + number
           )
           return
       }
        if (state.number2.length >= MAX_NUM_LENGTH){
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }
    companion object{
        private const val MAX_NUM_LENGTH = 8
    }
}