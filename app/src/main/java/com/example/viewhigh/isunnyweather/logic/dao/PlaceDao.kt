package com.example.viewhigh.isunnyweather.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.example.viewhigh.isunnyweather.App
import com.example.viewhigh.isunnyweather.logic.model.Place
import com.google.gson.Gson

object PlaceDao {

    fun savePlace(place: Place) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavedPlace(): Place {
        val placeJson = sharedPreferences().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")

    private fun sharedPreferences() =
        App.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)

}