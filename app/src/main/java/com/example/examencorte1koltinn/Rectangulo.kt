package com.example.examencorte1koltinn

class Rectangulo (private val base: Double, private val area: Double) {
    private val altura: Double = area / base
    private val perimetro: Double = 2 * (base + altura)

    fun calcularArea(): Double {
        return base * altura
    }

    fun calcularPerimetro(): Double {
        return perimetro
    }
}