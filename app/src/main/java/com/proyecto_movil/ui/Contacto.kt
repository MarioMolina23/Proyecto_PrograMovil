package com.proyecto_movil.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.proyecto_movil.R
import com.proyecto_movil.databinding.ActivityContactoBinding
import com.proyecto_movil.model.Tabla

class Contacto : AppCompatActivity() {

    private lateinit var binding : ActivityContactoBinding
    private lateinit var database : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btEnviar.setOnClickListener {

            val nombre = binding.etNombre.text.toString()
            val mail = binding.etMailcontacto.text.toString()
            val comentario = binding.etComentario.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = Tabla(0,nombre, mail, comentario)
            database.child(nombre).setValue(User).addOnSuccessListener {

                binding.etNombre.text.clear()
                binding.etMailcontacto.text.clear()
                binding.etComentario.text.clear()

                Toast.makeText(this, "Comentario enviado satisfactoriamente", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {

                Toast.makeText(this, "Falló", Toast.LENGTH_SHORT).show()

            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_home -> {
                startActivity(Intent(this, Main_Home::class.java))
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