package com.avtechlabs.peacock.utilities

import android.content.Context
import android.util.Log
import android.widget.Toast

/**
 * Created by adhithyan-3592 on 10/07/16.
 */

class ToastUtil(internal var context: Context) {

    fun showLongToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun showShortToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}
