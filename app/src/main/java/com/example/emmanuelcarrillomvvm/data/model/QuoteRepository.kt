package com.example.emmanuelcarrilloMVVM.data.model

import com.example.emmanuelcarrilloMVVM.data.model.network.QuoteService

class QuoteRepository {
    private val api=QuoteService()
    suspend fun getAllQuotes():List<QuoteModel>{
        val response =api.getQuotes()
        QuoteProvider.quotes=response
        return response
    }
}