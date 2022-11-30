package com.proyecto_movil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.proyecto_movil.databinding.ActivityInicioSesionBinding

class InicioSesion : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityInicioSesionBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        //Login
        binding.btIniciarSesion.setOnClickListener{
            hacerlogin();
        }

        bt_registrase();
    }

    private fun hacerlogin() {
        val email = binding.inicioCorreo.text.toString()
        val clave = binding.inicioContrasena.text.toString()

        auth.signInWithEmailAndPassword(email,clave)
            .addOnCompleteListener (this) { task ->
                if (task.isSuccessful) {
                    Log.d("Autenticando", "Autenticado")
                    val user = auth.currentUser
                    actualiza(user)
                }else {
                    Log.d("Error autenticado", "Error")
                    Toast.makeText(baseContext,"Falló", Toast.LENGTH_LONG).show()
                    actualiza(null)
                }
            }
    }

    private fun actualiza(user: FirebaseUser?) {
        if (user != null) {
            val intent = Intent(this, Main_Home::class.java)
            startActivity(intent)
        }
    }

    public override fun onStart () {
        super.onStart()
        val usuario = auth.currentUser
        actualiza(usuario)
    }

    fun bt_registrase(){
        val button = findViewById<Button>(R.id.bt_registrate)
        button.setOnClickListener{
            val intent = Intent (this,Registrarse::class.java)
            startActivity(intent)
        }
    }
}