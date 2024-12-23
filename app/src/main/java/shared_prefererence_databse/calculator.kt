package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var displayText: TextView
    private var currentNumber = ""
    private var operator = ""
    private var firstOperand = ""
    private var secondOperand = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayText = findViewById(R.id.displayText)

        // Button click listeners
        val buttons = listOf(
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", "×", "÷", "=", "C"
        )

        buttons.forEach { text ->
            findViewById<Button>(resources.getIdentifier("btn_$text", "id", packageName))?.setOnClickListener {
                onButtonClick(text)
            }
        }
    }

    private fun onButtonClick(input: String) {
        when (input) {
            "C" -> clear()
            "=" -> calculateResult()
            "+", "-", "×", "÷" -> setOperator(input)
            else -> appendNumber(input)
        }
    }

    private fun appendNumber(number: String) {
        currentNumber += number
        updateDisplay(currentNumber)
    }

    private fun setOperator(op: String) {
        if (currentNumber.isNotEmpty()) {
            firstOperand = currentNumber
            operator = op
            currentNumber = ""
        }
    }

    private fun calculateResult() {
        if (currentNumber.isNotEmpty() && firstOperand.isNotEmpty() && operator.isNotEmpty()) {
            secondOperand = currentNumber
            val result = when (operator) {
                "+" -> firstOperand.toDouble() + secondOperand.toDouble()
                "-" -> firstOperand.toDouble() - secondOperand.toDouble()
                "×" -> firstOperand.toDouble() * secondOperand.toDouble()
                "÷" -> firstOperand.toDouble() / secondOperand.toDouble()
                else -> 0.0
            }
            updateDisplay(result.toString())
            clearOperands()
        }
    }

    private fun clear() {
        clearOperands()
        updateDisplay("0")
    }

    private fun clearOperands() {
        currentNumber = ""
        operator = ""
        firstOperand = ""
        secondOperand = ""
    }

    private fun updateDisplay(value: String) {
        displayText.text = value
    }
}
