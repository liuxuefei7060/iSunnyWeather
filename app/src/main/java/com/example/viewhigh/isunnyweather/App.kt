package com.example.viewhigh.isunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.viewhigh.isunnyweather.utils.LogUtil

class App : Application() {

    companion object {
        //彩云天气的令牌
        const val TOKEN = ""

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        LogUtil.init()
        context = this
    }

}