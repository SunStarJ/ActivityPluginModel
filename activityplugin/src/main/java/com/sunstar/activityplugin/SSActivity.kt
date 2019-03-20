package com.sunstar.activityplugin

import android.content.Context
import android.databinding.DataBindingUtil
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.sunstar.activityplugin.vm.HeadVm
import com.sunstar.activityplugin.databinding.SsLayoutBinding
import kotlinx.android.synthetic.main.ss_layout.*

abstract class SSActivity : AppCompatActivity() {
    lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        var ssBinding = DataBindingUtil.inflate<SsLayoutBinding>(LayoutInflater.from(mContext), R.layout.ss_layout, null, false)
        var vm = HeadVm("测试", true)
        var headerModel = initHeadModel()
        ssBinding.header = headerModel
        setContentView(ssBinding.root)
        ssBinding.root.findViewById<LinearLayout>(R.id.body_view).addView(initView(),LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        base_tool_bar.title = ""
        if (headerModel.isBackShow && headerModel.backImgResource != -1) {
            base_tool_bar.navigationIcon = mContext.resources.getDrawable(headerModel.backImgResource)
        }

        setSupportActionBar(base_tool_bar)
        base_tool_bar.setNavigationOnClickListener {
            backClick()
        }
        setTitleText()
        viewInitComplete()

    }

    private fun setTitleText() {
        title_text.setTextColor(mContext.resources.getColor(R.color.primary_material_light))
        title_text.textSize = 18f
        title_text.typeface = Typeface.DEFAULT_BOLD
    }

    fun getTitleText():TextView = title_text

    fun changeText(titleName:String){
        title_text.text = titleName
    }

    fun showTittleBar(){
        supportActionBar!!.show()
    }

    fun hiddenTitleBar(){
        supportActionBar!!.hide()
    }

    open fun setTitleBackGround(backgroundResource:Int){
        supportActionBar!!.setBackgroundDrawable(mContext.resources.getDrawable(backgroundResource))
    }

    open fun backClick() {
        super.onBackPressed()
    }
    abstract fun viewInitComplete()
    abstract fun initView(): View
    abstract fun initHeadModel(): HeadVm
}
