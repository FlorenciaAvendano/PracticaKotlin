package com.projectbolt.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var contador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonSumar=findViewById<Button>(R.id.btnSuma)
        val botonRestar=findViewById<Button>(R.id.btnResta)
        val botonRestart=findViewById<Button>(R.id.btnRestart)
        val textoContador=findViewById<TextView>(R.id.textCount)

        botonSumar.setOnClickListener {
            contador++
            textoContador.text="$contador"
        }
        botonRestar.setOnClickListener {
            if(contador>0){
                contador--
                textoContador.text="$contador"
            }
        }
        botonRestart.setOnClickListener {
            contador=0
            textoContador.text="$contador"
        }

    }
}