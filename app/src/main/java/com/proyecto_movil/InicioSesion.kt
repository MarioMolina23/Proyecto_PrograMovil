package com.proyecto_movil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InicioSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)

        bt_registrase();
    }

    fun bt_registrase(){
        val button = findViewById<Button>(R.id.bt_registrate)
        button.setOnClickListener{
            val intent = Intent (this,Registrarse::class.java)
            startActivity(intent)
        }
    }
}