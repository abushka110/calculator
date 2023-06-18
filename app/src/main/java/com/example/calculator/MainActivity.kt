package com.example.calculator

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNumZero = findViewById<Button>(R.id.btnZero)
        val btnNumOne = findViewById<Button>(R.id.btnOne)
        val btnNumTwo = findViewById<Button>(R.id.btnTwo)
        val btnNumThree = findViewById<Button>(R.id.btnThree)
        val btnNumFour = findViewById<Button>(R.id.btnFour)
        val btnNumFive = findViewById<Button>(R.id.btnFive)
        val btnNumSix = findViewById<Button>(R.id.btnSix)
        val btnNumSeven = findViewById<Button>(R.id.btnSeven)
        val btnNumEight = findViewById<Button>(R.id.btnEight)
        val btnNumNine = findViewById<Button>(R.id.btnNine)
        val btnDivision = findViewById<Button>(R.id.btnDivision)
        val btnMultiplication = findViewById<Button>(R.id.btnmultiplication)
        val btnSubtraction = findViewById<Button>(R.id.btnSubtraction)
        val btnAddition = findViewById<Button>(R.id.btnAddition)
        val btnEquation = findViewById<Button>(R.id.btnEquation)
        val btnClear = findViewById<Button>(R.id.btnClear)
    }


}