package com.proyecto_movil.mapas_ruta

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.proyecto_movil.R
import com.proyecto_movil.ui.*

class Bus_Alajuela_ruta : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener {

    private lateinit var map: GoogleMap

    companion object {
        const val REQUEST_CODE_LOCATION = 0
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.setOnMyLocationButtonClickListener(this)
        map.setOnMyLocationClickListener(this)
        enableLocation()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa_google)
        createMapFragment()
    }

    private fun createMapFragment() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun isPermissionsGranted() = ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun enableLocation() {
        if (!::map.isInitialized) return
        if (isPermissionsGranted()) {
            map.isMyLocationEnabled = true
        } else {
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            Toast.makeText(this, "Ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
        } else {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_LOCATION
            )
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            REQUEST_CODE_LOCATION -> if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                map.isMyLocationEnabled = true
            }else{
                Toast.makeText(this, "Para activar la localizaci??n ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        if (!::map.isInitialized) return
        if(!isPermissionsGranted()){
            map.isMyLocationEnabled = false
            Toast.makeText(this, "Para activar la localizaci??n ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(this, "Bus de Alajuela", Toast.LENGTH_SHORT).show()
        return false
    }

    override fun onMyLocationClick(p0: Location) {
        Toast.makeText(this, "Est??s en ${p0.latitude}, ${p0.longitude}", Toast.LENGTH_SHORT).show()
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
                startActivity(Intent(this, Bus_Alajuela_ruta::class.java))
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