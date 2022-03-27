package com.example.viewhigh.isunnyweather.logic.network

import com.example.viewhigh.isunnyweather.App
import com.example.viewhigh.isunnyweather.logic.model.LoginInfo
import com.example.viewhigh.isunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.*

interface PlaceService {

    @GET("v2/place?token=${App.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}