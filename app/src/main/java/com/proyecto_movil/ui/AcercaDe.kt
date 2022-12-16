package com.proyecto_movil.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.proyecto_movil.R
import com.proyecto_movil.mapas.Mapa_Google

class AcercaDe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acerca_de)

        botones(); //Se llama a la función de los botones
    }

    private fun botones() {
        val btn_terminos: ImageButton = findViewById(R.id.bt_terminos)
        btn_terminos.setOnClickListener{
            val intent: Intent = Intent(this, Terminos::class.java)
            startActivity(intent)
        }

        val btn_historia: ImageButton = findViewById(R.id.bt_historia)
        btn_historia.setOnClickListener{
            val intent: Intent = Intent(this, Historia::class.java)
            startActivity(intent)
        }

        val btn_equipo: ImageButton = findViewById(R.id.bt_equipo)
        btn_equipo.setOnClickListener{
            val intent: Intent = Intent(this, Equipo::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { //Funcionabilidad de botones dentro del menú
        return when (item.itemId) {
            R.id.menu_home -> {
                startActivity(Intent(this, Main_Home::class.java))
                true
            }
            R.id.menu_map -> {
                startActivity(Intent(this, Mapa_Google::class.java))
                true
            }
            R.id.menu_contacto -> {
                startActivity(Intent(this, Escribanos::class.java))
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
            R.id.cerrar_session -> {
                Firebase.auth.signOut()
                finish()
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }
}