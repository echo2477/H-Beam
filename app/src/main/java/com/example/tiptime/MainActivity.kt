package com.example.BajaHBeam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.BajaHBeam.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.HitungButton.setOnClickListener { HitungBerat() }
    }

    private fun HitungBerat() {
        val stringInTextField = binding.QuantityBaja.text.toString()
        val Quantity = stringInTextField.toDoubleOrNull()
        if (Quantity == null) {
            binding.BeratHBeam.text = ""
            return
        }

        val Berat_H_Beam = when (binding.TypeHBeam.checkedRadioButtonId) {
            R.id.H_Beam_100 -> 206.00
            R.id.H_Beam_125 -> 288.00
            R.id.H_Beam_150 -> 378.00
            R.id.H_Beam_175 -> 482.00
            R.id.H_Beam_200 -> 599.00
            R.id.H_Beam_250 -> 809.00
            R.id.H_Beam_300 -> 1128.00
            R.id.H_Beam_350 -> 1644.00
            else -> 2064.00
        }

        var Berat = Berat_H_Beam * Quantity
        if (binding.tombolPembulatan.isChecked) {
            Berat = ceil(Berat)
        }

        val formattedBerat = NumberFormat.getInstance().format(Berat)
        binding.BeratHBeam.text = getString(R.string.Total_Berat_H_Beam, formattedBerat)
    }
}