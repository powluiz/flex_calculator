package com.powluiz.flexcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var tvResult : TextView
    private lateinit var btnRollback : Button

    private fun findBestOption(consumption1: Float, consumption2: Float, fuelPrice1: Float, fuelPrice2: Float): String {
        if (consumption1 == 0f || consumption2 == 0f || fuelPrice1 == 0f || fuelPrice2 == 0f) {
            return "Algo deu errado! Por favor, tente novamente."
        }

        val fuelCost1 = fuelPrice1 / consumption1
        val fuelCost2 = fuelPrice2 / consumption2
        val bestOption = if (fuelCost1 < fuelCost2) 1 else 2
        return "O combustível $bestOption é a melhor opção!"
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

        btnRollback.setOnClickListener{onClickRollback()}


        val consumption1 = intent.getStringExtra("consumption1")?.toFloatOrNull() ?: 0f
        val consumption2 = intent.getStringExtra("consumption2")?.toFloatOrNull() ?: 0f
        val fuelPrice1 = intent.getStringExtra("fuelPrice1")?.toFloatOrNull() ?: 0f
        val fuelPrice2 = intent.getStringExtra("fuelPrice2")?.toFloatOrNull() ?: 0f
        tvResult.text = findBestOption(consumption1, consumption2, fuelPrice1, fuelPrice2)
    }
}