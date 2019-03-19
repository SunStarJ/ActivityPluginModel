package com.sunstar.activityplugin.vm

import android.app.Activity
import android.view.View

class HeadVm(var headerName:String = "",var isBackShow:Boolean = true,var backImgResource:Int = -1){
    open fun LeftClick (view: View){
        var mContext = view.context
        if(mContext is Activity){
            (mContext as Activity).finish()
        }
    }
}