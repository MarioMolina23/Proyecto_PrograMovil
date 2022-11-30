package com.proyecto_movil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Main_Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_contacto -> {
                startActivity(Intent(this, Contacto::class.java))
                true
            }
            R.id.menu_acerca_de -> {
                startActivity(Intent(this, Contacto::class.java))
                true
            }
            R.id.menu_equipo -> {
                startActivity(Intent(this, Contacto::class.java))
                true
            }
            R.id.menu_historia -> {
                startActivity(Intent(this, Contacto::class.java))
                true
            }
            R.id.menu_terminos_uso -> {
                startActivity(Intent(this, Contacto::class.java))
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