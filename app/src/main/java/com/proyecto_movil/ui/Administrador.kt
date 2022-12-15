package com.proyecto_movil.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.proyecto_movil.R
import com.proyecto_movil.databinding.ActivityAdministradorBinding

class Administrador : AppCompatActivity() {
    private var _binding: ActivityAdministradorBinding? = null
    private val binding get() = _binding!!
    private lateinit var tablaViewModel: TablaViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_administrador)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

/*
    private fun addLugar() {
        val bus = binding.etBus.text.toString()
        val precio = binding.etPrecio.text.toString().toInt()
        val dias = binding.etDias.text.toString()
        val horario = binding.etHorario.text.toString()
        val descripcion = binding.etDescripcion.text.toString()


        if (bus.isNotEmpty()) {
            val tabla = Tabla(0, bus, precio, dias, horario, descripcion)
            tablaViewModel.saveTabla(tabla)
            Toast.makeText(
                requireContext(), getString(R.string.msg_bus_added),
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_addLugarFragment_to_nav_lugar)
        } else {  //No hay info del lugar
            Toast.makeText(
                requireContext(), getString(R.string.msg_data),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    */


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_home -> {
                startActivity(Intent(this, Parada_Periferica::class.java))
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
            R.id.cerrar_session -> {
                Firebase.auth.signOut()
                finish()
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }
}