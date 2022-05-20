package com.example.emmanuelcarrilloMVVM.domain

import com.example.emmanuelcarrilloMVVM.data.model.QuoteModel
import com.example.emmanuelcarrilloMVVM.data.model.QuoteProvider
import com.example.emmanuelcarrilloMVVM.data.model.QuoteRepository
import com.example.emmanuelcarrilloMVVM.ui.viewmodel.QuoteViewModel

class GetRandomQuoteUseCase {
    private val repository=QuoteRepository()
    operator fun invoke(): QuoteModel?{
        val quotes=QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber:Int=(quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}