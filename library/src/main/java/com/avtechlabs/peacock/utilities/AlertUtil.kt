package com.avtechlabs.peacock.utilities

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

/**
 * Created by adhithyan-3592 on 10/07/16.
 */

class AlertUtil(var context: Context) {
    private var isBuilded = false
    private var alertDialog: AlertDialog.Builder? = null

    fun build(title: String, message: String, okButtonText: String, okButtonListener: DialogInterface.OnClickListener) {
        alertDialog = AlertDialog.Builder(context).setTitle(title).setMessage(message).setPositiveButton(okButtonText, okButtonListener)

        isBuilded = true
    }

    @Throws(Exception::class)
    fun setNegativeButton(negativeButtonText: String, negativeButtonListener: DialogInterface.OnClickListener) {
        throwExceptionIfNotBuilded()
        alertDialog!!.setNegativeButton(negativeButtonText, negativeButtonListener)
    }

    @Throws(Exception::class)
    fun show() {
        throwExceptionIfNotBuilded()
        alertDialog!!.show()
    }

    @Throws(Exception::class)
    private fun throwExceptionIfNotBuilded() {
        if (!isBuilded)
            throw AlertNotBuildedException("Alert not builded. Call build() with title, message, ok listeners before calling this function")
    }

    internal inner class AlertNotBuildedException(message: String) : Exception(message)

}
