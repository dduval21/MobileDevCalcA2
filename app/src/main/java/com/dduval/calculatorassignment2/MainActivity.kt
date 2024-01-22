package com.dduval.calculatorassignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    private lateinit var display: EditText
    private var currentInput = ""
    private var selectedOperator: String? = null
    private var operandOne: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.editTextDisplay)
    }
fun onButtonClick(view: View) {
    val button = view as Button
    val buttonText = button.text.toString()

    when {
        buttonText.isDigitsOnly() -> appendDigit(buttonText)
        buttonText == "C" -> clearDisplay()
        buttonText == "=" -> Calculate()
        else -> setOperator(buttonText)
    }

}
    private fun appendDigit(digit: String) {
        currentInput += digit
        updateDisplay()
    }

    private fun clearDisplay() {
        currentInput = ""
        operandOne = 0.0
        selectedOperator = null
    }

    private fun setOperator(operator: String) {
        if (selectedOperator == null ) {
            operandOne = currentInput.toDouble()
            currentInput = ""
            selectedOperator = operator
            updateDisplay()
        }
    }

    private fun Calculate() {
        if (selectedOperator != null) {
            val operandTwo = currentInput.toDouble()
            val result = when (selectedOperator) {
                "+" -> operandOne + operandTwo
                "-" -> operandOne - operandTwo
                else -> 0.0
            }
            currentInput = result.toString()
            operandOne = result
            selectedOperator = null
            updateDisplay()
        }
    }

    private fun updateDisplay() {
        display.setText(currentInput)
    }
}