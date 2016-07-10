package com.avtechlabs.peacock;

import android.content.Context;

import com.avtechlabs.peacock.enums.Utility;
import com.avtechlabs.peacock.utilities.AlertUtil;
import com.avtechlabs.peacock.utilities.ToastUtil;

/**
 * Created by adhithyan-3592 on 10/07/16.
 */

public class Peacock {

    public Object getUtility(Context context, Utility utility){
        switch(utility){
            case TOAST:
                return ToastUtil.class.cast(new ToastUtil(context));

            case ALERT:
                return AlertUtil.class.cast(new AlertUtil(context));
            default:
                return null;
        }
    }
}
