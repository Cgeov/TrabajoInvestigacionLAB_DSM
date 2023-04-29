package com.example.trabajoinvestigacionlab.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trabajoinvestigacionlab.Model.Salario

class SalarioViewModel: ViewModel() {
    private val _salario = MutableLiveData<Salario>()
    val salario: LiveData<Salario>
        get() = _salario

    fun calcularSalario(nombre: String, salarioBase: Double) {
        val descuento = salarioBase * 0.07
        val salarioNeto = salarioBase - descuento
        val salario = Salario(nombre, salarioBase, descuento, salarioNeto)
        _salario.value = salario
    }
}