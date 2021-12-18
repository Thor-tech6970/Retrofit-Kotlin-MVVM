package com.example.retrofitkotlinmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class QuotesRepository(private val quotesAPI: QuotesAPI) {

    private val quotesLiveData  =  MutableLiveData<QuoteList>()

    val quotes : LiveData<QuoteList>
    get() = quotesLiveData

    suspend fun getQuotes(page : Int){

        val result = quotesAPI.getQuotes(page)

        if(result!=null){
            quotesLiveData.postValue(result.body())
          }

    }

}