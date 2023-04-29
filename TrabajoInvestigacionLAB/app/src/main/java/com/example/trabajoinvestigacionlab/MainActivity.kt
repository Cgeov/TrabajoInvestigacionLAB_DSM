package com.example.trabajoinvestigacionlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.trabajoinvestigacionlab.ViewModel.SalarioViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var salarioViewModel: SalarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        salarioViewModel = ViewModelProvider(this).get(SalarioViewModel::class.java)

        val nombreEditText = findViewById<EditText>(R.id.nombre_edittext)
        val salarioBaseEditText = findViewById<EditText>(R.id.salario_base_edittext)
        val calcularButton = findViewById<Button>(R.id.calcular_button)
        val salarioNetoTextView = findViewById<TextView>(R.id.salario_neto_textview)

        calcularButton.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val salarioBase = salarioBaseEditText.text.toString().toDoubleOrNull() ?: 0.0
            salarioViewModel.calcularSalario(nombre, salarioBase)
        }
        salarioViewModel.salario.observe(this, { salario ->
            salarioNetoTextView.text =
                "${salario.nombre}, tu salario Neto es ${salario.salarioNeto}"
        })
    }
}