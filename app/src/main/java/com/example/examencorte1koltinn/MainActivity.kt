package com.example.examencorte1koltinn

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userName: EditText = findViewById(R.id.nombreUser)
        //val inputPass: EditText = findViewById(R.id.inputPass)

        val btnEntrar: Button = findViewById(R.id.btnEntrar)
        val btnSalir: Button = findViewById(R.id.btnSalir)


        btnEntrar.setOnClickListener {
            val nombreUsuario: String = userName.text.toString().trim()

            if (nombreUsuario.isEmpty()) {
                Toast.makeText(applicationContext, "Ingrese un nombre de usuario", Toast.LENGTH_SHORT).show()
            } else {
                val bundle = Bundle()
                bundle.putString("nombreUsuario", nombreUsuario)

                Toast.makeText(applicationContext, "Bienvenido", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@MainActivity, RectanguloActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }

        btnSalir.setOnClickListener {
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Confirmación")
            builder.setMessage("¿Estás seguro de querer salir?")
            builder.setPositiveButton("Sí") { dialog, _ ->
                // Acciones a realizar si se selecciona "Sí"
                finishAffinity() // Cierra todas las actividades y sale de la aplicación
            }
            builder.setNegativeButton("No") { dialog, _ ->
                // Acciones a realizar si se selecciona "No"
                dialog.dismiss() // Cierra el diálogo sin realizar ninguna acción adicional
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }
}