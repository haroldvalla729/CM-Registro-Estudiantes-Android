package com.example.cm_registroestudiantes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cargar el diseño XML
        setContentView(R.layout.activity_main)

        // Obtener los componentes de la pantalla
        val etNombre     = findViewById<EditText>(R.id.etNombre)
        val rgCarrera    = findViewById<RadioGroup>(R.id.rgCarrera)   // ← sin "s"
        val cbVirtual    = findViewById<CheckBox>(R.id.cbVirtual)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener {

            // 1) Obtener y validar el nombre
            val nombre = etNombre.text.toString().trim()
            if (nombre.isEmpty()) {
                Toast.makeText(
                    this,
                    getString(R.string.error_nombre_vacio),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // 2) Validar que haya una carrera seleccionada
            val idSeleccionado = rgCarrera.checkedRadioButtonId
            if (idSeleccionado == -1) {
                Toast.makeText(
                    this,
                    getString(R.string.error_carrera_vacia),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // 3) Obtener el texto de la carrera seleccionada
            val carrera = findViewById<RadioButton>(idSeleccionado).text.toString()

            // 4) Determinar la modalidad
            val modalidad = if (cbVirtual.isChecked) {
                getString(R.string.modalidad_virtual)
            } else {
                getString(R.string.modalidad_presencial)
            }

            // 5) Navegar a la segunda pantalla con los datos
            val intent = Intent(this, ResumenActivity::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("carrera", carrera)
            intent.putExtra("modalidad", modalidad)
            startActivity(intent)
        }
    }
}