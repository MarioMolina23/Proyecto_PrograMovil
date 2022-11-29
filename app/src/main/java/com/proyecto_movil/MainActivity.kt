package com.proyecto_movil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class MainActivity : AppCompatActivity() {
    private val list = mutableListOf<CarouselItem>() /*Se crea una lista para carrusel*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_iniciar_sesion();
        bt_registrarse();

        /*Se llaman las imagenes desde la Web para cargarlas en el home de la app*/
        val carousel: ImageCarousel = findViewById(R.id.tv_titulo)
        list.add(CarouselItem("https://media.istockphoto.com/id/1144226219/es/vector/la-gente-que-espera-el-transporte-y-el-uso-de-internet-tel%C3%A9fono-inteligente-concepto-de.jpg?s=612x612&w=0&k=20&c=UyZTMsTcpnPDQa0g-WANx_vFrkujRbOFo0pBCCK8kuI="))
        list.add(CarouselItem("https://media.istockphoto.com/id/1147131346/es/vector/personas-pasajeros-esperando-autob%C3%BAs-concepto-de-transporte-urbano-de-la-ciudad-dise%C3%B1o.jpg?s=612x612&w=0&k=20&c=Z5UQkf9FGmVUhg3S6bqCk4aY_ozcBsNW5pJLE3YMx7Y="))
        list.add(CarouselItem("https://i.pinimg.com/originals/8b/f9/8d/8bf98d94773b9002b1f7e68f29e0d716.jpg"))
        /*Se crea la lista y se carga a continuación*/
        carousel.addData(list)
    }

    //Evento para abrir la pantalla de inicio de Sesion
    fun bt_iniciar_sesion(){
        val button = findViewById<Button>(R.id.bt_inicio)
        button.setOnClickListener{
            val intent = Intent (this,InicioSesion::class.java)
            startActivity(intent)
        }
    }

    //Evento para abrir la pantalla de registrarse
    fun bt_registrarse(){
        val button = findViewById<Button>(R.id.bt_register)
        button.setOnClickListener{
            val intent = Intent (this,Registrarse::class.java)
            startActivity(intent)
        }
    }
}