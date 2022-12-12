package com.proyecto_movil.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.proyecto_movil.R
import com.proyecto_movil.databinding.ActivityEscribanosBinding

class Escribanos : AppCompatActivity() {

    /*private var _binding: ActivityEscribanosBinding? = null
    private val binding get() = _binding!!*/ //No permite acceder al Binding, revisar por que

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escribanos)

        botones(); //Se llama a la función de los botones
    }

    private fun botones() {
        val btn_escribanos: Button = findViewById(R.id.bt_escribanos)
        btn_escribanos.setOnClickListener{
            val intent: Intent = Intent(this, Contacto::class.java)
            startActivity(intent)
        }

        val btn_instagram: ImageButton = findViewById(R.id.bt_instagram)
        btn_instagram.setOnClickListener{
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.instagram.com/")
            startActivity(openURL)
        }

        val btn_facebook: ImageButton = findViewById(R.id.bt_facebook)
        btn_facebook.setOnClickListener{
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.facebook.com/")
            startActivity(openURL)
        }

        val btn_web: ImageButton = findViewById(R.id.bt_web)
        btn_web.setOnClickListener{
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.ufidelitas.ac.cr/")
            startActivity(openURL)
        }

        //val telefono = binding.tvLlamada.text.toString()
        val btn_llamada: ImageButton = findViewById(R.id.bt_llamada)
        btn_llamada.setOnClickListener{
            if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                val miIntent = Intent(
                    Intent.ACTION_CALL,
                    //Uri.parse("tel:$telefono"))
                    Uri.parse("tel:+506 2206 8600"))
                startActivity(miIntent)
            }else{
                Toast.makeText(this,
                    "No hay permisos para esta llamada",
                    Toast.LENGTH_LONG).show()
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    123
                )
            }
        }

        val btn_whatsApp: ImageButton = findViewById(R.id.bt_whatsapp)
        btn_whatsApp.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            val uri = "whatsapp://send?phone=50686068600&text="+
                    getString(R.string.msg_mensaje)
            intent.setPackage("com.whatsapp")
            intent.data = Uri.parse(uri)
            startActivity(intent)
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
            R.id.cerrar_session -> {
                Firebase.auth.signOut()
                finish()
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }
}