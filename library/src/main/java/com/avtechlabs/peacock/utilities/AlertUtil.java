package com.avtechlabs.peacock.utilities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by adhithyan-3592 on 10/07/16.
 */

public class AlertUtil {
    public Context context;
    private boolean isBuilded = false;
    private AlertDialog.Builder alertDialog;

    public AlertUtil(Context context){
        this.context = context;
    }

    public void build(String title, String message, String okButtonText, DialogInterface.OnClickListener okButtonListener){
        alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(okButtonText, okButtonListener);
    }

    public void show() throws Exception{
        if(!isBuilded)
            throw new AlertNotBuildedException("Alert not builded. Call build() with title, message, ok and cancel listeners");

        alertDialog.show();
    }

    class AlertNotBuildedException extends Exception{
        AlertNotBuildedException(String message){
            super(message);
        }
    }

}