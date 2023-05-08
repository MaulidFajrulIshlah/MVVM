package com.geminiboy.mvvm.network

import com.geminiboy.mvvm.model.getAllUserItem
import retrofit2.http.GET

interface ApiService {

    @GET("user")
    fun getAllUser() : retrofit2.Call<List<getAllUserItem>>
}