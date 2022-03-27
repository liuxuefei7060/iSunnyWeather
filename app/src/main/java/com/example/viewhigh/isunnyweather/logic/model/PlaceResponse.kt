package com.example.viewhigh.isunnyweather.logic.model

import com.google.gson.annotations.SerializedName

data class PlaceResponse(val status: String, val places: List<Place>)

data class Place(
    val name: String,
    val location: Location,
    //由于JSON中的一些字段的命名可能与kotlin中命名规范不太一致，因此这里使用@SerializedName注解的方式来让
    //JSON字段和Kotlin字段建立映射关系
    @SerializedName("formatted_address") val address: String
)

data class Location(val lng: String, val lat: String)