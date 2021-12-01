package com.example.viewhigh.isunnyweather.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import okhttp3.logging.HttpLoggingInterceptor

class HttpLog : HttpLoggingInterceptor.Logger {

    private var messageBuilder = StringBuilder()

    override fun log(message: String) {
        //判定记录开始
        // -->  标示发出请求
        // --<  标示输入的
        // -->GET get请求开始
        // -->POST get请求开始
//        Log.e("Okhttp", message)

        if (message.startsWith("--> GET")
            || message.startsWith("--> POST")
            || message.startsWith("--> PUT")
            || message.startsWith("--> DELETE")
            || isResponseStart(message)
        ) {
            messageBuilder = StringBuilder();
        }

        if ((message.startsWith("{") && message.endsWith("}"))
            || (message.startsWith("[") && message.endsWith("]"))
        ) {
            messageBuilder.append(toPrettyFormat(message)).append("\n")
        } else {
            messageBuilder.append("$message \n");
        }
        if (message.startsWith("<-- END HTTP")
            || message.startsWith("--> END GET")
            || message.startsWith("--> END POST")
            || message.startsWith("<-- HTTP")
        ) {
            val msg = messageBuilder.toString()
            if (message.contains("FAILED")) {
                LogUtil.e(msg)
            } else {
                LogUtil.d(msg)
            }
            messageBuilder = messageBuilder
        }
    }

    private fun isResponseStart(message: String): Boolean {
        if (message.startsWith("<--")
            && (message.contains("http://") || message.contains("https://"))
        ) {
            return true
        }
        return false
    }


    /**
     * 使用Gson工具格式化Json展示
     */
    private fun toPrettyFormat(json: String): String {
        val jsonObject: JsonObject = JsonParser.parseString(json).asJsonObject
        val gson: Gson = GsonBuilder().setPrettyPrinting().create()
        return gson.toJson(jsonObject)
    }
}