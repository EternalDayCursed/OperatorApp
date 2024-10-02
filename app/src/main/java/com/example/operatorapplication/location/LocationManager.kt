package com.example.operatorapplication.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.huawei.hms.location.FusedLocationProviderClient as HmsFusedLocationProviderClient
import com.huawei.hms.location.LocationServices as HmsLocationServices

class LocationManager(private val context: Context) {

    private var gmsLocationClient: FusedLocationProviderClient? = null
    private var hmsLocationClient: HmsFusedLocationProviderClient? = null

    fun isGmsAvailable(): Boolean {
        val gmsApiAvailability = com.google.android.gms.common.GoogleApiAvailability.getInstance()
        val resultCode = gmsApiAvailability.isGooglePlayServicesAvailable(context)
        return resultCode == com.google.android.gms.common.ConnectionResult.SUCCESS
    }

    fun isHmsAvailable(): Boolean {
        val hmsApiAvailability = com.huawei.hms.api.HuaweiApiAvailability.getInstance()
        val resultCode = hmsApiAvailability.isHuaweiMobileServicesAvailable(context)
        return resultCode == com.huawei.hms.api.ConnectionResult.SUCCESS
    }

    fun getLocationWithGms(onLocationReceived: (Location?) -> Unit) {
        if (ActivityCompat.checkSelfPermission(
                context, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context, Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            onLocationReceived(null)
            return
        }

        gmsLocationClient = LocationServices.getFusedLocationProviderClient(context)
        gmsLocationClient?.lastLocation?.addOnSuccessListener { location: Location? ->
            onLocationReceived(location)
        }?.addOnFailureListener {
            onLocationReceived(null)
        }
    }

    fun getLocationWithHms(onLocationReceived: (Location?) -> Unit) {
        hmsLocationClient = HmsLocationServices.getFusedLocationProviderClient(context)
        if (ActivityCompat.checkSelfPermission(
                context, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context, Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            onLocationReceived(null)
            return
        }

        hmsLocationClient?.lastLocation?.addOnSuccessListener { location: Location? ->
            onLocationReceived(location)
        }?.addOnFailureListener {
            onLocationReceived(null)
        }
    }
}
