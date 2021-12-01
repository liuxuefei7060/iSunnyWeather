package com.example.viewhigh.isunnyweather.utils

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy


class LogUtil {
    companion object {

        /**
         * 初始化日子打印工具
         * @param tag     日志展示tag
         * @param enable  是否开启日子打印  默认是打开的
         * @param saveLog 是否保存日志到本地文件中，默认关闭
         */
        fun init(tag: String = "ViewHigh", enable: Boolean = true, saveLog: Boolean = false) {

            val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true) // (Optional) Whether to show thread info or not. Default true
                .methodCount(3) // (Optional) How many method line to show. Default 2
                .tag(tag) // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build()

//            Logger.addLogAdapter(DiskLogAdapter())

            Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
                override fun isLoggable(priority: Int, tag: String?): Boolean {
                    return enable
                }
            })
        }

        fun v(message: String) {
            Logger.v(message)
        }

        fun d(message: String) {
            Logger.d(message)
        }
        fun e(message: String) {
            Logger.e(message)
        }

        fun json(message: String) {
            Logger.json(message)
        }
    }
}