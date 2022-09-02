package com.example.calculatorapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.calculatorapp.databinding.ActivityMainBinding
import kotlin.concurrent.fixedRateTimer

private var ZERO = "0"
private var ONE = "1"
private var TWO = "2"
private var THREE = "3"
private var FOUR = "4"
private var FIVE = "5"
private var SIX = "6"
private var SEVEN = "7"
private var EIGHT = "8"
private var NINE = "9"
private var COMMA = "."
private var DIVIDE = 1
private var MULTIPLY = 2
private var SUBSTRACTION = 3
private var ADDITION = 4

private var TEXT_CONTENTS = "TextContent"

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var textViewArrayList : ArrayList<String>
    private var prevOperation = 0
    private var isNegative = false
    private var counter = 0
    private var operationFinished = true
    private var operation = 0
    private var firstNum = 0.0
    private var secondNum = 0.0
    private var isFirstNum = false
    private var changeOperation = false
    private var result = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        textViewArrayList = ArrayList()
        binding.textViewNumber.append(ZERO)
        textViewArrayList.add(ZERO)


        binding.textViewNumber.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                var text = binding.textViewNumber.text
                binding.textViewNumber.text = text.substring(0, text.length - 1);
            }
        })



        binding.zeroButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(isZero() == true && isTextViewFull() == false){
                    if(!operationFinished){
                        if(isFirstNum){
                            setColourForOperation(true, operation)
                            textViewArrayList.clear()
                            binding.textViewNumber.text = ""
                            textViewArrayList.add(ZERO)
                            addNumber(ZERO)
                            isFirstNum = false
                        }
                        else{
                            textViewArrayList.add(ZERO)
                            addNumber(ZERO)
                        }
                    }
                    else{
                        isAfterOperation(ZERO);
                    }
                }
            }
        })

        binding.oneButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(isTextViewFull() == false){
                    if(!operationFinished){
                        if(isFirstNum){
                            setColourForOperation(true, operation)
                            textViewArrayList.clear()
                            binding.textViewNumber.text = ""
                            textViewArrayList.add(ONE)
                            addNumber(ONE)
                            isFirstNum = false
                        }
                        else{
                            textViewArrayList.add(ONE)
                            addNumber(ONE)
                        }
                    }
                    else{
                        isAfterOperation(ONE)
                    }
                }
            }
        })

        binding.twoButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(isTextViewFull() == false){
                    if(!operationFinished){
                        if(isFirstNum){
                            setColourForOperation(true, operation)
                            textViewArrayList.clear()
                            binding.textViewNumber.text = ""
                            textViewArrayList.add(TWO)
                            addNumber(TWO)
                            isFirstNum = false
                        }
                        else{
                            textViewArrayList.add(TWO)
                            addNumber(TWO)
                        }
                    }
                    else{
                        isAfterOperation(TWO)
                    }
                }
            }
        })

        binding.threeButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(isTextViewFull() == false){
                    if(!operationFinished){
                        if(isFirstNum){
                            setColourForOperation(true, operation)
                            textViewArrayList.clear()
                            binding.textViewNumber.text = ""
                            textViewArrayList.add(THREE)
                            addNumber(THREE)
                            isFirstNum = false
                        }
                        else{
                            textViewArrayList.add(THREE)
                            addNumber(THREE)
                        }
                    }
                    else{
                        isAfterOperation(THREE)
                    }
                }
            }
        })

        binding.fourButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(isTextViewFull() == false){
                    if(!operationFinished){
                        if(isFirstNum){
                            setColourForOperation(true, operation)
                            textViewArrayList.clear()
                            binding.textViewNumber.text = ""
                            textViewArrayList.add(FOUR)
                            addNumber(FOUR)
                            isFirstNum = false
                        }
                        else{
                            textViewArrayList.add(FOUR)
                            addNumber(FOUR)
                        }
                    }
                    else{
                        isAfterOperation(FOUR)
                    }
                }
            }
        })

        binding.fiveButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(isTextViewFull() == false){
                    if(!operationFinished){
                        if(isFirstNum){
                            setColourForOperation(true, operation)
                            textViewArrayList.clear()
                            binding.textViewNumber.text = ""
                            textViewArrayList.add(FIVE)
                            addNumber(FIVE)
                            isFirstNum = false
                        }
                        else{
                            textViewArrayList.add(FIVE)
                            addNumber(FIVE)
                        }
                    }
                    else{
                        isAfterOperation(FIVE)
                    }
                }
            }
        })

        binding.sixButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(isTextViewFull() == false){
                    if(!operationFinished){
                        if(isFirstNum){
                            setColourForOperation(true, operation)
                            textViewArrayList.clear()
                            binding.textViewNumber.text = ""
                            textViewArrayList.add(SIX)
                            addNumber(SIX)
                            isFirstNum = false
                        }
                        else{
                            textViewArrayList.add(SIX)
                            addNumber(SIX)
                        }
                    }
                    else{
                        isAfterOperation(SIX)
                    }
                }
            }
        })

        binding.sevenButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(isTextViewFull() == false){
                    if(!operationFinished){
                        if(isFirstNum){
                            setColourForOperation(true, operation)
                            textViewArrayList.clear()
                            binding.textViewNumber.text = ""
                            textViewArrayList.add(SEVEN)
                            addNumber(SEVEN)
                            isFirstNum = false
                        }
                        else{
                            textViewArrayList.add(SEVEN)
                            addNumber(SEVEN)
                        }
                    }
                    else{
                        isAfterOperation(SEVEN)
                    }
                }
            }
        })

        binding.eightButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(isTextViewFull() == false){
                    if(!operationFinished){
                        if(isFirstNum){
                            setColourForOperation(true, operation)
                            binding.textViewNumber.text = ""
                            textViewArrayList.clear()
                            textViewArrayList.add(EIGHT)
                            addNumber(EIGHT)
                            isFirstNum = false
                        }
                        else{
                            textViewArrayList.add(EIGHT)
                            addNumber(EIGHT)
                        }
                    }
                    else{
                        isAfterOperation(EIGHT)
                    }
                }
            }
        })

        binding.nineButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(isTextViewFull() == false){
                    if(!operationFinished){
                        if(isFirstNum){
                            setColourForOperation(true, operation)
                            binding.textViewNumber.text = ""
                            textViewArrayList.clear()
                            textViewArrayList.add(NINE)
                            addNumber(NINE)
                            isFirstNum = false
                        }
                        else{
                            textViewArrayList.add(NINE)
                            addNumber(NINE)
                        }
                    }
                    else{
                        isAfterOperation(NINE)
                    }
                }
            }
        })

        binding.commaButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(isTextViewFull() == false){
                    if(!operationFinished){
                        if(isFirstNum){
                            setColourForOperation(true, operation)
                            binding.textViewNumber.text = ""
                            textViewArrayList.clear()
                            textViewArrayList.add(COMMA)
                            addNumber(COMMA)
                            isFirstNum = false
                        }
                        else{
                            textViewArrayList.add(COMMA)
                            addNumber(COMMA)
                        }
                    }
                    else{
                        isAfterOperation(COMMA)
                    }
                }
            }
        })

        binding.acButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                setAC()
            }
        })

        binding.signButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(!operationFinished){
                    binding.textViewNumber.text = ""
                    textViewArrayList.clear()
                    textViewArrayList.add(ZERO)
                    addNumber(ZERO)
                    binding.textViewNumber.text = "-${binding.textViewNumber.text}"
                    isNegative = true
                }
                else{
                    if(!isNegative){
                        binding.textViewNumber.text = "-${binding.textViewNumber.text}"
                        isNegative = true
                    }
                    else{
                        val text = binding.textViewNumber.text
                        binding.textViewNumber.text = text.substring(1, text.length);
                        isNegative = false
                    }
                }

            }
        })

        binding.takePercentageButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val number = binding.textViewNumber.text.toString()
                var intNumber = number.toDouble()
                intNumber /= 100.0
                binding.textViewNumber.text = intNumber.toString()
            }
        })

        binding.divideButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(operationFinished){
                    buttonOnClickForAll(binding.divideButton, DIVIDE)
                }
                else if(!operationFinished){
                    if(changeOperation && prevOperation != DIVIDE){
                        buttonOncClickChangeOperation(binding.divideButton, DIVIDE)
                    }
                    else{
                        processOperation()
                    }
                }
            }
        })

        binding.multiplierButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(operationFinished){
                     buttonOnClickForAll(binding.multiplierButton, MULTIPLY)
                }
                else if(!operationFinished){
                    if(changeOperation && prevOperation != MULTIPLY){
                        buttonOncClickChangeOperation(binding.multiplierButton, MULTIPLY)
                    }
                    else{
                        processOperation()
                    }
                }
            }
        })

        binding.substractionButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(operationFinished){
                    buttonOnClickForAll(binding.substractionButton, SUBSTRACTION)
                }
                else if(!operationFinished){
                    if(changeOperation && prevOperation != SUBSTRACTION){
                        buttonOncClickChangeOperation(binding.substractionButton, SUBSTRACTION)
                    }
                    else{
                        processOperation()
                    }
                }
            }
        })


        binding.additionButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(operationFinished){
                    buttonOnClickForAll(binding.additionButton, ADDITION)
                }
                else if(!operationFinished){
                    if(changeOperation && prevOperation != ADDITION){
                        buttonOncClickChangeOperation(binding.additionButton, ADDITION)
                    }
                    else{
                        processOperation()
                    }
                }
            }
        })

        binding.resultButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                resultOfOperation()
            }
        })

    }

    fun addNumber(number : String) {
        counter += 1
        if(isFirst()){
            binding.textViewNumber.text = number
            textViewArrayList.removeLast()
            textViewArrayList[0] =  number
        }
        else{
            binding.textViewNumber.append(number)
        }
    }


    fun isFirst() : Boolean{
        return textViewArrayList.size == 2 && textViewArrayList[0] == ZERO
    }

    fun isTextViewFull() : Boolean{
        if(counter == 9){
            textViewArrayList.removeLast()
            return true
        }
        return false
    }

    fun isZero() : Boolean{
        for(i in textViewArrayList){
            if(i.toInt() != 0){
                return true
            }
        }
        return false
    }

    fun setColourForOperation(isFinished : Boolean, v : View){
        var button = v as Button
        if(!isFinished){
            button.setBackgroundColor(Color.WHITE)
            button.setTextColor(resources.getColor(R.color.orange))
        }
        else{
            button.setBackgroundColor(resources.getColor(R.color.orange))
            button.setTextColor(Color.WHITE)
        }
    }
    fun setColourForOperation(isFinished : Boolean, whichOperation : Int){
        var button = whichView(whichOperation) as Button
        if(!isFinished){
            button.setBackgroundColor(Color.WHITE)
            button.setTextColor(resources.getColor(R.color.orange))
        }
        else{
            button.setBackgroundColor(resources.getColor(R.color.orange))
            button.setTextColor(Color.WHITE)
        }
    }

    fun resultOfOperation(){
        var answer = 0.0
        val text = binding.textViewNumber.text.toString()
        secondNum = text.toDouble()

        when (operation) {
            DIVIDE -> {
                answer = firstNum / secondNum
            }
            MULTIPLY -> {
                answer = firstNum * secondNum
            }
            SUBSTRACTION -> {
                answer = firstNum - secondNum
            }
            ADDITION -> {
                answer = firstNum + secondNum
            }
        }
        operationFinished = true
        isFirstNum = true
        binding.textViewNumber.text = answer.toString()
    }

    fun whichView(whichOperation: Int) : View{
        when (operation) {
            DIVIDE -> {
                return binding.divideButton
            }
            MULTIPLY -> {
                return binding.multiplierButton
            }
            SUBSTRACTION -> {
                return binding.substractionButton
            }
            ADDITION -> {
                return binding.additionButton
            }
        }
        return binding.resultButton
    }

    fun setAC(){
        counter = 0
        binding.textViewNumber.text = ZERO
        textViewArrayList.clear()
        textViewArrayList.add(ZERO)
        isNegative = false
        operationFinished = true
        isFirstNum = false
        var button = whichView(operation) as Button
        setColourForOperation(true, button)
        operation = 0
        firstNum = 0.0
        secondNum = 0.0
    }

    fun processOperation(){

        val text = binding.textViewNumber.text.toString()
        secondNum = text.toDouble()

        when(operation){
            DIVIDE -> {
                result = firstNum / secondNum
            }
            MULTIPLY -> {
                result = firstNum * secondNum
            }
            SUBSTRACTION -> {
                result = firstNum - secondNum
            }
            ADDITION ->{
                result = firstNum + secondNum
            }
        }
        binding.textViewNumber.text = (result).toString()
        operationFinished = true
    }


    fun buttonOncClickChangeOperation(v : View, operationName : Int){
        setColourForOperation(true, operation)
        setColourForOperation(false, v)
        val text = binding.textViewNumber.text.toString()
        firstNum = text.toDouble()
        operationFinished = false
        isFirstNum = true
        operation = operationName
    }

    fun buttonOnClickForAll(v : View, operationName : Int){
        setColourForOperation(false, v)
        val text = binding.textViewNumber.text.toString()
        firstNum = text.toDouble()
        operationFinished = false
        isFirstNum = true
        operation = operationName
        changeOperation = true
        prevOperation = operationName
    }

    fun isAfterOperation(number : String){
        if(isFirstNum){
            textViewArrayList.clear()
            binding.textViewNumber.text = ""
            textViewArrayList.add(number)
            addNumber(number)
            isFirstNum = false
            Log.d("INZERO", "onClick: in")
        }
        else{
            textViewArrayList.add(number)
            addNumber(number)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_CONTENTS, binding.textViewNumber.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.textViewNumber.text = savedInstanceState.getString(TEXT_CONTENTS, "")
    }
}