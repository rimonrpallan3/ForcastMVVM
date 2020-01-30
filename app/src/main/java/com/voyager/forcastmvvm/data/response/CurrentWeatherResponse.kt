package com.voyager.forcastmvvm.data.response

import com.google.gson.annotations.SerializedName
import com.voyager.forcastmvvm.data.db.entry.CurrentWeatherEntry
import com.voyager.forcastmvvm.data.db.entry.Location
import com.voyager.forcastmvvm.data.db.entry.Request


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)