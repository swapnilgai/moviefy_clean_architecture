package com.example.moviefy_clean_architecture.location

import android.Manifest
import com.example.moviefy_clean_architecture.common.ui.BaseViewModel

data class LocationContent(
    val locationSearchResult: List<LocationData>? = emptyList(),
    val title: String
)

class LocationViewModel(private val locationInteractor: LocationInteractor): BaseViewModel<LocationContent>(
    LocationContent(title = "Enter City name or zip")
) {

    private val requestCodeSend: Int = 100

    fun onCurrentLocationClicked(){
        if(!locationInteractor.isLocationPermissionGranted()){}
            //requestPermission(LocationPermission.LOCATION.permissionString, requestCodeSend)
    }
}


enum class LocationPermission(vararg permissionString: String){
    LOCATION(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    );

    val permissionString: List<String> = permissionString.toList()
}