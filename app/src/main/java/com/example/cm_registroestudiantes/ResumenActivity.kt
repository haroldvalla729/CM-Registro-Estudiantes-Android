package com.example.cm_registroestudiantes

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResumenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cargar el diseño XML de la segunda pantalla
        setContentView(R.layout.activity_resumen)

        // Obtener los TextView del diseño
        val tvNombre    = findViewById<TextView>(R.id.tvNombre)
        val tvCarrera   = findViewById<TextView>(R.id.tvCarrera)
        val tvModalidad = findViewById<TextView>(R.id.tvModalidad)

        // Recuperar los datos enviados desde MainActivity
        val nombre    = intent.getStringExtra("nombre")
        val carrera   = intent.getStringExtra("carrera")
        val modalidad = intent.getStringExtra("modalidad")

        // Mostrar los datos recibidos
        tvNombre.text    = nombre    ?: getString(R.string.dato_no_disponible)
        tvCarrera.text   = carrera   ?: getString(R.string.dato_no_disponible)
        tvModalidad.text = modalidad ?: getString(R.string.dato_no_disponible)
    }
}