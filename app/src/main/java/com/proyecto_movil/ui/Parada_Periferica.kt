package com.proyecto_movil.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.proyecto_movil.R

class Parada_Periferica : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parada_periferica)
        botones(); //Se llama a la función de los botones
    }

    private fun botones() {
        val btn_parada: Button = findViewById(R.id.busperi_bt_parada)
        btn_parada.setOnClickListener{
            val intent: Intent = Intent(this, Mapa_Google::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_map -> {
                startActivity(Intent(this, Mapa_Google::class.java))
                true
            }
            R.id.menu_contacto -> {
                startActivity(Intent(this, Escribanos::class.java))
                true
            }
            R.id.menu_acerca_de -> {
                startActivity(Intent(this, AcercaDe::class.java))
                true
            }
            R.id.menu_equipo -> {
                startActivity(Intent(this, Equipo::class.java))
                true
            }
            R.id.menu_historia -> {
                startActivity(Intent(this, Historia::class.java))
                true
            }
            R.id.menu_terminos_uso -> {
                startActivity(Intent(this, Terminos::class.java))
                true
            }
            R.id.administrador -> {
                startActivity(Intent(this, Administrador::class.java))
                true
            }
            R.id.cerrar_session -> {
                Firebase.auth.signOut()
                finish()
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }
}