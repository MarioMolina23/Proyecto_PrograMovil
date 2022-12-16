package com.proyecto_movil.mapas

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
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.proyecto_movil.R
import com.proyecto_movil.ui.*

class Bus_Fidelitas : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener {

    private lateinit var map: GoogleMap

    companion object {
        const val REQUEST_CODE_LOCATION = 0
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
        map.setOnMyLocationButtonClickListener(this)
        map.setOnMyLocationClickListener(this)
        enableLocation()
    }

    private fun createMarker() {
        val idaA = LatLng(9.932309087164043, -84.04513976533597)
        val a = map.addMarker(MarkerOptions().position(idaA).title("Parada de buses FIDELITAS"))
        a!!.setIcon(BitmapDescriptorFactory.fromResource(com.proyecto_movil.R.drawable.image_parada_bus))

        val idaB = LatLng(9.931286289405199, -84.03654645114159)
        val b = map.addMarker(MarkerOptions().position(idaB).title("Parada de buses FIDELITAS"))
        b!!.setIcon(BitmapDescriptorFactory.fromResource(com.proyecto_movil.R.drawable.image_parada_bus))

        val idaC = LatLng(9.932505346370446, -84.04011891741148)
        val c = map.addMarker(MarkerOptions().position(idaC).title("Parada de buses FIDELITAS"))
        c!!.setIcon(BitmapDescriptorFactory.fromResource(com.proyecto_movil.R.drawable.image_parada_bus))

        val idaD = LatLng(9.933397642949082, -84.04321930779912)
        val d = map.addMarker(MarkerOptions().position(idaD).title("Parada de buses FIDELITAS"))
        d!!.setIcon(BitmapDescriptorFactory.fromResource(com.proyecto_movil.R.drawable.image_parada_bus))

        val idaE = LatLng(9.930740444902737, -84.04583307972696)
        val e = map.addMarker(MarkerOptions().position(idaE).title("Parada de buses FIDELITAS"))
        e!!.setIcon(BitmapDescriptorFactory.fromResource(com.proyecto_movil.R.drawable.image_parada_bus))

        val idaF = LatLng(9.931987476564174, -84.05058595409115)
        val f = map.addMarker(MarkerOptions().position(idaF).title("Parada de buses FIDELITAS"))
        f!!.setIcon(BitmapDescriptorFactory.fromResource(com.proyecto_movil.R.drawable.image_parada_bus))

        val idaG = LatLng(9.932706102835455, -84.05696961152017)
        val g = map.addMarker(MarkerOptions().position(idaG).title("Parada de buses FIDELITAS"))
        g!!.setIcon(BitmapDescriptorFactory.fromResource(com.proyecto_movil.R.drawable.image_parada_bus))

        val idaH = LatLng(9.932082588949042, -84.06540247665126)
        val h = map.addMarker(MarkerOptions().position(idaH).title("Parada de buses FIDELITAS"))
        h!!.setIcon(BitmapDescriptorFactory.fromResource(com.proyecto_movil.R.drawable.image_parada_bus))

        val idaI = LatLng(9.934365278019627, -84.06844946614639)
        val i = map.addMarker(MarkerOptions().position(idaI).title("Parada de buses FIDELITAS"))
        i!!.setIcon(BitmapDescriptorFactory.fromResource(com.proyecto_movil.R.drawable.image_parada_bus))



        val favoritePlace = LatLng(9.933032, -84.035377)
        val m = map.addMarker(MarkerOptions().position(favoritePlace).title("Parada de buses Universidad!"))
        m!!.setIcon(BitmapDescriptorFactory.fromResource(com.proyecto_movil.R.drawable.image_parada_bus))
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(favoritePlace, 18f),
            4000,
            null
        )
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
                Toast.makeText(this, "Para activar la localización ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        if (!::map.isInitialized) return
        if(!isPermissionsGranted()){
            map.isMyLocationEnabled = false
            Toast.makeText(this, "Para activar la localización ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(this, "Bus de Fidélitas", Toast.LENGTH_SHORT).show()
        return false
    }

    override fun onMyLocationClick(p0: Location) {
        Toast.makeText(this, "Estás en ${p0.latitude}, ${p0.longitude}", Toast.LENGTH_SHORT).show()
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
                startActivity(Intent(this, Bus_Fidelitas::class.java))
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