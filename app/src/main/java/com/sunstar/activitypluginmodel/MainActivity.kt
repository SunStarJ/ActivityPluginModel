package com.sunstar.activitypluginmodel

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.View

import com.sunstar.activityplugin.SSActivity
import com.sunstar.activityplugin.vm.HeadVm
import com.sunstar.activitypluginmodel.databinding.ActivityMainBinding
import com.sunstar.activitypluginmodel.testdata.UserName

class MainActivity : SSActivity() {
    override fun viewInitComplete() {
        binding!!.user = UserName("test")
    }

    override fun initHeadModel(): HeadVm {
        return HeadVm("测试", true, R.mipmap.back_test)
    }

    private var binding: ActivityMainBinding? = null

    override fun initView(): View {
        binding = DataBindingUtil.inflate<ActivityMainBinding>(LayoutInflater.from(this), R.layout.activity_main, null, false)
        return binding!!.root
    }
}
