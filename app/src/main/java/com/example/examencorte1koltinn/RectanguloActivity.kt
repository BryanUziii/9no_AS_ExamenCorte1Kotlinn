package com.example.examencorte1koltinn

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RectanguloActivity : AppCompatActivity() {
    // Declaración de las propiedades
    private lateinit var lblPerimetro: TextView
    private lateinit var lblArea: TextView

    private lateinit var inputBase: EditText
    private lateinit var inputAltura: EditText

    private lateinit var btnCalcular: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rectangulo)

        lblPerimetro = findViewById(R.id.lblPerimetro)
        lblArea = findViewById(R.id.lblArea)

        inputBase = findViewById(R.id.inputBase)
        inputAltura = findViewById(R.id.inputAltura)

        btnCalcular = findViewById(R.id.btnCalcular)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnRegresar = findViewById(R.id.btnRegresar)

        val textViewNombreUsuario: TextView = findViewById(R.id.lblNombreUsuario)

        val extras: Bundle? = intent.extras

        if (extras != null && extras.containsKey("nombreUsuario")) {
            val nombreUsuario: String? = extras.getString("nombreUsuario")
            textViewNombreUsuario.text = "Su nombre es: " + nombreUsuario
        }


        btnCalcular.setOnClickListener {
            if (validarInputs()) {
                val base = inputBase.text.toString().trim().toDouble()
                val altura = inputAltura.text.toString().trim().toDouble()

                val rectangulo = Rectangulo(base, altura)

                val areaCalculada = rectangulo.calcularArea()
                val perimetroCalculado = rectangulo.calcularPerimetro()

                lblArea.text = "Area: " + areaCalculada.toString()
                lblPerimetro.text ="Perometro: " + perimetroCalculado.toString()
            }
        }




        btnLimpiar.setOnClickListener {
            inputAltura.text.clear()
            inputBase.text.clear()

            lblArea.text = "Area:"
            lblPerimetro.text = "Perimetro:"
        }

        btnRegresar.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmación")
            builder.setMessage("¿Estás seguro de querer regresar?")
            builder.setPositiveButton("Sí") { dialog, which ->
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            builder.setNegativeButton("No") { dialog, which ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }
    }

    private fun validarInputs(): Boolean {
        val alturaText = inputAltura.text.toString().trim()
        val baseText = inputBase.text.toString().trim()

        return if (!alturaText.isEmpty() && !baseText.isEmpty()) {
            true
        } else {
            Toast.makeText(applicationContext, "Todos los campos son requeridos", Toast.LENGTH_SHORT).show()
            false
        }
    }
}