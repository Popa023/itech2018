package com.razvanpopescu.socialresp

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SeekBar
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.razvanpopescu.socialresp.R.menu.menutest
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

        private lateinit var mMap: GoogleMap

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_maps)

            // Get the support action bar
            val actionBar = supportActionBar

            // Set the action bar title, subtitle and elevation
            actionBar!!.title = "Kotlin"
            actionBar.subtitle = "Many useful kotlin examples."
            actionBar.elevation = 4.0F

            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
            mapFragment.getMapAsync(this)
            seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                    // Display the current progress of SeekBar
                    text_view.text = "Progress : $i"
                    mMap.clear()
                    mMap.addCircle(
                        CircleOptions()
                            .center(LatLng(-34.0, 151.0))
                            .radius(seek_bar.progress.toDouble() * 1000)
                            .strokeColor(Color.RED)
                    )
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    // Do something
                    Toast.makeText(applicationContext,"start tracking",Toast.LENGTH_SHORT).show()
                    mMap.clear()
                    mMap.addCircle(
                        CircleOptions()
                            .center(LatLng(-34.0, 151.0))
                            .radius(seek_bar.progress.toDouble() * 1000)
                            .strokeColor(Color.RED)
                    )
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    // Do something
                    Toast.makeText(applicationContext,"stop tracking", Toast.LENGTH_SHORT).show()
                    mMap.clear()
                    mMap.addCircle(
                        CircleOptions()
                            .center(LatLng(-34.0, 151.0))
                            .radius(seek_bar.progress.toDouble() * 1000)
                            .strokeColor(Color.RED)
                    )
                }
            })


        }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {

            // Inflate the menu to use in the action bar
            val inflater = menuInflater
            inflater.inflate(menutest, menu)

            //Check if user is logged in
            if(AppConfig.token != null){
                val login = menu.findItem(R.id.action_login)
                login.isVisible = false
                //userRegistered is boolean, pointing if the user has registered or not.
                val profile = menu.findItem(R.id.action_profile)
                profile.isVisible = true
                return true
            }

            print(AppConfig.token)
            return super.onCreateOptionsMenu(menu)
        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.action_login -> {
                var myIntent = Intent(this, LoginActivity::class.java)
                startActivity(myIntent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera. In this case,
         * we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to install
         * it inside the SupportMapFragment. This method will only be triggered once the user has
         * installed Google Play services and returned to the app.
         */
        override fun onMapReady(googleMap: GoogleMap) {
            mMap = googleMap

            // Add a marker in Sydney and move the camera
            val sydney = LatLng(-34.0, 151.0)
            mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
            mMap.addCircle(
                CircleOptions()
                    .center(sydney)
                    .radius(seek_bar.progress.toDouble() * 1000)
                    .strokeColor(Color.RED)
            )
        }
}
