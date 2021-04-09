package com.example.calculator_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    var isnewop = true
    var oldnumber = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        var editText = findViewById<EditText>(R.id.editText)
        if (isnewop)
            editText.setText("")
        isnewop = false
        var bu1 = findViewById<Button>(R.id.bu1)
        var bu2 = findViewById<Button>(R.id.bu2)
        var bu3 = findViewById<Button>(R.id.bu3)
        var bu4 = findViewById<Button>(R.id.bu4)
        var bu5 = findViewById<Button>(R.id.bu5)
        var bu6 = findViewById<Button>(R.id.bu6)
        var bu7 = findViewById<Button>(R.id.bu7)
        var bu8 = findViewById<Button>(R.id.bu8)
        var bu9 = findViewById<Button>(R.id.bu9)
        var bu0 = findViewById<Button>(R.id.bu0)
        var buDot = findViewById<Button>(R.id.buDot)
        var buPlusMinus = findViewById<Button>(R.id.buPlusMinus)

        var buclick = editText.text.toString()
        var busclect = view as Button
        when(busclect.id){
           bu1.id->{buclick += "1"}
           bu2.id->{buclick += "2"}
           bu3.id->{buclick += "3"}
           bu4.id->{buclick += "4"}
           bu5.id->{buclick += "5"}
           bu6.id->{buclick += "6"}
           bu7.id->{buclick += "7"}
           bu8.id->{buclick += "8"}
           bu9.id->{buclick += "9"}
           bu0.id->{buclick += "0"}
           buDot.id->{buclick += "."}
           buPlusMinus.id->{buclick = "-$buclick"}
        }
        editText.setText(buclick)
    }

    fun operatoeEvent(view: View) {
        var editText = findViewById<EditText>(R.id.editText)
        oldnumber = editText.text.toString()
        isnewop = true
        var buDivide = findViewById<Button>(R.id.buDivide)
        var buMultiply = findViewById<Button>(R.id.buMultiply)
        var buPlus = findViewById<Button>(R.id.buPlus)
        var buMinus = findViewById<Button>(R.id.buMinus)
        var buselect = view as Button
        when (buselect.id){
            buMultiply.id -> {op = "*"}
            buPlus.id -> {op = "+"}
            buMinus.id -> {op = "-"}
            buDivide.id -> {op = "/"}
        }
        editText.setText(op)
    }

    fun equalEvent(view: View) {
        var editText = findViewById<EditText>(R.id.editText)
        var newnumber = editText.text.toString()
        var result = 0.0
        when(op){
            "+" -> {result = oldnumber.toDouble() + newnumber.toDouble()}
            "*" -> {result = oldnumber.toDouble() * newnumber.toDouble()}
            "/" -> {result = oldnumber.toDouble() / newnumber.toDouble()}
            "-" -> {result = oldnumber.toDouble() - newnumber.toDouble()}
        }
        editText.setText(result.toString())
    }

    fun Acevent(view: View) {
        var editText = findViewById<EditText>(R.id.editText)
        editText.setText("0")
        isnewop = true
    }

    fun percentevent(view: View) {
        var editText = findViewById<EditText>(R.id.editText)
        var no = editText.text.toString().toDouble()/100
        editText.setText(no.toString())
        isnewop = true
    }
}