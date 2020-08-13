package com.example.dagger2example.network

import com.example.dagger2example.model.PostInfo
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("posts")
    fun makeRequest(): Call<List<PostInfo>>
}