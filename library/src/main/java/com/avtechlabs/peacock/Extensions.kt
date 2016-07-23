package com.avtechlabs.peacock

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by adhithyan-3592 on 23/07/16.
 */

fun Activity.isInternetConnected() : Boolean {
    val connectivtyManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val networkInfo = connectivtyManager?.getAllNetworkInfo()
    for ( i in 1..networkInfo?.size!! ) {
        if ( networkInfo.get(i).state == NetworkInfo.State.CONNECTED)
            return true
    }
    return false
}