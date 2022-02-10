package com.projectbolt.sharedpreferences

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Typeface

class MainActivity : AppCompatActivity() {
    private  val key = "MY_KEY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonPut=findViewById<Button>(R.id.buttonPut)
        val botonGet=findViewById<Button>(R.id.buttoGet)
        val botonDelete=findViewById<Button>(R.id.buttonDelete)
        val textView = findViewById<TextView>(R.id.textViewTitle)

        textView.typeface = Typeface.createFromAsset(assets,"fonts/Rye-Regular.ttf")

        val prefs = getPreferences(Context.MODE_PRIVATE)
        //Guarda las preferencias
        botonPut.setOnClickListener {
            val editor = prefs.edit()
            editor.putString(key,"Bienvenido!!!!")
            editor.apply()
            showAlert("Hemos guardado un valor")
        }
        //Recuperamos las preferencias
        botonGet.setOnClickListener {
            val myPref = prefs.getString(key,"no hay un valor para esta clave")
            if (myPref != null) {
                showAlert(myPref)
            }
        }
        //Eliminamos las preferencias
        botonDelete.setOnClickListener {
            val editor = prefs.edit()
            editor.remove(key)
            editor.apply()
            showAlert("Hemos borrado un valor")
        }
    }

    private fun showAlert(message:String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("My preferences")
        builder.setMessage(message)
        val dialog = builder.create()
        dialog.show()
    }
}