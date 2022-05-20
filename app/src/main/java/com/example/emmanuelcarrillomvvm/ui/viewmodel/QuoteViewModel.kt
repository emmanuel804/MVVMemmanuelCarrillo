package com.example.emmanuelcarrilloMVVM.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.emmanuelcarrilloMVVM.data.model.QuoteModel
import com.example.emmanuelcarrilloMVVM.data.model.QuoteProvider
import com.example.emmanuelcarrilloMVVM.domain.GetQuotesUseCase
import com.example.emmanuelcarrilloMVVM.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {
    val quoteModel=MutableLiveData<QuoteModel>()
    val isLoading=MutableLiveData<Boolean>()
    var getQuotesUseCase=GetQuotesUseCase()
    var getRandomQuoteUseCase=GetRandomQuoteUseCase()
    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result:List<QuoteModel>? =getQuotesUseCase()
            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }
    fun randomQuote(){
        isLoading.postValue(true)
        val quote=getRandomQuoteUseCase()
        if(quote!=null){
            quoteModel.postValue(quote!!)
        }
        isLoading.postValue(false)
    }


}