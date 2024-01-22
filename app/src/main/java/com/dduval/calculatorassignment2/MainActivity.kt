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
    private var currentOperator: String? = null
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
        buttonText == "=" -> performCalculation()
        else -> setOperator(buttonText)
    }

}

}