package com.avtechlabs.peacock

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast

/**
 * Created by adhithyan-3592 on 23/07/16.
 */

fun Activity.isInternetConnected() : Boolean {
    val connectivtyManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val networkInfo = connectivtyManager?.getAllNetworkInfo()
    for ( i in 1..networkInfo?.size!! ) {
        if ( networkInfo.get(i - 1).state == NetworkInfo.State.CONNECTED)
            return true
    }
    return false
}

fun Activity.showLongToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.showShortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.marshmallowOrAbove(func: () -> Any){
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { func() }
}

fun Activity.permissionGranted(permission: String) : Boolean {
    return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
}

fun Activity.checkAndAskPermission(permissions: Array<String>){
    var permissionList = mutableListOf("")

    marshmallowOrAbove {
        permissionList.removeAt(0)
        for ( i in 0 until permissions.size ) {
                var permission = permissions.get(i)
            if( !permissionGranted( permission ) ) permissionList.add(permission)
        }

        if (permissionList.size > 0)
            ActivityCompat.requestPermissions(this, permissionList.toTypedArray(), 100)
    }
}
