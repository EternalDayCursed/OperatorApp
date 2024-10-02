package com.example.operatorapplication.view

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.operatorapplication.intent.ClientIntent
import com.example.operatorapplication.model.ClientManager
import com.example.operatorapplication.location.LocationManager
import com.example.operatorapplication.R
import com.example.operatorapplication.model.ClientState

class MainActivity : AppCompatActivity(), ClientView {

    private lateinit var clientNameTextView: TextView
    private lateinit var locationTextView: TextView

    private lateinit var locationManager: LocationManager
    private lateinit var clientManager: ClientManager

    companion object {
        const val LOCATION_PERMISSION_REQUEST_CODE = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clientNameTextView = findViewById(R.id.clientNameTextView)
        locationTextView = findViewById(R.id.locationTextView)

        locationManager = LocationManager(this)
        clientManager = ClientManager()

        handleIntent(ClientIntent.LoadClientData)
    }

    override fun render(clientState: ClientState) {
        clientNameTextView.text = clientState.clientName
        clientNameTextView.setTextColor(clientState.clientColor)

        if (clientState.latitude != null && clientState.longitude != null) {
            locationTextView.text = "Lat: ${clientState.latitude}, Lon: ${clientState.longitude}"
        } else {
            locationTextView.text = "Coordinates not available"
        }
    }

    private fun handleIntent(intent: ClientIntent) {
        when (intent) {
            is ClientIntent.LoadClientData -> {
                val clientState = clientManager.getClientState()

                if (checkLocationPermission()) {
                    if (locationManager.isGmsAvailable()) {
                        locationManager.getLocationWithGms { location ->
                            render(clientState.copy(latitude = location?.latitude, longitude = location?.longitude))
                        }
                    } else if (locationManager.isHmsAvailable()) {
                        locationManager.getLocationWithHms { location ->
                            render(clientState.copy(latitude = location?.latitude, longitude = location?.longitude))
                        }
                    } else {
                        render(clientState)
                    }
                } else {
                    requestLocationPermission()
                }
            }
        }
    }

    private fun checkLocationPermission(): Boolean {
        return ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
            LOCATION_PERMISSION_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                handleIntent(ClientIntent.LoadClientData)
            } else {
                locationTextView.text = "Permission denied"
            }
        }
    }
}