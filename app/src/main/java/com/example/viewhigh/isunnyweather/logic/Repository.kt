package com.example.viewhigh.isunnyweather.logic


import androidx.lifecycle.liveData
import com.example.viewhigh.isunnyweather.logic.model.LoginInfo
import com.example.viewhigh.isunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers

object Repository {

    suspend fun login3(): LoginInfo {
        return SunnyWeatherNetwork.login3()
    }

    fun searchPlaces(query: String) =
        liveData(Dispatchers.IO) {
            val result = try {
                val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
                if (placeResponse.status == "ok") {
                    val places = placeResponse.places
                    Result.success(places)
                } else {
                    Result.failure(RuntimeException("response status is ${placeResponse.status}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
            emit(result)
        }
}