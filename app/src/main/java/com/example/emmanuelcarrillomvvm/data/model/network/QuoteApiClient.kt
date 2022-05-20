package com.example.emmanuelcarrilloMVVM.data.model.network

import com.example.emmanuelcarrilloMVVM.core.RetrofitHelper
import com.example.emmanuelcarrilloMVVM.data.model.QuoteModel

import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes():retrofit2.Response<List<QuoteModel>>
}
