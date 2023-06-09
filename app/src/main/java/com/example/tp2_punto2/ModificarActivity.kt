package com.example.tp2_punto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.view.View

import android.widget.TextView
import android.widget.Toast

class ModificarActivity : AppCompatActivity() {
    lateinit var ciudadDBHELPER: miSQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modificar)
        ciudadDBHELPER = miSQLiteHelper(this)
        var btnModificar = findViewById<Button>(R.id.btnModificar)

        var btnAtras = findViewById<Button>(R.id.atras_button)
        btnAtras.setOnClickListener{
            finish() // Cierra la actividad actual y vuelve a la anterior
        }

        btnModificar.setOnClickListener{
            val ciudad = findViewById<TextView>(R.id.ciudad_consulta).text.toString()
            val poblacion = findViewById<TextView>(R.id.poblacion_consulta).text.toString()
            if (ciudad.isNotEmpty() && poblacion.isNotEmpty() ){
                val mod = ciudadDBHELPER.modificarPoblacion(ciudad, poblacion.toInt())
                if (mod){
                    Toast.makeText(this, "La poblacion de la ciudad "+ciudad+" ha sido modificada", Toast.LENGTH_SHORT).show()
                    finish()
                }
                else{
                    Toast.makeText(this, "La ciudad ingresada no existe", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }




    }
}