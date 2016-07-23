package com.avtechlabs.peacock

import android.content.Context

import com.avtechlabs.peacock.enums.Utility
import com.avtechlabs.peacock.utilities.AlertUtil
import com.avtechlabs.peacock.utilities.ToastUtil

/**
 * Created by adhithyan-3592 on 10/07/16.
 */

class Peacock(val context: Context) {

    fun getUtility(utility: Utility): Any? {
        when (utility) {
            Utility.TOAST -> return ToastUtil(context)

            Utility.ALERT -> return AlertUtil(context)

            else -> return null
        }
    }
}
