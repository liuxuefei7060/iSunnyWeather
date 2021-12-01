package com.example.viewhigh.isunnyweather.ui.place

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewhigh.isunnyweather.logic.Repository
import com.example.viewhigh.isunnyweather.logic.model.Place
import kotlinx.coroutines.launch

class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    fun login3() {
        viewModelScope.launch {
            val loginInfo = Repository.login3()
            Log.e("Test", "----" + loginInfo.message)
        }
    }
}