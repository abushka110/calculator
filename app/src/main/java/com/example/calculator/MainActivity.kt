package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {

    private var tvInput: TextView? = null
    private var division: Button? = null
    private var multiplication: Button? = null
    private var lastNumeric: Boolean = false
    private var lastDot: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)

        division = findViewById(R.id.btnDivision)
        division?.setOnClickListener {
            tvInput?.append("/")
        }
        multiplication = findViewById(R.id.btnMultiplication)
        multiplication?.setOnClickListener {
            tvInput?.append("*")
        }
    }

    fun onDigit(view: View) {
        tvInput?.append((view as Button).text)
        lastNumeric = true
        lastDot = false
    }

    fun onClear (view: View) {
        tvInput?.text = ""
    }

    fun onDecimal(view: View) {
        if(lastNumeric && !lastDot) {
            tvInput?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view: View) {
        tvInput?.text?.let {
            if(lastNumeric && !isOperatorAdded(it.toString())) {
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }
    }

    fun onEqual(view: View) {
        if(lastNumeric) {
            var tvValue = tvInput?.text.toString()
            var prefix = ""
            try{
                if(tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }

                if(tvValue.contains("-")) {
                    val splitValue = tvValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if(prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    tvInput?.text = removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())
                } else if(tvValue.contains("+")) {
                    val splitValue = tvValue.split("+")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if(prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    tvInput?.text = removeZeroAfterDot((one.toDouble() + two.toDouble()).toString())
                } else if (tvValue.contains("/")) {
                    val splitValue = tvValue.split("/")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    tvInput?.text = removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())
                } else if (tvValue.contains("*")) {
                    val splitValue = tvValue.split("*")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    tvInput?.text = removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())
                }
            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }

    private fun removeZeroAfterDot(result: String): String {
        var value = result
        if(result.contains(".0"))
            value = result.substring(0, result.length - 2)

        return value
    }

    private fun isOperatorAdded(value: String): Boolean {
        return if(value.startsWith("-")) {
            false
        } else {
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
        }
    }
}