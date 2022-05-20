package com.example.emmanuelcarrilloMVVM.domain

import com.example.emmanuelcarrilloMVVM.data.model.QuoteModel
import com.example.emmanuelcarrilloMVVM.data.model.QuoteRepository

class GetQuotesUseCase {
    private val repository=QuoteRepository()
    suspend operator fun invoke():List<QuoteModel>?= repository.getAllQuotes()

}