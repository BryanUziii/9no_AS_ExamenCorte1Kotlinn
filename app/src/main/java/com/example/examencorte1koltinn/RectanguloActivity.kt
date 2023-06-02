package com.example.examencorte1koltinn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RectanguloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rectangulo)



        val textViewNombreUsuario: TextView = findViewById(R.id.lblNombreUsuario)

        val extras: Bundle? = intent.extras

        if (extras != null && extras.containsKey("nombreUsuario")) {
            val nombreUsuario: String? = extras.getString("nombreUsuario")
            textViewNombreUsuario.text = "Su nombre es: " + nombreUsuario
        }
    }
}