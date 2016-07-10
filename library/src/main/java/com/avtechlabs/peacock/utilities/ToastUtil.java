package com.avtechlabs.peacock.utilities;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by adhithyan-3592 on 10/07/16.
 */

public class ToastUtil{
    Context context;

    public ToastUtil(Context context){
        this.context = context;
    }

    public void showLongToast(String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public void showShortToast(String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
