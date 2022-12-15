package com.proyecto_movil.ui

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
import com.proyecto_movil.MainActivity
import com.proyecto_movil.R
import com.proyecto_movil.databinding.ActivityRegistrarseBinding

class Registrarse : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegistrarseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        //Login
        binding.btRegister.setOnClickListener{
            hacerregister();
        }

        bt_cancelar();
    }

    private fun hacerregister() {
        val email = binding.registerCorreo.text.toString()
        val clave = binding.registerContrasena.text.toString()

        auth.createUserWithEmailAndPassword(email,clave)
            .addOnCompleteListener (this) { task ->
                if (task.isSuccessful) {
                    Log.d("Creando usuario", "Registrado")
                    val user = auth.currentUser
                    actualiza(user)
                }else {
                    Log.d("Error creando usuario", "Error")
                    Toast.makeText(baseContext,"Falló",Toast.LENGTH_LONG).show()
                    actualiza(null)
                }
            }
    }

    private fun actualiza(user: FirebaseUser?) {
        if (user != null) {
            val intent = Intent(this, Parada_Periferica::class.java)
            startActivity(intent)
        }
    }

    public override fun onStart () {
        super.onStart()
        val usuario = auth.currentUser
        actualiza(usuario)
    }


    fun bt_cancelar(){
        val button = findViewById<Button>(R.id.bt_cancelar)
        button.setOnClickListener{
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}