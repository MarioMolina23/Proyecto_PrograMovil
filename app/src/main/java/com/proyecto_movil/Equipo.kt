package com.proyecto_movil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.proyecto_movil.databinding.ActivityEquipoBinding
import me.relex.circleindicator.CircleIndicator3

class Equipo : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()
    private lateinit var binding:ActivityEquipoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEquipoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postToList()

        binding.viewPager2.adapter = ViewPagerAdapter(titlesList,descList,imagesList)
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(binding.viewPager2)
    }

    private fun addToList (title: String, description: String, image: Int){
        titlesList.add(title)
        descList.add(description)
        imagesList.add(image)
    }

    private fun postToList(){
        for (i in 1..2){
            if (i == 1) {
                addToList(
                    "Mario Molina",
                    "Vecino de Guadalupe, San José. Está cursando su segundo año de carrera " +
                            "en íngenieria en sistemas. Le gusta mucho todo lo que tiene que ver con " +
                            "tecnología, porque entiende que es un medio que ayuda al ser humano a tener " +
                            "una mejor calidad de vida y también a ser mejor persona.",
                    R.drawable.mario
            )}else{
                addToList(
                    "Christian Ortega",
                    "Estudiante de último año de Ingeniería en Sistemas, 23 años, Moravia, " +
                            "San José. Le gusta mucho aprender y manipular tecnologías nuevas, muy " +
                            "creativo y relajado, le gusta mucho el diseño, la programación y todo lo " +
                            "que tiene que ver con el contenido audiovisual.",
                    R.drawable.christian
                )}
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
                startActivity(Intent(this, Contacto::class.java))
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