package com.sunstar.activityplugin.vm

import android.app.Activity
import android.databinding.BaseObservable
import android.view.View

class HeadVm(var headerName:String = "",var isBackShow:Boolean = true,var backImgResource:Int = -1):BaseObservable(){
    open fun LeftClick (view: View){
        var mContext = view.context
        if(mContext is Activity){
            (mContext as Activity).finish()
        }
    }
}