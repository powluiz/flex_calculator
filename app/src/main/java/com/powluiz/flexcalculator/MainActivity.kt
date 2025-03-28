package com.powluiz.flexcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var etConsumption1 : TextInputEditText
    private lateinit var etConsumption2 : TextInputEditText
    private lateinit var etFuelPrice1 : TextInputEditText
    private lateinit var etFuelPrice2 : TextInputEditText
    private lateinit var btnSearch1 : Button
    private lateinit var btnSearch2 : Button
    private lateinit var btnSubmit : Button


    private fun onClickSubmit() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("consumption1", etConsumption1.text.toString())
        intent.putExtra("consumption2", etConsumption2.text.toString())
        intent.putExtra("fuelPrice1", etFuelPrice1.text.toString())
        intent.putExtra("fuelPrice2", etFuelPrice2.text.toString())
        startActivity(intent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etConsumption1 = findViewById(R.id.input_consumption_1)
        etConsumption2 = findViewById(R.id.input_consumption_2)
        etFuelPrice1 = findViewById(R.id.input_fuel_price_1)
        etFuelPrice2 = findViewById(R.id.input_fuel_price_2)
        btnSearch1 = findViewById(R.id.search_button_1)
        btnSearch2 = findViewById(R.id.search_button_2)
        btnSubmit = findViewById(R.id.button_submit)
        btnSubmit.setOnClickListener{onClickSubmit()}
    }

    fun onClickSearch1(view: View) {
        val intent = Intent(this, OptionListActivity::class.java)
        intent.putExtra("selectedTextInputName", "etConsumption1")
        startActivity(intent)
    }

    fun onClickSearch2(view: View) {
        val intent = Intent(this, OptionListActivity::class.java)
        intent.putExtra("selectedTextInputName", "etConsumption2")
        startActivity(intent)
    }
}