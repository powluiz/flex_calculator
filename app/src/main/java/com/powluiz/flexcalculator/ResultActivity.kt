package com.powluiz.flexcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat

class ResultActivity : AppCompatActivity() {

    private lateinit var tvResult : TextView
    private lateinit var tvFuel1 : TextView
    private lateinit var tvFuel2 : TextView
    private lateinit var btnRollback : Button

    private fun getFuelValue(consumption: Float, fuelPrice: Float): Float {
        if (consumption == 0f || fuelPrice == 0f) {  return 0f }
        return fuelPrice / consumption
    }

    private fun getFuelText(value1: Float, value2: Float): String {
        if (value1 == value2) {  return "As opções são equivalentes!" }

        val bestOption = if (value1 < value2) "1" else "2"
        return "O combustível $bestOption é a melhor opção."
    }

    private fun onClickRollback() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        btnRollback = findViewById(R.id.rollback_button)
        tvResult = findViewById(R.id.result_value)
        tvFuel1 = findViewById(R.id.fuel1_text)
        tvFuel2 = findViewById(R.id.fuel2_text)

        btnRollback.setOnClickListener{onClickRollback()}

        val consumption1 = intent.getStringExtra("consumption1")?.toFloatOrNull() ?: 0f
        val consumption2 = intent.getStringExtra("consumption2")?.toFloatOrNull() ?: 0f
        val fuelPrice1 = intent.getStringExtra("fuelPrice1")?.toFloatOrNull() ?: 0f
        val fuelPrice2 = intent.getStringExtra("fuelPrice2")?.toFloatOrNull() ?: 0f

        val fuelValue1 = getFuelValue(consumption1, fuelPrice1)
        val fuelValue2 = getFuelValue(consumption2, fuelPrice2)

        val df = DecimalFormat("0.00")
        tvFuel1.text = "Gasto do combustível 1: ${df.format(fuelValue1)} R$ por Km"
        tvFuel2.text = "Gasto do combustível 2: ${df.format(fuelValue2)} R$ por Km"
        tvResult.text = getFuelText(fuelValue1, fuelValue2)
    }
}