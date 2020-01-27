package com.voyager.forcastmvvm.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.voyager.forcastmvvm.data.response.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val  API_KEY = "c408e9a5abe51b86f172a50a3c03bce7"
//http://api.weatherstack.com/current?access_key=c408e9a5abe51b86f172a50a3c03bce7&query=New%20York&lang=en
//http://api.weatherstack.com/current?access_key=YOUR_ACCESS_KEY&query=New York&lang=en

interface ApixuWeatherApiService {

  @GET("current")
  fun getCurrentWeather(
      @Query("query") location: String,
      @Query("lang") languageCode: String): Deferred<CurrentWeatherResponse>

    companion object {
        operator  fun  invoke(): ApixuWeatherApiService {
            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("api.weatherstack.com/current?access")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiService::class.java)

        }
    }
}