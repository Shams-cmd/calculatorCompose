package com.example.jetpackcomposecalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    buttonSpace: Dp = 8.dp,
    onAction : (CallsCalculator) -> Unit
) {

    Box(modifier = Modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpace)
        ) {
            Text(
                text = state.number1 + (state.operations ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {

                CalculatorButtons(
                    symbole = "AC",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CallsCalculator.Clear)
                    })
                CalculatorButtons(
                    symbole = "Del",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Delete)
                    })
                CalculatorButtons(
                    symbole = "/",
                    modifier = Modifier
                        .background(Green)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Operations(CalculatorOperations.Devide))
                    })
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {

                CalculatorButtons(
                    symbole = "7",
                    modifier = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Number(7))
                    })

                CalculatorButtons(
                    symbole = "8",
                    modifier = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Number(8))
                    })

                CalculatorButtons(
                    symbole = "9",
                    modifier = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Number(9))
                    })
                CalculatorButtons(
                    symbole = "X",
                    modifier = Modifier
                        .background(Green)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Operations(CalculatorOperations.Multiply))
                    })

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {

                CalculatorButtons(
                    symbole = "4",
                    modifier = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Number(4))
                    })

                CalculatorButtons(
                    symbole = "5",
                    modifier = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Number(5))
                    })

                CalculatorButtons(
                    symbole = "6",
                    modifier = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Number(6))
                    })
                CalculatorButtons(
                    symbole = "-",
                    modifier = Modifier
                        .background(Green)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Operations(CalculatorOperations.Subtract))
                    })

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {

                CalculatorButtons(
                    symbole = "1",
                    modifier = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Number(1))
                    })

                CalculatorButtons(
                    symbole = "2",
                    modifier = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Number(2))
                    })

                CalculatorButtons(
                    symbole = "3",
                    modifier = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Number(3))
                    })
                CalculatorButtons(
                    symbole = "-",
                    modifier = Modifier
                        .background(Green)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Operations(CalculatorOperations.Add))
                    })

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {

                CalculatorButtons(
                    symbole = "0",
                    modifier = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Number(0))
                    })

                CalculatorButtons(
                    symbole = ".",
                    modifier = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Decimals)
                    })

                CalculatorButtons(
                    symbole = "=",
                    modifier = Modifier
                        .background(Green)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CallsCalculator.Calculates)
                    })


            }
        }
    }
}