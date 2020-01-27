package com.voyager.forcastmvvm.data.response

import com.google.gson.annotations.SerializedName
import com.voyager.forcastmvvm.data.response.CurrentWeatherEntry
import com.voyager.forcastmvvm.data.response.Location
import com.voyager.forcastmvvm.data.response.Request


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)